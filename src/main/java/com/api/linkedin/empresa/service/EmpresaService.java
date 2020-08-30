package com.api.linkedin.empresa.service;

import com.api.linkedin.empresa.domain.model.EmpresaEntrada;
import com.api.linkedin.empresa.domain.model.EmpresaSaida;

import java.util.List;

public interface EmpresaService {

    public EmpresaSaida novo(EmpresaEntrada empresaEntrada, Long idUsuario);

    public void desativa(Long id);

    public EmpresaSaida buscaId(Long id);

    public List<EmpresaSaida> buscaTodas();

    public EmpresaSaida atualiza(EmpresaEntrada empresaEntrada,  Long id);

    public void verificaEmpresaExisteValidaStatus(Long idEmpresa);

    public void ativa(Long id);
}
