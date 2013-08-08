package service.impl.ejb;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.List;
import service.api.ejb.ManageQuestionServiceRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import repository.entities.Pergunta;
import repository.impl.dao.jpa.GenericDaoImpl;
import service.api.bean.QuestionBean;
import service.converter.impl.QuestionToQuestionBeanConverter;

/**
 * Defie o serviço de gerência de questões.
 * @author Igansi
 */
@Stateless
public class ManageQuestionService implements ManageQuestionServiceRemote {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createQuestion(QuestionBean questionBean) {
        new GenericDaoImpl<Pergunta>(entityManager).create(new Pergunta(questionBean.getQuestion(), questionBean.getType()));

    }

    @Override
    public List<QuestionBean> findAll() {
        List<Pergunta> questions = new GenericDaoImpl<Pergunta>(entityManager).findAll();
        
        return Lists.transform(questions, new Function<Pergunta, QuestionBean>() {
            @Override
            public QuestionBean apply(Pergunta question) {
                return new QuestionToQuestionBeanConverter().convert(question);
            }
        });
    }
}
