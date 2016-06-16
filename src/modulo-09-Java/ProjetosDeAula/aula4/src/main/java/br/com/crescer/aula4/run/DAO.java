package br.com.crescer.aula4.run;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;

/**
 * @author Carlos H. Nonnemacher
 */
public abstract class DAO<T> implements IDAO<T> {

    public abstract EntityManager getEntityManager();

    public final Class<T> type;

    public DAO(Class<T> type) {
        this.type = type;
    }

    @Override
    public void insert(T t) {
        this.getEntityManager().persist(t);
    }

    @Override
    public void update(T t) {
        this.getEntityManager().merge(t);
    }

    @Override
    public void delete(T t) {
        this.getEntityManager().remove(t);
    }

    @Override
    public T load(Object id) {
        return this.getEntityManager().find(type, id);
    }

    @Override
    public  List<T> listAll() {
        Session session = this.getEntityManager().unwrap(Session.class);
        return session.createCriteria(type).list();
    }
}
