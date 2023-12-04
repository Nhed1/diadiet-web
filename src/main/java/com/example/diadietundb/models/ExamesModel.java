package com.example.diadietundb.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;
@Entity
@Table(name = "TB_EXAMES")
public class ExamesModel {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idExame;

    private Date dataRetorno;

    private String receita;

    @Lob
    private byte[] anexo;


    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private PacienteModel paciente;

    public UUID getIdExame() {
        return idExame;
    }

    public void setIdExame(UUID idExame) {
        this.idExame = idExame;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public byte[] getAnexo() {
        return anexo;
    }

    public void setAnexo(byte[] anexo) {
        this.anexo = anexo;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
    }
}
