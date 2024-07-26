package com.fiap.consulta.infra.medico.persistence.repository;

import com.fiap.consulta.infra.medico.persistence.entity.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface MedicoEntityRepository extends JpaRepository<MedicoEntity, UUID> {
    List<MedicoEntity> findAllByNomeContainingOrCrm(String nome, String Crm);
    List<MedicoEntity> findAllByNomeContaining(String nome);
    List<MedicoEntity> findAllByCrm(String crm);
    List<MedicoEntity> findAllByEspecialidadeId(UUID especialidadeId);
    List<MedicoEntity> findAllByEspecialidadeIdIn(List<UUID> especialidadeIds);
}
