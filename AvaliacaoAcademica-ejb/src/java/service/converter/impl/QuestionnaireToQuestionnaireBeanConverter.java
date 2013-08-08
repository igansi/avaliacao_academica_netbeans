/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.converter.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.List;
import repository.entities.Pergunta;
import repository.entities.Questionario;
import service.api.bean.QuestionBean;
import service.api.bean.QuestionnaireBean;
import service.converter.api.Converter;

/**
 * Conversor de uma entidade questionário para um questionario bean de troca.
 * @author Igansi
 */
public class QuestionnaireToQuestionnaireBeanConverter implements Converter<Questionario, QuestionnaireBean> {

    @Override
    public QuestionnaireBean convert(Questionario questionnaire) {
        List<QuestionBean> questionsBean = Lists.transform(Lists.newArrayList(questionnaire.getPerguntaCollection()),
                new Function<Pergunta, QuestionBean>() {
            @Override
            public QuestionBean apply(Pergunta question) {
                return new QuestionToQuestionBeanConverter().convert(question);
            }
        });

        return new QuestionnaireBean(questionnaire.getTitulo(), questionsBean);
    }
}
