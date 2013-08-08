package service.converter.impl;

import repository.entities.Pergunta;
import service.api.bean.QuestionBean;
import service.converter.api.Converter;

/**
 * Conversor de uma pergunta bean de troca oara uma entidade pergunta.
 * @author Igansi
 */
public class QuestionBeanToQuestionConverter implements Converter<QuestionBean, Pergunta> {

    @Override
    public Pergunta convert(QuestionBean question) {
        return new Pergunta(question.getQuestion(), question.getType());
    }
}
