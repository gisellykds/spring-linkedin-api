package com.api.linkedin.perfil.domain.mapper.impl;

import com.api.linkedin.perfil.domain.mapper.FormacaoAcademicaMapper;
import com.api.linkedin.perfil.domain.model.formacaoacademica.FormacaoAcademicaEntrada;
import com.api.linkedin.perfil.domain.model.formacaoacademica.FormacaoAcademicaSaida;
import com.api.linkedin.perfil.entity.FormacaoAcademica;

import java.util.List;

public class FormacaoAcademicaMapperImpl implements FormacaoAcademicaMapper {
    @Override
    public FormacaoAcademica mapToEntity(FormacaoAcademicaEntrada entrada, Long idPerfil) {
        FormacaoAcademica entity = new FormacaoAcademica();
        entity.setIdPerfil(idPerfil);
        entity.setFormacao(entrada.getFormacao());
        entity.setAreaEstudo(entrada.getAreaEstudo());
        entity.setAnoInicio(entrada.getAnoInicio());
        entity.setAnoFim(entrada.getAnoFim());
        entity.setNota(entrada.getNota());
        entity.setDescricao(entrada.getDescricao());
        entity.setInstituicao(entrada.getInstituicao());
        return entity;
    }

    @Override
    public FormacaoAcademica mapToEntityUpdate(FormacaoAcademicaEntrada formacaoAcademicaEntrada, FormacaoAcademica banco) {
        return null;
    }

    @Override
    public FormacaoAcademicaSaida mapToSaida(FormacaoAcademica entity) {
        FormacaoAcademicaSaida saida = new FormacaoAcademicaSaida();
        saida.setId(entity.getId());
        saida.setId(entity.getIdPerfil());
        saida.setFormacao(entity.getFormacao());
        saida.setAreaEstudo(entity.getAreaEstudo());
        saida.setAnoInicio(entity.getAnoInicio());
        saida.setAnoFim(entity.getAnoFim());
        saida.setNota(entity.getNota());
        saida.setDescricao(entity.getDescricao());
        saida.setInstituicao(entity.getInstituicao());
        return saida;
    }

    @Override
    public FormacaoAcademicaSaida mapToSaida(List<FormacaoAcademica> entity) {
        return null;
    }
}
