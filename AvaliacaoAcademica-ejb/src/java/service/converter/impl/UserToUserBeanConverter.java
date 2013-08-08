/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.converter.impl;

import repository.entities.Usuario;
import service.api.bean.UserBean;
import service.converter.api.Converter;

/**
 * Conversor de uma entidade usuário para um usuário bean de troca.
 * @author Igansi
 */
public class UserToUserBeanConverter implements Converter<Usuario, UserBean> {

    @Override
    public UserBean convert(Usuario user) {
        return new UserBean(user.getCpf(), user.getDataNascimento(), user.getEmail(), user.getNome(), user.getTipo());
    }
}
