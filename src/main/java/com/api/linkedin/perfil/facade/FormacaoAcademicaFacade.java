package com.api.linkedin.perfil.facade;

import com.api.linkedin.perfil.domain.mapper.FormacaoAcademicaMapper;
import com.api.linkedin.perfil.domain.mapper.impl.FormacaoAcademicaMapperImpl;
import com.api.linkedin.perfil.domain.model.formacaoacademica.FormacaoAcademicaEntrada;
import com.api.linkedin.perfil.domain.model.formacaoacademica.FormacaoAcademicaSaida;
import com.api.linkedin.perfil.entity.FormacaoAcademica;
import com.api.linkedin.perfil.repository.formacaoacademica.FormacaoAcademicaRepository;
import com.api.linkedin.utils.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormacaoAcademicaFacade extends ValidationUtil {

    @Autowired
    private FormacaoAcademicaRepository formacaoAcademicaRepository;
    private FormacaoAcademicaMapper mapper = new FormacaoAcademicaMapperImpl();

    public FormacaoAcademicaSaida novo(FormacaoAcademicaEntrada formacaoAcademicaEntrada, Long idPerfil){
        FormacaoAcademica entity = mapper.mapToEntity(formacaoAcademicaEntrada, idPerfil);
        entity = formacaoAcademicaRepository.save(entity);
        return mapper.mapToSaida(entity);
    }

    public FormacaoAcademicaSaida atualiza(FormacaoAcademicaEntrada formacaoAcademicaEntrada, Long idFormacaoAcademica){
        FormacaoAcademica banco = verificaFormacaoAcademicaExiste(idFormacaoAcademica);
        FormacaoAcademica entity = mapper.mapToEntityUpdate(formacaoAcademicaEntrada, banco);
        entity = formacaoAcademicaRepository.save(entity);
        return mapper.mapToSaida(entity);
    }

    public FormacaoAcademicaSaida listaIdPerfil(Long idPerfil){
        List<FormacaoAcademica> entity = formacaoAcademicaRepository.findAllByIdPerfil(idPerfil);
        verificaListaVazia(entity);
        return mapper.mapToSaida(entity);
    }

    public FormacaoAcademicaSaida buscaId(Long idFormacaoAcademica){
        FormacaoAcademica entity = verificaFormacaoAcademicaExiste(idFormacaoAcademica);
        return mapper.mapToSaida(entity);
    }

    public void deleteId(Long idExperiencia){
        verificaFormacaoAcademicaExiste(idExperiencia);
        formacaoAcademicaRepository.deleteById(idExperiencia);
    }

    private FormacaoAcademica verificaFormacaoAcademicaExiste(Long idFormacaoAcademica){
        Optional<FormacaoAcademica> formacaoAcademica = formacaoAcademicaRepository.findById(idFormacaoAcademica);
        verificaIsPresente(formacaoAcademica, "FORMACAO_ACADEMICA-1");
        return formacaoAcademica.get();
    }
}
