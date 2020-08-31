package com.api.linkedin.perfil.domain.mapper.impl;

import com.api.linkedin.perfil.domain.mapper.LicencaCertificadoMapper;
import com.api.linkedin.perfil.domain.model.licencacertificado.LicencaCertificadoEntrada;
import com.api.linkedin.perfil.domain.model.licencacertificado.LicencaCertificadoSaida;
import com.api.linkedin.perfil.entity.LicencaCertificado;

import java.util.List;

public class LicencaCertificadoMapperImpl implements LicencaCertificadoMapper {
    @Override
    public LicencaCertificado mapToEntity(LicencaCertificadoEntrada entrada, Long idPerfil) {
        LicencaCertificado entity = new LicencaCertificado();
        entity.setIdPerfil(idPerfil);
        entity.setNome(entrada.getNome());
        entity.setOrganizacaoEmissora(entrada.getOrganizacaoEmissora());
        entity.setCodigoCredencial(entrada.getCodigoCredencial());
        entity.setUrlCredencial(entrada.getUrlCredencial());
        entity.setCertificacaoExpira(entrada.getCertificacaoExpira());
        entity.setMesAnoEmissao(entrada.getMesAnoEmissao());
        entity.setMesAnoExpiracao(entrada.getMesAnoExpiracao());
        return entity;
    }

    @Override
    public LicencaCertificadoSaida mapToSaida(LicencaCertificado entity) {
        LicencaCertificadoSaida saida = new LicencaCertificadoSaida();
        saida.setId(entity.getId());
        saida.setIdPerfil(entity.getIdPerfil());
        saida.setNome(entity.getNome());
        saida.setOrganizacaoEmissora(entity.getOrganizacaoEmissora());
        saida.setCodigoCredencial(entity.getCodigoCredencial());
        saida.setUrlCredencial(entity.getUrlCredencial());
        saida.setCertificacaoExpira(entity.getCertificacaoExpira());
        saida.setMesAnoEmissao(entity.getMesAnoEmissao());
        saida.setMesAnoExpiracao(entity.getMesAnoExpiracao());
        return saida;
    }

    @Override
    public LicencaCertificado mapToEntityUpdate(LicencaCertificadoEntrada licencaCertificadoEntrada, LicencaCertificado banco) {
        return null;
    }

    @Override
    public List<LicencaCertificadoSaida> mapToSaida(List<LicencaCertificado> entity) {
        return null;
    }
}
