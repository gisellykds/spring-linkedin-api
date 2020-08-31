package com.api.linkedin.candidatura.repository;

import com.api.linkedin.candidatura.entity.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {



    Candidatura findByIdVagaAndIdPerfil(Long idVaga, Long idPerfil);

    List<Candidatura> findByIdVaga(Long idVaga);

    List<Candidatura> findByIdPerfil(Long idPerfil);
}
