package group_03.repository;

import java.util.List;

public interface Repository<T, DTO> {
    T getById(int id);

    List<T> getAll();

    T create(DTO obj);

    T update(int id, DTO obj);

    boolean delete(int id);
}
