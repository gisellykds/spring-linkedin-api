package com.api.linkedin.perfil.domain.mapper;

import com.api.linkedin.perfil.domain.model.licencacertificado.LicencaCertificadoEntrada;
import com.api.linkedin.perfil.domain.model.licencacertificado.LicencaCertificadoSaida;
import com.api.linkedin.perfil.entity.LicencaCertificado;

import java.util.List;

public interface LicencaCertificadoMapper {

    public LicencaCertificado mapToEntity(LicencaCertificadoEntrada licencaCertificadoEntrada, Long idPerfil);

    public LicencaCertificadoSaida mapToSaida(LicencaCertificado entity);

    public LicencaCertificado mapToEntityUpdate(LicencaCertificadoEntrada licencaCertificadoEntrada, LicencaCertificado banco);

    public List<LicencaCertificadoSaida> mapToSaida(List<LicencaCertificado> entity);
}
