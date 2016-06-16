package br.com.crescer.aula4.run;

import java.util.List;

/**
 * @author Carlos H. Nonnemacher
 * @param <T>
 */
public interface IDAO<T> {

    void insert(T t);

    void update(T t);

    void delete(T t);

    T load(Object id);

    List<T> listAll();

}
