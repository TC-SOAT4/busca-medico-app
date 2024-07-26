package com.fiap.consulta.domain.medico.gateway;

import com.fiap.consulta.domain.medico.entity.Especialidade;
import java.util.List;

public interface IEspecialidadeGateway {
    List<Especialidade> findByDescricao(String descricao);
}
