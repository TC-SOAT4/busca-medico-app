package com.fiap.consulta.domain.medico.usecase;

import com.fiap.consulta.domain.medico.entity.Medico;
import java.util.List;

public interface IBuscarMedicos {
    List<Medico> consultaMedico(String especialidade, String nome, String crm);
}
