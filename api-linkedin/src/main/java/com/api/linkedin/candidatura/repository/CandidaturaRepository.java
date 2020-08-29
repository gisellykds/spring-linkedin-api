package com.api.linkedin.candidatura.repository;

import com.api.linkedin.candidatura.entity.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {

    List<Candidatura> findAllByIdVaga(Long idVaga);

    List<Candidatura> findAllByIdUsuario(Long idUsuario);

    Candidatura findAllByIdVagaAndIdUsuario(Long idUsuario);
}
