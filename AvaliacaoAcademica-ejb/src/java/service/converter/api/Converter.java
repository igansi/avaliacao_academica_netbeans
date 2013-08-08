/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.converter.api;

/**
 * /**
 * Protocolo que conversores devem cumprir.
 * @author Igansi
 * @param <S> Objeto origem
 * @param <T> Objeto destino
 */
public interface Converter<S, T> {
    
    /**
     * Converte o objeto origem no objeto destino
     * @param source Objeto origem
     * @return Objeto destino
     */
    T convert(S source);
}
