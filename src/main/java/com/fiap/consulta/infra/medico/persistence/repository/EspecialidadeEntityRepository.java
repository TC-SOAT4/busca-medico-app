package com.fiap.consulta.infra.medico.persistence.repository;

import com.fiap.consulta.infra.medico.persistence.entity.EspecialidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface EspecialidadeEntityRepository extends JpaRepository<EspecialidadeEntity, UUID> {
    List<EspecialidadeEntity> findAllByDescricaoContaining(String descricao);
}
