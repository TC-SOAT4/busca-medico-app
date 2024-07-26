package com.fiap.consulta.infra.medico.persistence.gateway.impl;

import com.fiap.consulta.domain.medico.entity.Medico;
import com.fiap.consulta.domain.medico.gateway.IMedicoGateway;
import com.fiap.consulta.infra.mapper.MedicoMapper;
import com.fiap.consulta.infra.medico.persistence.repository.MedicoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
public class MedicoRepositoryGateway implements IMedicoGateway
{
    @Autowired
    private MedicoEntityRepository medicoRepository;
    @Autowired
    private MedicoMapper medicoMapper;

    @Override
    public List<Medico> findAllByNomeOrCrm(String nome, String crm)
    {
        var medicoEntity = medicoRepository.findAllByNomeContainingOrCrm(nome, crm);
        return medicoMapper.toMedico(medicoEntity);
    }

    @Override
    public List<Medico> findByNome(String nome)
    {
        var medicoEntity = medicoRepository.findAllByNomeContaining(nome);
        return medicoMapper.toMedico(medicoEntity);
    }

    @Override
    public List<Medico> findByCrm(String crm)
    {
        var medicoEntity = medicoRepository.findAllByCrm(crm);
        return medicoMapper.toMedico(medicoEntity);
    }

    @Override
    public List<Medico> findAllByEspecialidadeId(UUID especialidadeId)
    {
        var medicoEntity = medicoRepository.findAllByEspecialidadeId(especialidadeId);
        return medicoMapper.toMedico(medicoEntity);
    }

    @Override
    public List<Medico> findAllByEspecialidadeIdIn(List<UUID> especialidadeIds)
    {
        var medicoEntity = medicoRepository.findAllByEspecialidadeIdIn(especialidadeIds);
        return medicoMapper.toMedico(medicoEntity);
    }
}
