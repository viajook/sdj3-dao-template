package via.sdj3.distributedobjectsexample.dao;

import java.util.List;
import java.util.Optional;

public interface DaoApi<T> {
    Optional<T> get(long id);
    List<T> getAll();
    void save(T t);
    boolean update(long id, T updated);
    // not so generic -;)
    void update(T t, String[] params, double price, int qty);

    void delete(T t);
}
