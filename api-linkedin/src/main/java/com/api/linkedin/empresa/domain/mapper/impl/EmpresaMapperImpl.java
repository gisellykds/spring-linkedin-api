package com.api.linkedin.empresa.domain.mapper.impl;

import com.api.linkedin.empresa.domain.mapper.EmpresaMapper;
import com.api.linkedin.empresa.domain.model.EmpresaEntrada;
import com.api.linkedin.empresa.domain.model.EmpresaSaida;
import com.api.linkedin.empresa.entity.Empresa;
import com.api.linkedin.utils.enums.Setor;
import com.api.linkedin.utils.enums.Status;
import com.api.linkedin.utils.enums.TipoEmpresa;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class EmpresaMapperImpl implements EmpresaMapper {

    @Override
    public Empresa mapToEntity(EmpresaEntrada empresaEntrada, Long idUsuario) {
        Empresa entity = new Empresa();

        entity.setIdUsuario(idUsuario);
        entity.setNome(empresaEntrada.getNome());
        entity.setStatus(Status.ATIVO);
        entity.setSite(empresaEntrada.getSite());
        entity.setSetor(Setor.get(empresaEntrada.getSetor()));
        entity.setTipoEmpresa(TipoEmpresa.get(empresaEntrada.getTipoEmpresa()));
        entity.setUrlLogo(empresaEntrada.getUrlLogo());
        entity.setSlogan(empresaEntrada.getSlogan());

        return entity;
    }

    @Override
    public Empresa mapToEntityUpdate(EmpresaEntrada empresaEntrada, Empresa empresa) {
        Empresa entity = new Empresa();

        entity.setId(empresa.getId());
        entity.setIdUsuario(empresa.getIdUsuario());
        entity.setStatus(empresa.getStatus());

        entity.setNome(empresaEntrada.getNome());
        entity.setSite(empresaEntrada.getSite());
        entity.setSetor(Setor.get(empresaEntrada.getSetor()));
        entity.setTipoEmpresa(TipoEmpresa.get(empresaEntrada.getTipoEmpresa()));
        entity.setUrlLogo(empresaEntrada.getUrlLogo());
        entity.setSlogan(empresaEntrada.getSlogan());

        return entity;
    }


    @Override
    public EmpresaSaida mapToSaida(Empresa empresa) {
        EmpresaSaida saida = new EmpresaSaida();

        saida.setId(empresa.getId());
        saida.setIdUsuario(empresa.getIdUsuario());
        saida.setNome(empresa.getNome());
        saida.setStatus(empresa.getStatus());
        saida.setSite(empresa.getSite());
        saida.setSetor(empresa.getSetor());
        saida.setTipoEmpresa(empresa.getTipoEmpresa());
        saida.setUrlLogo(empresa.getUrlLogo());
        saida.setSlogan(empresa.getSlogan());

        return saida;
    }

    @Override
    public List<EmpresaSaida> mapToSaida(List<Empresa> empresas) {
        return empresas
                .stream()
                .map(this::mapToSaida)
                .collect(toList());
    }

}
