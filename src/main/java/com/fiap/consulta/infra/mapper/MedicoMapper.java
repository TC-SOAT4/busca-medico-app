package com.fiap.consulta.infra.mapper;

import com.fiap.consulta.domain.medico.entity.Medico;
import com.fiap.consulta.infra.medico.persistence.entity.MedicoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicoMapper {
    List<Medico> toMedico(List<MedicoEntity> medicoEntity);
    Medico toMedico(MedicoEntity medicoEntity);
}
