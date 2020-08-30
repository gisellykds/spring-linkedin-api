package com.api.linkedin.vaga.service;

import com.api.linkedin.utils.enums.NivelExperiencia;
import com.api.linkedin.utils.enums.TipoEmpregoVaga;
import com.api.linkedin.vaga.domain.model.VagaEntrada;
import com.api.linkedin.vaga.domain.model.VagaSaida;

import java.util.List;

public interface VagaService {

    public VagaSaida novo(VagaEntrada vaga, Long idEmpresa);

    public void encerraCandidaturas(Long id);

    public VagaSaida buscaId(Long id);

    public List<VagaSaida> buscaTodas();

    public List<VagaSaida> buscaTodasEmAberto();

    public List<VagaSaida> buscaTodasPorEmpresa(Long empresaId);

    public List<VagaSaida> buscaTodasPorNivelExperiencia(NivelExperiencia nivelExperiencia);

    public List<VagaSaida> buscaTodasPorTipoEmpregoVaga(TipoEmpregoVaga tipoEmpregoVaga);

    public void verificaExisteValidaStatus(Long id);

    public void verificaExiste(Long id);

    public void iteraQuantidadeCandidaturas(Long idVaga);
}
