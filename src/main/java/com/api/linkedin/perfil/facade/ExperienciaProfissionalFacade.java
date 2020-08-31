package com.api.linkedin.perfil.facade;

import com.api.linkedin.perfil.domain.mapper.ExperienciaProfissionalMapper;
import com.api.linkedin.perfil.domain.mapper.impl.ExperienciaProfissionalMapperImpl;
import com.api.linkedin.perfil.domain.model.experienciaprofissional.ExperienciaProfissionalEntrada;
import com.api.linkedin.perfil.domain.model.experienciaprofissional.ExperienciaProfissionalSaida;
import com.api.linkedin.perfil.entity.ExperienciaProfissional;
import com.api.linkedin.perfil.repository.experienciaprofissional.ExperienciaProfissionalRepository;
import com.api.linkedin.utils.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaProfissionalFacade extends ValidationUtil {

    @Autowired
    private ExperienciaProfissionalRepository experienciaProfissionalRepository;
    private ExperienciaProfissionalMapper mapper = new ExperienciaProfissionalMapperImpl();

    public ExperienciaProfissionalSaida novo(ExperienciaProfissionalEntrada experienciaProfissionalEntrada, Long idPerfil){
        ExperienciaProfissional entity = mapper.mapToEntity(experienciaProfissionalEntrada, idPerfil);
        entity = experienciaProfissionalRepository.save(entity);
        return mapper.mapToSaida(entity);
    }

    public ExperienciaProfissionalSaida atualiza(ExperienciaProfissionalEntrada experienciaProfissionalEntrada, Long idExperiencia){
        ExperienciaProfissional banco = verificaExperienciaExiste(idExperiencia);
        ExperienciaProfissional entity = mapper.mapToEntityUpdate(experienciaProfissionalEntrada, banco);
        entity = experienciaProfissionalRepository.save(entity);
        return mapper.mapToSaida(entity);
    }

    public ExperienciaProfissionalSaida listaIdPerfil(Long idPerfil){
        List<ExperienciaProfissional> entity = experienciaProfissionalRepository.findAllByIdPerfil(idPerfil);
        verificaListaVazia(entity);
        return mapper.mapToSaida(entity);
    }

    public ExperienciaProfissionalSaida buscaId(Long idExperiencia){
        ExperienciaProfissional entity = verificaExperienciaExiste(idExperiencia);
        return mapper.mapToSaida(entity);
    }

    public void deleteId(Long idExperiencia){
        verificaExperienciaExiste(idExperiencia);
        experienciaProfissionalRepository.deleteById(idExperiencia);
    }

    private ExperienciaProfissional verificaExperienciaExiste(Long idExperiencia){
        Optional<ExperienciaProfissional> experienciaProfissional = experienciaProfissionalRepository.findById(idExperiencia);
        verificaIsPresente(experienciaProfissional, "EXPERIENCIA-1");
        return experienciaProfissional.get();
    }

}
