package com.fiap.consulta.application.medico.controller;

import com.fiap.consulta.domain.medico.entity.Medico;
import com.fiap.consulta.domain.medico.usecase.IBuscarMedicos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/medicos")
@Tag(name = "Medicos")
public class MedicoController {
    @Autowired
    private IBuscarMedicos buscarMedicoService;

    //@PreAuthorize("hasRole('PACIENTE') or hasRole('MEDICO')")
    @Operation(summary = "Busca por médico", description = "Listar médicos filtrando pelos parâmetros informados. É necessário informar no mínimo um filtro para busca.")
    @GetMapping()
    public ResponseEntity<?> ConsultaMedico(
            @RequestParam (required = false) String especialidade,
            @RequestParam (required = false) String nome,
            @RequestParam (required = false) String crm
    )
    {
        try {
            var response = buscarMedicoService.ConsultaMedico(especialidade, nome, crm);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //@PreAuthorize("hasRole('PACIENTE') or hasRole('MEDICO')")
    @Operation(summary = "Busca médico por ID", description = "Consulta Médico por ID.")
    @GetMapping("/{idMedico}")
    public ResponseEntity<?> ConsultaMedicoPorId(@PathVariable("idMedico") UUID id)
    {
        try {
            //var response = buscarMedicoService.ConsultaMedicoPorId(idMedico);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
