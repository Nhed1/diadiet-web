package com.example.diadietundb.repositories;

import com.example.diadietundb.models.MedicamentosModel;
import com.example.diadietundb.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentosModel, UUID> {


}
