package com.fiap.consulta.domain.medico.gateway;

import com.fiap.consulta.domain.medico.entity.Medico;
import java.util.List;
import java.util.UUID;

public interface IMedicoGateway {
    List<Medico> findAllByNomeOrCrm(String nome, String crm);
    List<Medico> findByNome(String nome);
    List<Medico> findByCrm(String crm);
    List<Medico> findAllByEspecialidadeId(UUID especialidadeId);
    List<Medico> findAllByEspecialidadeIdIn(List<UUID> especialidadeIds);
}
