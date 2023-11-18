package lk.rms.dao;

import lk.rms.entity.SuperEntity;
import lombok.SneakyThrows;

import java.util.ArrayList;

public interface CrudDAO<T extends SuperEntity, ID> extends SuperDAO {
    @SneakyThrows
    ArrayList<T> getAll();

    @SneakyThrows
    boolean save(T entity);

    @SneakyThrows
    boolean update(T entity);

    @SneakyThrows
    boolean delete(ID id);

    @SneakyThrows
    T search(ID id);

    @SneakyThrows
    boolean isExists(ID id);

    @SneakyThrows
    String generateNewID();
}
