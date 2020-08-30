package com.api.linkedin.empresa.service.impl;

import com.api.linkedin.empresa.domain.mapper.EmpresaMapper;
import com.api.linkedin.empresa.domain.mapper.impl.EmpresaMapperImpl;
import com.api.linkedin.empresa.domain.model.EmpresaEntrada;
import com.api.linkedin.empresa.domain.model.EmpresaSaida;
import com.api.linkedin.empresa.entity.Empresa;
import com.api.linkedin.empresa.repository.EmpresaRepository;
import com.api.linkedin.empresa.service.EmpresaService;
import com.api.linkedin.utils.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl extends ValidationUtil implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    private EmpresaMapper empresaMapper = new EmpresaMapperImpl();

    @Override
    public EmpresaSaida novo(EmpresaEntrada empresaEntrada, Long idUsuario) {
        Empresa entity = empresaMapper.mapToEntity(empresaEntrada, idUsuario);
        entity = empresaRepository.save(entity);
        return empresaMapper.mapToSaida(entity);
    }

    @Override
    public void desativa(Long id) {
        verificaEmpresaExisteValidaStatus(id);
        empresaRepository.updateStatus(id);
    }

    @Override
    public EmpresaSaida buscaId(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        verificaIsPresente(empresa, "EMPRESA-1");
        return empresaMapper.mapToSaida(empresa.get());
    }

    @Override
    public List<EmpresaSaida> buscaTodas() {
        List<Empresa> empresas = empresaRepository.findAll();
        verificaListaVazia(empresas);
        return empresaMapper.mapToSaida(empresas);
    }

    @Override
    public EmpresaSaida atualiza(EmpresaEntrada empresaEntrada, Long id) {
        Empresa entity = validaEmpresaExiste(id);
        Empresa update = empresaMapper.mapToEntityUpdate(empresaEntrada, entity);
        update = empresaRepository.save(entity);
        return empresaMapper.mapToSaida(entity);
    }

    @Override
    public void verificaEmpresaExisteValidaStatus(Long idEmpresa) {
        Empresa empresa = validaEmpresaExiste(idEmpresa);
        verificaIsInativa(empresa.getStatus(), "EMPRESA-2");
    }

    private Empresa validaEmpresaExiste(Long idEmpresa) {
        Optional<Empresa> entity = empresaRepository.findById(idEmpresa);
        verificaIsPresente(entity, "EMPRESA-1");
        return entity.get();
    }
}
