package com.example.diadietundb.repositories;

import com.example.diadietundb.models.ExamesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExamesRepository extends JpaRepository<ExamesModel, UUID> {
}

