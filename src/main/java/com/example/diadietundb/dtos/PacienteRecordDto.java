package com.example.diadietundb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacienteRecordDto(@NotBlank String name, String nascimentoo,@NotNull String cpf, String email) {


}
