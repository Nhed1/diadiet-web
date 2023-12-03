package com.example.diadietundb.models;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "TB_MEDICAMENTO")
public class MedicamentosModel {
    private static final long serialVersionUID = 1L;

    public UUID getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(UUID idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idMedicamento;
    private String name;
    private String dataValidade;
    private String composicao;
}
