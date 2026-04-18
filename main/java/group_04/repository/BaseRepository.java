package group_04.repository;

import group_04.mapper.IMapper;
import group_04.models.Student;
import services.DatabaseService;

import java.sql.*;

abstract public class BaseRepository<T> implements IRepository<T> {
    private String tableName;
    private IMapper<T> mapper;
    private String createQuery;
    private String updateQuery;

    abstract void setCreatePreparedStatementPlaceholders(PreparedStatement pstm, T obj) throws SQLException;
    abstract void setUpdatePreparedStatementPlaceholders(PreparedStatement pstm, T obj) throws SQLException;

    public BaseRepository(
            String tableName,
            IMapper<T> mapper,
            String createQuery,
            String updateQuery
    ){
        this.tableName = tableName;
        this.mapper = mapper;
        this.createQuery = createQuery;
        this.updateQuery = updateQuery;
    }

    public T getById(int id) {
        String query ="SELECT * FROM "+ this.tableName + " WHERE id = ?";
        try(
                Connection conn = DatabaseService.getConnection();
                PreparedStatement pstm = conn.prepareStatement(query);
        ){
            pstm.setInt(1, id);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                return this.mapper.fromResultSet(res);
            }
        }catch (SQLException e){
//            Syso
        }
        return null;
    }

    public T create(T obj) {
        try(
                Connection conn = DatabaseService.getConnection();
                PreparedStatement pstm = conn.prepareStatement(this.createQuery, Statement.RETURN_GENERATED_KEYS);
        ){

            this.setCreatePreparedStatementPlaceholders(pstm, obj);

            pstm.executeUpdate();
            ResultSet res = pstm.getGeneratedKeys();
            if(res.next()){
                int id = res.getInt(1);
                return this.getById(id);
            }
        }catch (SQLException e){

        }
        return null;
    }


    public T update(T obj) {
        try(
                Connection conn = DatabaseService.getConnection();
                PreparedStatement pstm = conn.prepareStatement(updateQuery);
        ){
            this.setUpdatePreparedStatementPlaceholders(pstm, obj);

            int updated = pstm.executeUpdate();
            if(updated != 0){
                return obj;
            }
        }catch (Exception e){

        }
        return null;
    }

    public boolean delete(int id) {
        String query = "DELETE FROM " + this.tableName + " WHERE id = ?";
        try(
                Connection conn = DatabaseService.getConnection();
                PreparedStatement pstm = conn.prepareStatement(query);
        ){
            pstm.setInt(1, id);
            return pstm.executeUpdate() == 1;
        }catch (Exception e){

        }
        return false;
    }

}
