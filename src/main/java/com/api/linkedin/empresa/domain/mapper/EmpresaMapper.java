package com.api.linkedin.empresa.domain.mapper;

import com.api.linkedin.empresa.domain.model.EmpresaEntrada;
import com.api.linkedin.empresa.domain.model.EmpresaSaida;
import com.api.linkedin.empresa.entity.Empresa;

import java.util.List;

public interface EmpresaMapper {

    public Empresa mapToEntity(EmpresaEntrada empresaEntrada, Long idPerfil);

    public EmpresaSaida mapToSaida(Empresa empresa);

    public List<EmpresaSaida> mapToSaida(List<Empresa> empresas);

    public Empresa mapToEntityUpdate(EmpresaEntrada empresaEntrada, Empresa empresa);

}
