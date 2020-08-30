package com.api.linkedin.empresa.controller;

import com.api.linkedin.empresa.domain.model.EmpresaEntrada;
import com.api.linkedin.empresa.domain.model.EmpresaSaida;
import com.api.linkedin.empresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/linkedin/empresa")
@Validated
@CrossOrigin
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/novo/{id_usuario}")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaSaida novo(@RequestBody @Valid @NotNull EmpresaEntrada empresaEntrada,
                                     @PathVariable("id_usuario") @NotNull Long idUsuario){
        return empresaService.novo(empresaEntrada, idUsuario);
    }

    @PatchMapping("/desativa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void desativa(@PathVariable("id") @NotNull Long id){
        empresaService.desativa(id);
    }

    @PatchMapping("/ativa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void ativa(@PathVariable("id") @NotNull Long id){
        empresaService.ativa(id);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmpresaSaida buscaId(@PathVariable("id") @NotNull Long id){
        return empresaService.buscaId(id);
    }

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<EmpresaSaida> buscaTodas(){
        return empresaService.buscaTodas();
    }

    @PatchMapping("/atualiza/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmpresaSaida atualiza(@RequestBody @Valid @NotNull EmpresaEntrada empresaEntrada,
                                 @PathVariable("id") @NotNull Long id){
        return empresaService.atualiza(empresaEntrada, id);
    }

}
