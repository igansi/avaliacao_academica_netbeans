/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.api.dao;

import java.util.List;

/**
 * Protocolo que DAOs genéricos de entidades devem cumprir.
 * @author Igansi
 * @param <T> Tipo da entidade a ser persistida
 */
public interface GenericDao<T> {
    
    /**
     * Cria uma entidade.
     * @param entity Entidade a ser salva
     */
    void create(T entity);
    
    /**
     * Remove uma entidade.
     * @param entity Entidade a ser removida
     */
    void remove(T entity);
    
    /**
     * Atualiza uma entidade.
     * @param entity Entidade a ser atualizada
     * @return Entidade atualizada
     */
    T update(T entity);
    
    /**
     * Busca uma entidade pelo seu identificador.
     * @param id Identificador da entidade
     * @return Entidade recuperada
     */
    T findById(long id);
    
    /**
     * Retorna todas as entidades.
     * @return Entidades encontradas
     */
    List<T> findAll();
}
