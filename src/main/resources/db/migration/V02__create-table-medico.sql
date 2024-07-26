CREATE TABLE Medico (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    crm INTEGER NOT NULL,
    especialidadeId UUID,
    CONSTRAINT fk_especialidade
        FOREIGN KEY(especialidadeId) 
        REFERENCES Especialidade(id)
);