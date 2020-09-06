package com.api.linkedin.perfil.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilFacade {


    @Autowired
    public ExperienciaProfissionalFacade experienciaProfissionalFacade;

    @Autowired
    public LicencaCertificadoFacade licencaCertificadoFacade;

    @Autowired
    public FormacaoAcademicaFacade formacaoAcademicaFacade;
}
