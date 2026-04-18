package group_04.repository;

public interface IRepository<T> {
//    getById, create, update, delete
    T getById(int id);
    T create(T obj);
    T update(T obj);
    boolean delete(int id);
}
