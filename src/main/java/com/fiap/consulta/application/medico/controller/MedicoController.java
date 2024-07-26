package com.fiap.consulta.application.medico.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.consulta.domain.medico.usecase.IBuscarMedicos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
@Tag(name = "Medicos")
@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final IBuscarMedicos buscarMedicoService;

    @PreAuthorize("hasRole('PACIENTE') or hasRole('MEDICO')")
    @GetMapping()
    @Operation(
            summary = "Busca por médico",
            description = "Listar médicos filtrando pelos parâmetros informados. <br>É necessário informar no mínimo um filtro para busca.",
            parameters = {
                    @Parameter(in = ParameterIn.QUERY, name = "especialidade",
                            description = "Especialidade do médico que deseja buscar.",
                            style = ParameterStyle.SIMPLE, example = "Cardiologia"),
                    @Parameter(in = ParameterIn.QUERY, name = "nome",
                            description = "Nome do médico que deseja buscar.",
                            style = ParameterStyle.SIMPLE, example = "Leonard"),
                    @Parameter(in = ParameterIn.QUERY, name = "crm",
                            description = "CRM do médico que deseja buscar.",
                            style = ParameterStyle.SIMPLE, example = "237843")
            })
    public ResponseEntity<?> consultaMedico(
            @RequestParam (required = false) String especialidade,
            @RequestParam (required = false) String nome,
            @RequestParam (required = false) String crm
    )
    {
        try {
            var response = buscarMedicoService.consultaMedico(especialidade, nome, crm);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
