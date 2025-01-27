package jpa.DAO;

import jpa.EntityManagerHelper;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
//@Repository
//@Primary

public abstract class JPADAO <K, T extends Serializable> {
    long id;
    private Class<T> clazz;

    public EntityManager entityManager;

    public JPADAO(Class<T> clazzToSet) {

        this.entityManager = EntityManagerHelper.getEntityManager();
        this.clazz= clazzToSet;
    }

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(K id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("select e from " + clazz.getName() + " as e",clazz).getResultList();
    }

    public void save(T entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.persist(entity);
        t.commit();
    }
    public T update(final T entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        T res = entityManager.merge(entity);
        t.commit();
        return res;
    }
    public void delete(T entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(entity);
        t.commit();
    }
    public void deleteById(K entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
}
