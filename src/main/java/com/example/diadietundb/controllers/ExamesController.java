

package com.example.diadietundb.controllers;
        import com.example.diadietundb.dtos.ExamesRecordDto;
        import com.example.diadietundb.models.ExamesModel;
        import com.example.diadietundb.models.PacienteModel;
        import com.example.diadietundb.repositories.ExamesRepository;
        import com.example.diadietundb.repositories.PacienteRepository;
        import jakarta.validation.Valid;
        import org.springframework.beans.BeanUtils;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.List;
        import java.util.Optional;
        import java.util.UUID;

@RestController
public class ExamesController {
    @Autowired
    ExamesRepository examesRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @PostMapping("/exames")
    public ResponseEntity<ExamesModel> saveExame(@RequestBody @Valid ExamesRecordDto examesRecordDto){

        Date dataRetorno = convertStringToDate(examesRecordDto.dataRetorno());


        Optional<PacienteModel> pacienteOptional = pacienteRepository.findById(examesRecordDto.idPaciente());


        if (pacienteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        PacienteModel paciente = pacienteOptional.get();


        var exameModel = new ExamesModel();

        exameModel.setDataRetorno(dataRetorno);


        BeanUtils.copyProperties(examesRecordDto, exameModel);

        exameModel.setPaciente(paciente);

        return ResponseEntity.status(HttpStatus.CREATED).body(examesRepository.save(exameModel));
    }

    private Date convertStringToDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data inválido", e);
        }
    }

    @GetMapping("/exames")
    public ResponseEntity<List<ExamesModel>> getAllExames() {
        return ResponseEntity.status(HttpStatus.OK).body(examesRepository.findAll());
    }

    @GetMapping("/exames/{id}")
    public ResponseEntity<Object> getOneExame(@PathVariable(value = "id") UUID id) {
        Optional<ExamesModel> exame = examesRepository.findById(id);
        if (exame.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exame nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(examesRepository.findById(id));
    }
}
