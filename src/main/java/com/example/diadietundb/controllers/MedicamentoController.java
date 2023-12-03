package com.example.diadietundb.controllers;

import com.example.diadietundb.dtos.MedicamentoRecordDto;
import com.example.diadietundb.models.MedicamentosModel;
import com.example.diadietundb.repositories.MedicamentoRepository;
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
public class MedicamentoController {
    @Autowired
    MedicamentoRepository medicamentoRepository;


    @PostMapping("/medicamentos")
    public ResponseEntity<MedicamentosModel> saveMedicamento(@RequestBody @Valid MedicamentoRecordDto medicamentoRecordDto){
        var medicamentoModel = new MedicamentosModel();
        BeanUtils.copyProperties(medicamentoRecordDto, medicamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicamentoRepository.save(medicamentoModel));
    }

    @GetMapping("/medicamentos")
    public ResponseEntity<List<MedicamentosModel>> getAllMedicamentos() {
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoRepository.findAll());
    }

    @GetMapping("/medicamentos/{id}")
    public ResponseEntity<Object> getOneMedicamento(@PathVariable(value = "id") UUID id) {
        Optional<MedicamentosModel> medicamento = medicamentoRepository.findById(id);
        if (medicamento.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicamento nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoRepository.findAll());
    }
}
