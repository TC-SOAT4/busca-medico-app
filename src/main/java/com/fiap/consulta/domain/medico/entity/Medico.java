package com.fiap.consulta.domain.medico.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Medico {
    private UUID id;
    private String nome;
    private String crm;
    private Especialidade especialidade;
}
