package service.impl.ejb;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import repository.entities.Usuario;
import repository.impl.dao.jpa.GenericDaoImpl;
import service.api.bean.UserBean;
import service.api.ejb.ManageUserServiceRemote;
import service.converter.impl.UserToUserBeanConverter;

/**
 * Defie o serviço de gerência de usuários.
 * @author Igansi
 */
@Stateless
public class ManageUserService implements ManageUserServiceRemote {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(UserBean userBean) {
        new GenericDaoImpl<Usuario>(entityManager).create(new Usuario(
                userBean.getNome(), userBean.getCpf(), userBean.getEmail(), userBean.getDataNascimento(), userBean.getTipo()));
    }

    @Override
    public List<UserBean> findAll() {
        List<Usuario> users = new GenericDaoImpl<Usuario>(entityManager).findAll();
        
        return Lists.transform(users, new Function<Usuario, UserBean>() {
            @Override
            public UserBean apply(Usuario user) {
                return new UserToUserBeanConverter().convert(user);
            }
        });
    }
}
