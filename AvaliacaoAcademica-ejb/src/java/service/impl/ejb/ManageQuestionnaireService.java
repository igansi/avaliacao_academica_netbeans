package service.impl.ejb;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import repository.entities.Pergunta;
import repository.entities.Questionario;
import repository.impl.dao.jpa.GenericDaoImpl;
import service.api.bean.QuestionBean;
import service.api.bean.QuestionnaireBean;
import service.api.ejb.ManageQuestionnaireServiceRemote;
import service.converter.impl.QuestionBeanToQuestionConverter;
import service.converter.impl.QuestionnaireToQuestionnaireBeanConverter;

/**
 * Define o serviço de gerência de questionários.
 * @author Igansi
 */
@Stateless
public class ManageQuestionnaireService implements ManageQuestionnaireServiceRemote {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createQuestionnaire(QuestionnaireBean questionnaireBean) {
        List<Pergunta> questions = Lists.transform(Lists.newArrayList(questionnaireBean.getQuestions()),
                new Function<QuestionBean, Pergunta>() {
            @Override
            public Pergunta apply(QuestionBean question) {
                return new QuestionBeanToQuestionConverter().convert(question);
            }
        });
        new GenericDaoImpl<Questionario>(entityManager).create(new Questionario(questionnaireBean.getTitle(), questions));
    }

    @Override
    public List<QuestionnaireBean> findAll() {
        List<Questionario> questionnaires = new GenericDaoImpl<Questionario>(entityManager).findAll();

        return Lists.transform(questionnaires, new Function<Questionario, QuestionnaireBean>() {
            @Override
            public QuestionnaireBean apply(Questionario questionnaire) {
                return new QuestionnaireToQuestionnaireBeanConverter().convert(questionnaire);
            }
        });
    }
}
