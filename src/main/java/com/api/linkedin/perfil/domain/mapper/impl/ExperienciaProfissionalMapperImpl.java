package com.api.linkedin.perfil.domain.mapper.impl;

import com.api.linkedin.perfil.domain.mapper.ExperienciaProfissionalMapper;
import com.api.linkedin.perfil.domain.model.experienciaprofissional.ExperienciaProfissionalEntrada;
import com.api.linkedin.perfil.domain.model.experienciaprofissional.ExperienciaProfissionalSaida;
import com.api.linkedin.perfil.domain.model.localidade.LocalidadeEntrada;
import com.api.linkedin.perfil.domain.model.localidade.LocalidadeSaida;
import com.api.linkedin.perfil.entity.ExperienciaProfissional;
import com.api.linkedin.perfil.entity.Localidade;
import com.api.linkedin.utils.enums.TipoEmprego;

import java.util.List;

public class ExperienciaProfissionalMapperImpl implements ExperienciaProfissionalMapper {
    @Override
    public ExperienciaProfissionalSaida mapToSaida(ExperienciaProfissional entity) {
        ExperienciaProfissionalSaida saida = new ExperienciaProfissionalSaida();
        saida.setId(entity.getId());
        saida.setIdPerfil(entity.getIdPerfil());
        saida.setCargo(entity.getCargo());
        saida.setTipoEmprego(entity.getTipoEmprego());
        saida.setDescricao(entity.getDescricao());
        saida.setEmpresa(entity.getEmpresa());
        saida.setTrabalhoAtual(entity.getTrabalhoAtual());
        saida.setMesInicio(entity.getMesInicio());
        saida.setMesFim(entity.getMesFim());
        saida.setLocalidade(mapToSaida(entity.getLocalidade()));
        return saida;
    }

    @Override
    public ExperienciaProfissionalSaida mapToSaida(List<ExperienciaProfissional> entity) {
        return null;
    }

    @Override
    public ExperienciaProfissional mapToEntityUpdate(ExperienciaProfissionalEntrada experienciaProfissionalEntrada, ExperienciaProfissional banco) {
        return null;
    }

    @Override
    public ExperienciaProfissional mapToEntity(ExperienciaProfissionalEntrada entrada, Long idPerfil) {
        ExperienciaProfissional entity = new ExperienciaProfissional();

        entity.setIdPerfil(idPerfil);
        entity.setCargo(entrada.getCargo());
        entity.setTipoEmprego(TipoEmprego.get(entrada.getTipoEmprego()));
        entity.setDescricao(entrada.getDescricao());
        entity.setEmpresa(entrada.getEmpresa());
        entity.setTrabalhoAtual(entrada.getTrabalhoAtual());
        entity.setMesInicio(entrada.getMesInicio());
        entity.setMesFim(entrada.getMesFim());
        entity.setLocalidade(mapToEntity(entrada.getLocalidade()));
        return entity;
    }

    private Localidade mapToEntity(LocalidadeEntrada localidadeEntrada){
        Localidade localidade = new Localidade();
        localidade.setCidade(localidadeEntrada.getCidade());
        localidade.setEstado(localidadeEntrada.getEstado());
        localidade.setPais(localidadeEntrada.getPais());
        return localidade;
    }

    private LocalidadeSaida mapToSaida(Localidade entity){
        LocalidadeSaida localidade = new LocalidadeSaida();
        localidade.setCidade(entity.getCidade());
        localidade.setEstado(entity.getEstado());
        localidade.setPais(entity.getPais());
        return localidade;
    }
}
