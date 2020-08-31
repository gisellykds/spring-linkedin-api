package com.api.linkedin.perfil.controller;

import com.api.linkedin.perfil.domain.model.PerfilEntrada;
import com.api.linkedin.perfil.domain.model.experienciaprofissional.ExperienciaProfissionalEntrada;
import com.api.linkedin.perfil.domain.model.experienciaprofissional.ExperienciaProfissionalSaida;
import com.api.linkedin.perfil.domain.model.formacaoacademica.FormacaoAcademicaEntrada;
import com.api.linkedin.perfil.domain.model.formacaoacademica.FormacaoAcademicaSaida;
import com.api.linkedin.perfil.domain.model.licencacertificado.LicencaCertificadoEntrada;
import com.api.linkedin.perfil.domain.model.licencacertificado.LicencaCertificadoSaida;
import com.api.linkedin.perfil.entity.Perfil;
import com.api.linkedin.perfil.facade.PerfilFacade;
import com.api.linkedin.perfil.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/linkedin/perfil")
@Validated
@CrossOrigin
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private PerfilFacade perfilFacade;

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public Perfil criar(@RequestBody @Valid @NotNull PerfilEntrada perfilEntrada){
        return perfilService.novoPerfil(perfilEntrada);
    }

    @PostMapping("/novo/formacao-academica/{id_perfil}")
    @ResponseStatus(HttpStatus.CREATED)
    public FormacaoAcademicaSaida novaFormacaoAcademica(@RequestBody @Valid @NotNull FormacaoAcademicaEntrada formacaoAcademicaEntrada,
                                                        @PathVariable("id_perfil") @NotNull Long idPerfil){
        return perfilFacade.formacaoAcademicaFacade.novo(formacaoAcademicaEntrada, idPerfil);
    }

    @PostMapping("/novo/experiencia-profissional/{id_perfil}")
    @ResponseStatus(HttpStatus.CREATED)
    public ExperienciaProfissionalSaida novaExperienciaProfissional(@RequestBody @Valid @NotNull ExperienciaProfissionalEntrada experienciaProfissionalEntrada,
                                                                    @PathVariable("id_perfil") @NotNull Long idPerfil){
        return perfilFacade.experienciaProfissionalFacade.novo(experienciaProfissionalEntrada, idPerfil);
    }

    @PostMapping("/novo/licenca-certificado/{id_perfil}")
    @ResponseStatus(HttpStatus.CREATED)
    public LicencaCertificadoSaida novaLicencaCertificado(@RequestBody @Valid @NotNull LicencaCertificadoEntrada licencaCertificadoEntrada,
                                                               @PathVariable("id_perfil") @NotNull Long idPerfil){
        return perfilFacade.licencaCertificadoFacade.novo(licencaCertificadoEntrada, idPerfil);
    }
}
