package com.fiap.consulta.infra.mapper;

import com.fiap.consulta.domain.medico.entity.Especialidade;
import com.fiap.consulta.infra.medico.persistence.entity.EspecialidadeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EspecialidadeMapper {
    List<Especialidade> toEspecialidade(List<EspecialidadeEntity> especialidadeEntity);
}
