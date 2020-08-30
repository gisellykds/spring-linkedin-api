package com.api.linkedin.vaga.controller;

import com.api.linkedin.utils.enums.NivelExperiencia;
import com.api.linkedin.utils.enums.TipoEmpregoVaga;
import com.api.linkedin.vaga.domain.model.VagaEntrada;
import com.api.linkedin.vaga.domain.model.VagaSaida;
import com.api.linkedin.vaga.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
@CrossOrigin
@RequestMapping("/api/v1/linkedin/vaga")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @PostMapping("/novo/{empresaId}")
    @ResponseStatus(HttpStatus.CREATED)
    public VagaSaida criar(@PathVariable(value = "empresaId") Long empresaId,
                           @RequestBody @Valid @NotNull VagaEntrada vagaEntrada){
        return vagaService.novo(vagaEntrada, empresaId);
    }

    @PatchMapping("/encerra-candidaturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void encerraCandidaturas(@PathVariable(value = "id") @NotNull Long id){
        vagaService.encerraCandidaturas(id);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VagaSaida buscaId(@PathVariable(value = "id") @NotNull Long id){
        return vagaService.buscaId(id);
    }

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<VagaSaida> buscaTodas(){
        return vagaService.buscaTodas();
    }

    @GetMapping("/get-aberto/")
    @ResponseStatus(HttpStatus.OK)
    public List<VagaSaida> buscaTodasEmAberto(){
        return vagaService.buscaTodasEmAberto();
    }

    @GetMapping("/get-empresa/{empresaId}")
    @ResponseStatus(HttpStatus.OK)
    public List<VagaSaida> buscaTodasPorEmpresa(@PathVariable(value = "empresaId") @NotNull Long empresaId){
        return vagaService.buscaTodasPorEmpresa(empresaId);
    }

    @GetMapping("/get-nivel")
    @ResponseStatus(HttpStatus.OK)
    public List<VagaSaida> buscaTodasPorNivelExperiencia(@RequestParam(value = "nivel_experiencia")
                                                         @Valid @NotNull NivelExperiencia nivelExperiencia){
        return vagaService.buscaTodasPorNivelExperiencia(nivelExperiencia);
    }

    @GetMapping("/get-tipo")
    @ResponseStatus(HttpStatus.OK)
    public List<VagaSaida> buscaTodasPorTipoEmpregoVaga(@RequestParam(value = "tipo_emprego") @Valid
                                                        @NotNull TipoEmpregoVaga tipoEmpregoVaga){
        return vagaService.buscaTodasPorTipoEmpregoVaga(tipoEmpregoVaga);
    }

}
