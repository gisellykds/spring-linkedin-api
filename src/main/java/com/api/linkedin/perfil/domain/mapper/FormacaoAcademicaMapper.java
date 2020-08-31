package com.api.linkedin.perfil.domain.mapper;

import com.api.linkedin.perfil.domain.model.formacaoacademica.FormacaoAcademicaEntrada;
import com.api.linkedin.perfil.domain.model.formacaoacademica.FormacaoAcademicaSaida;
import com.api.linkedin.perfil.entity.FormacaoAcademica;

import java.util.List;

public interface FormacaoAcademicaMapper {
    public FormacaoAcademica mapToEntity(FormacaoAcademicaEntrada formacaoAcademicaEntrada, Long idPerfil);

    public FormacaoAcademica mapToEntityUpdate(FormacaoAcademicaEntrada formacaoAcademicaEntrada, FormacaoAcademica banco);


    public FormacaoAcademicaSaida mapToSaida(FormacaoAcademica entity);


    public FormacaoAcademicaSaida mapToSaida(List<FormacaoAcademica> entity);
}
