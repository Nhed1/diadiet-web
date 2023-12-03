package com.example.diadietundb.controllers;

import com.example.diadietundb.dtos.PacienteRecordDto;
import com.example.diadietundb.models.PacienteModel;
import com.example.diadietundb.repositories.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;


    @PostMapping("/pacientes")
    public ResponseEntity<PacienteModel> savePaciente(@RequestBody @Valid PacienteRecordDto pacienteRecordDto){
        var pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteRecordDto, pacienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepository.save(pacienteModel));
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<PacienteModel>> getAllPacientes() {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteRepository.findAll());
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Object> getOnePaciente(@PathVariable(value = "id") UUID id) {
        Optional<PacienteModel> paciente = pacienteRepository.findById(id);
        if (paciente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacienteRepository.findAll());
    }
}
