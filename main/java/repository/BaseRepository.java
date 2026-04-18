package repository;

import models.Student;
import models.mappers.Mapper;
import services.DatabaseService;

import java.sql.*;

abstract public class BaseRepository<T> implements IRepository<T>{

    abstract String getInsertQuery();
    abstract String getUpdateQuery();
    abstract Mapper<T> getMapper();
    abstract String tableName();
    abstract void setPstmCreate(PreparedStatement pstm, T obj) throws SQLException;
    abstract void setPstmUpdate(PreparedStatement pstm, T obj) throws SQLException;

    public T create(T obj){
        String query = this.getInsertQuery();
        try(
                Connection connection = DatabaseService.getConnection();
                PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ){
            this.setPstmCreate(pstm, obj);

            pstm.executeUpdate();

            ResultSet res = pstm.getGeneratedKeys();
            if(res.next()){
                int id = res.getInt(1);
                return this.getById(id);
            }
        }catch (Exception e){

        }
        return null;
    }

    public T update(T obj){
        String query = this.getUpdateQuery();
        try(
                Connection connection = DatabaseService.getConnection();
                PreparedStatement pstm = connection.prepareStatement(query);
        ){
            this.setPstmUpdate(pstm, obj);
            pstm.executeUpdate();
        }catch (Exception e){

        }
        return obj;
    }

    public T getById(int id){
        String query = "SELECT * FROM " + tableName() + " WHERE id = ?";

//        Connection conn = DatabaseService.getConnection();
//        PreparedStatement pstm = null;
//        try{
//            pstm = connection.prepareStatement(query);
//            pstm.setInt(1, id);
//            ResultSet res = pstm.executeQuery();
//            if(res.next()){
//                return mapper.getFromResultSet(res);
//            }
//            return null;
//        }catch (Exception e){
//
//        }finally {
//            try{
//                connection.close();
//                if(pstm != null)
//                    pstm.close();
//
//            }catch (Exception e){
//
//            }
//        }

        try (
                Connection connection = DatabaseService.getConnection();
                PreparedStatement pstm = connection.prepareStatement(query);
        ){
            pstm.setInt(1, id);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                return getMapper().getFromResultSet(res);
            }
        }catch (Exception e){

        }

        return null;
    }

    public boolean delete(int objId){
        String query = "DELETE FROM " + tableName() + " WHERE id = ?";
        try(
                Connection connection = DatabaseService.getConnection();
                PreparedStatement pstm = connection.prepareStatement(query);
        ){
            pstm.setInt(1, objId);

            return pstm.executeUpdate() > 0;
        }catch (Exception e){

        }
        return false;
    }


}
