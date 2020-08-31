package com.api.linkedin.utils.validation;

import com.api.linkedin.utils.enums.Status;
import com.api.linkedin.utils.enums.StatusVaga;
import com.api.linkedin.utils.exception.response.ApiLinkedinException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class ValidationUtil {

    @Autowired
    private MessageSource messageSource;

    private Locale locale = new Locale("pt", "BR");

    protected void verificaIsPresente(Optional<?> optional, String codErro){
        if (!optional.isPresent())
            throw new ApiLinkedinException(HttpStatus.NOT_FOUND, getMessage(codErro));
    }

    protected void verificaIsInativa(Status status, String codErro){
        if (status.equals(Status.INATIVO))
            throw new ApiLinkedinException(HttpStatus.BAD_REQUEST, getMessage(codErro));
    }

    protected void verificaIsInativa(StatusVaga statusEnum, String codErro){
        if (statusEnum.equals(Status.INATIVO))
            throw new ApiLinkedinException(HttpStatus.BAD_REQUEST, getMessage(codErro));
    }

    protected void verificaIsAtiva(Status status, String codErro) {
        if (status.equals(Status.ATIVO))
            throw new ApiLinkedinException(HttpStatus.BAD_REQUEST, getMessage(codErro));
    }

    protected void verificaIsNotNull(Object object, String codErro){
        if (object.equals(null))
            throw new ApiLinkedinException(HttpStatus.NOT_FOUND, getMessage(codErro));
    }

    protected void verificaIsNull(Object object, String codErro){
        if (!object.equals(null))
            throw new ApiLinkedinException(HttpStatus.BAD_REQUEST, getMessage(codErro));
    }

    protected void verificaListaVazia(List<?> list){
        if (list.isEmpty() || list.equals(null))
            throw new ApiLinkedinException(HttpStatus.NO_CONTENT, getMessage("COD-1"));
    }

    private String getMessage(String codigo){
        return messageSource.getMessage(codigo, null, locale);
    }
}
