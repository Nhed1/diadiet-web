package com.example.diadietundb.controllers;

import com.example.diadietundb.dtos.PacienteRecordDto;
import com.example.diadietundb.models.PacienteModel;
import com.example.diadietundb.repositories.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;


    @PostMapping("/paciente")
    public ResponseEntity<PacienteModel> saveProduct(@RequestBody @Valid PacienteRecordDto pacienteRecordDto){
        var pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteRecordDto, pacienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepository.save(pacienteModel));
    }
}
