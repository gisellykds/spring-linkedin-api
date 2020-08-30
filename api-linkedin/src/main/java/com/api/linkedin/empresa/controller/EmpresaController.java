package com.api.linkedin.empresa.controller;

import com.api.linkedin.empresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/linkedin/empresa")
@Validated
@CrossOrigin
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;


}
