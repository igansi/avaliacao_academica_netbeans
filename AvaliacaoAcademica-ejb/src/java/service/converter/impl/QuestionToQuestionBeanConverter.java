/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.converter.impl;

import repository.entities.Pergunta;
import service.api.bean.QuestionBean;
import service.converter.api.Converter;

/**
 * Conversor de uma entidade pergunta para uma pergunta bean de troca.
 *
 * @author Igansi
 */
public class QuestionToQuestionBeanConverter implements Converter<Pergunta, QuestionBean> {

    @Override
    public QuestionBean convert(Pergunta question) {
        return new QuestionBean(question.getTipo(), question.getQuestao());
    }
}
