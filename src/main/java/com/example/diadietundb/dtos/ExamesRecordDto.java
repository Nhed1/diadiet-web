package com.example.diadietundb.dtos;

import com.example.diadietundb.models.PacienteModel;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record ExamesRecordDto(@NotNull String dataRetorno, String receita, byte[] anexo, UUID idPaciente) {
}

