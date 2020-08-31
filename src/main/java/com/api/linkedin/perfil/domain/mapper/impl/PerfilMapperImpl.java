package com.api.linkedin.perfil.domain.mapper.impl;

import com.api.linkedin.perfil.domain.mapper.PerfilMapper;
import com.api.linkedin.perfil.domain.model.EmailPerfilEntrada;
import com.api.linkedin.perfil.domain.model.InformacoesContatoEntrada;
import com.api.linkedin.perfil.domain.model.PerfilEntrada;
import com.api.linkedin.perfil.domain.model.SitePerfilEntrada;
import com.api.linkedin.perfil.domain.model.localidade.LocalidadeEntrada;
import com.api.linkedin.perfil.entity.*;
import com.api.linkedin.utils.enums.Setor;
import com.api.linkedin.utils.enums.Status;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class PerfilMapperImpl implements PerfilMapper {
    @Override
    public Perfil mapToEntity(PerfilEntrada perfilEntrada) {
        Perfil perfil = new Perfil();
        perfil.setNome(perfilEntrada.getNome());
        perfil.setSobrenome(perfilEntrada.getSobrenome());
        perfil.setStatus(Status.ATIVO);
        perfil.setTituloPerfil(perfilEntrada.getTituloPerfil());
        perfil.setSetor(Setor.get(perfilEntrada.getSetor()));
        perfil.setLocalidade(mapToEntity(perfilEntrada.getLocalidade()));
        perfil.setInformacoesContato(mapToEntity(perfilEntrada.getInformacoesContato()));
        return perfil;
    }

    private Localidade mapToEntity(LocalidadeEntrada localidadeEntrada){
        Localidade localidade = new Localidade();
        localidade.setCidade(localidadeEntrada.getCidade());
        localidade.setEstado(localidadeEntrada.getEstado());
        localidade.setPais(localidadeEntrada.getPais());
        return localidade;
    }

    private InformacoesContato mapToEntity(InformacoesContatoEntrada informacoesContatoEntrada){
        InformacoesContato informacoesContato = new InformacoesContato();
        informacoesContato.setEmail(mapToEntityEmail(informacoesContatoEntrada.getEmail()));
        informacoesContato.setSite(mapToEntitySite(informacoesContatoEntrada.getSite()));
        return informacoesContato;
    }

    public List<EmailPerfil> mapToEntityEmail(Set<EmailPerfilEntrada> emailPerfilEntradas){
        if (emailPerfilEntradas.isEmpty()){
            return null;
        }
        return emailPerfilEntradas.stream().map(this::mapToEntity).collect(toList());
    }

    public EmailPerfil mapToEntity(EmailPerfilEntrada emailPerfilEntrada){
        EmailPerfil emailPerfil = new EmailPerfil();
        emailPerfil.setEmail(emailPerfilEntrada.getEmail());
        return emailPerfil;
    }

    public List<SitePerfil> mapToEntitySite(Set<SitePerfilEntrada> sitePerfilEntradas){
        if (sitePerfilEntradas.isEmpty()){
            return null;
        }
        return sitePerfilEntradas.stream().map(this::mapToEntity).collect(toList());
    }

    public SitePerfil mapToEntity(SitePerfilEntrada sitePerfilEntrada){
        SitePerfil sitePerfil = new SitePerfil();
        sitePerfil.setSite(sitePerfilEntrada.getSite());
        sitePerfil.setTipoSite(sitePerfilEntrada.getTipoSite());
        return sitePerfil;
    }
}
