package com.fiap.consulta.domain.medico.gateway;

import com.fiap.consulta.domain.medico.entity.Medico;
import java.util.List;
import java.util.UUID;

public interface IMedicoGateway {
    List<Medico> findAllByNomeOrCrm(String nome, String crm);
    List<Medico> FindByNome(String nome);
    List<Medico> FindByCrm(String crm);
    List<Medico> FindAllByEspecialidadeId(UUID especialidadeId);
    List<Medico> FindAllByEspecialidadeIdIn(List<UUID> especialidadeIds);
}
