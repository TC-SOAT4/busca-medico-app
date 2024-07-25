package com.fiap.consulta.application.medico.usecase;

import com.fiap.consulta.domain.medico.entity.Medico;
import com.fiap.consulta.domain.medico.gateway.IMedicoGateway;
import com.fiap.consulta.domain.medico.gateway.IEspecialidadeGateway;
import com.fiap.consulta.domain.medico.usecase.IBuscarMedicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
public class BuscarMedicos implements IBuscarMedicos {

    @Autowired
    private IMedicoGateway medicoGateway;
    @Autowired
    private IEspecialidadeGateway especialidadeGateway;

    public List<Medico> ConsultaMedico(String especialidade, String nome, String crm)
    {
        //Valida parâmetros de entrada
        if((especialidade == null || especialidade.isEmpty())
                && (nome  == null || nome.isEmpty())
                && (crm  == null || crm.isEmpty())
        )
        {
            throw new RuntimeException("É necessário informar ao menos um parâmetro para consulta.");
        }
        //Realiza consulta por nome e CRM
        var medicos = medicoGateway.findAllByNomeOrCrm(nome, crm);
        //Acrescenta resultados por especialidade
        if(especialidade != null && !especialidade.isEmpty()) {
            var especialidades = especialidadeGateway.findByDescricao(especialidade);
            List<UUID> especialidadeIds = especialidades.stream()
                    .map(item -> (item.getId()))
                    .toList();
            medicos.addAll(medicoGateway.FindAllByEspecialidadeIdIn(especialidadeIds));
        }
        return medicos;
    }
}
