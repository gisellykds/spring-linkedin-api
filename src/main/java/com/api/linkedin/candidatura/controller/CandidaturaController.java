package com.api.linkedin.candidatura.controller;

import com.api.linkedin.candidatura.domain.model.CandidaturaSaida;
import com.api.linkedin.candidatura.service.CandidaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/linkedin/candidatura")
@Validated
@CrossOrigin
public class CandidaturaController {

    @Autowired
    private CandidaturaService candidaturaService;

    @PostMapping("/novo/{id_vaga}/{id_perfil}")
    @ResponseStatus(HttpStatus.CREATED)
    private void novo(@PathVariable("id_vaga") Long idVaga, @PathVariable("id_perfil") Long idPerfil){
        candidaturaService.novo(idVaga, idPerfil);
    }

    @GetMapping("/get-vaga/{id_vaga}")
    @ResponseStatus(HttpStatus.OK)
    private List<CandidaturaSaida> buscaCandidaturasPorVaga(@PathVariable("id_vaga") Long idVaga){
        return candidaturaService.buscaCandidaturasPorVaga(idVaga);
    }

    @GetMapping("/get-perfil/{id_perfil}")
    @ResponseStatus(HttpStatus.OK)
    private List<CandidaturaSaida> buscaCandidaturasPorPerfil(@PathVariable("id_perfil") Long idPerfil){
        return candidaturaService.buscaCandidaturasPorUsuario(idPerfil);
    }

    @GetMapping("/get-vaga-perfil/{id_vaga}/{id_perfil}")
    @ResponseStatus(HttpStatus.OK)
    private CandidaturaSaida buscaCandidaturasPorVagaEPerfil(@PathVariable("id_vaga") Long idVaga,
                                                              @PathVariable("id_perfil") Long idPerfil){
        return candidaturaService.buscaCandidaturasPorVagaEUsuario(idVaga, idPerfil);
    }

}
