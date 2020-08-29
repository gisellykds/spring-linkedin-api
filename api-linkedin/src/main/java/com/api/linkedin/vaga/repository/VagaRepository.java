package com.api.linkedin.vaga.repository;

import com.api.linkedin.utils.enums.StatusVaga;
import com.api.linkedin.vaga.entity.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Vaga AS v SET v.statusVaga = 'FINALIZADO' WHERE v.id = :id")
    void encerraCandidatura(@Param("id") Long id);

    List<Vaga> findAllByStatusVaga(StatusVaga aberto);

    List<Vaga> findAllByEmpresaId(Long empresaId);

}
