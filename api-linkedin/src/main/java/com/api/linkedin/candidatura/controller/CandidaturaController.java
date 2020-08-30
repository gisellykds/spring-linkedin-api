package com.api.linkedin.candidatura.controller;

import com.api.linkedin.candidatura.domain.model.CandidaturaSaida;
import com.api.linkedin.candidatura.service.CandidaturaService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/novo/{id_vaga}/{id_usuario}")
    private void novo(@PathVariable("id_vaga") Long idVaga, @PathVariable("id_usuario") Long idUsuario){
        candidaturaService.novo(idVaga, idUsuario);
    }

    @GetMapping("/get-vaga/{id_vaga}")
    private List<CandidaturaSaida> buscaCandidaturasPorVaga(@PathVariable("id_vaga") Long idVaga){
        return candidaturaService.buscaCandidaturasPorVaga(idVaga);
    }

    @GetMapping("/get-usuario/{id_usuario}")
    private List<CandidaturaSaida> buscaCandidaturasPorUsuario(@PathVariable("id_usuario") Long idUsuario){
        return candidaturaService.buscaCandidaturasPorUsuario(idUsuario);
    }

    @GetMapping("/get-vaga-usuario/{id_vaga}/{id_usuario}")
    private CandidaturaSaida buscaCandidaturasPorVagaEUsuario(@PathVariable("id_vaga") Long idVaga,
                                                              @PathVariable("id_usuario") Long idUsuario){
        return candidaturaService.buscaCandidaturasPorVagaEUsuario(idVaga, idUsuario);
    }

}
