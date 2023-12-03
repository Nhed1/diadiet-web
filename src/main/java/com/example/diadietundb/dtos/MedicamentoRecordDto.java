package com.example.diadietundb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicamentoRecordDto(@NotBlank String name, String dataValidade, String composicao) {


}
