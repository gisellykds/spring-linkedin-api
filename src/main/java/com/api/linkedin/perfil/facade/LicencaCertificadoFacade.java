package com.api.linkedin.perfil.facade;

import com.api.linkedin.perfil.domain.mapper.LicencaCertificadoMapper;
import com.api.linkedin.perfil.domain.mapper.impl.LicencaCertificadoMapperImpl;
import com.api.linkedin.perfil.domain.model.licencacertificado.LicencaCertificadoEntrada;
import com.api.linkedin.perfil.domain.model.licencacertificado.LicencaCertificadoSaida;
import com.api.linkedin.perfil.entity.LicencaCertificado;
import com.api.linkedin.perfil.repository.licencacertificado.LicencaCertificadoRepository;
import com.api.linkedin.utils.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicencaCertificadoFacade extends ValidationUtil {

    @Autowired
    private LicencaCertificadoRepository licencaCertificadoRepository;
    private LicencaCertificadoMapper mapper = new LicencaCertificadoMapperImpl();

    public LicencaCertificadoSaida novo(LicencaCertificadoEntrada licencaCertificadoEntrada, Long idPerfil){
        LicencaCertificado entity = mapper.mapToEntity(licencaCertificadoEntrada, idPerfil);
        entity = licencaCertificadoRepository.save(entity);
        return mapper.mapToSaida(entity);
    }

    public LicencaCertificadoSaida atualiza(LicencaCertificadoEntrada licencaCertificadoEntrada, Long idLicencaCertificado){
        LicencaCertificado banco = verificaLicencaCertificadoExiste(idLicencaCertificado);
        LicencaCertificado entity = mapper.mapToEntityUpdate(licencaCertificadoEntrada, banco);
        entity = licencaCertificadoRepository.save(entity);
        return mapper.mapToSaida(entity);
    }

    public List<LicencaCertificadoSaida> listaIdPerfil(Long idPerfil){
        List<LicencaCertificado> entity = licencaCertificadoRepository.findAllByIdPerfil(idPerfil);
        verificaListaVazia(entity);
        return mapper.mapToSaida(entity);
    }

    public LicencaCertificadoSaida buscaId(Long idExperiencia){
        LicencaCertificado entity = verificaLicencaCertificadoExiste(idExperiencia);
        return mapper.mapToSaida(entity);
    }

    public void deleteId(Long idExperiencia){
        verificaLicencaCertificadoExiste(idExperiencia);
        licencaCertificadoRepository.deleteById(idExperiencia);
    }

    private LicencaCertificado verificaLicencaCertificadoExiste(Long idLicencaCertificado){
        Optional<LicencaCertificado> experienciaProfissional = licencaCertificadoRepository.findById(idLicencaCertificado);
        verificaIsPresente(experienciaProfissional, "LICENCA_CERTIFICADO-1");
        return experienciaProfissional.get();
    }
}
