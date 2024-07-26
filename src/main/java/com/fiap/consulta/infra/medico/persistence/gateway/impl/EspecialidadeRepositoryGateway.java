package com.fiap.consulta.infra.medico.persistence.gateway.impl;

import com.fiap.consulta.domain.medico.entity.Especialidade;
import com.fiap.consulta.domain.medico.gateway.IEspecialidadeGateway;
import com.fiap.consulta.infra.mapper.EspecialidadeMapper;
import com.fiap.consulta.infra.medico.persistence.repository.EspecialidadeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class EspecialidadeRepositoryGateway implements IEspecialidadeGateway
{
    @Autowired
    private EspecialidadeEntityRepository especialidadeEntityRepository;
    @Autowired
    private EspecialidadeMapper especialidadeMapper;

    @Override
    public List<Especialidade> findByDescricao(String descricao)
    {
        var especialidadeEntity = especialidadeEntityRepository.findAllByDescricaoContaining(descricao);
        return especialidadeMapper.toEspecialidade(especialidadeEntity);
    }
}
