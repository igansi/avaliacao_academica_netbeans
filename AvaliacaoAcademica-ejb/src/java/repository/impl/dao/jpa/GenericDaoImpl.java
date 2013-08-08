/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl.dao.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import repository.api.dao.GenericDao;

/**
 * Implementação de referência para uma DAO genérico.
 * @author Igansi
 * @param <T> Tipo da entidade a ser persistida
 */
public class GenericDaoImpl<T> implements GenericDao<T> {

    private EntityManager entityManager;

    public GenericDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public T findById(long id) {
        return (T) entityManager.find(getTypeClass(), Long.valueOf(id));
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery(String.format("From %s", getTypeClass().getName())).getResultList();
    }
    
    private Class<?> getTypeClass() {
        return (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
