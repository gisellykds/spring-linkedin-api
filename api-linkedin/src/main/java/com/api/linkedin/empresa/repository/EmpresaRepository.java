package com.api.linkedin.empresa.repository;

import com.api.linkedin.empresa.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Vaga AS v SET v.statusVaga = 'INATIVO' WHERE v.id = :id")
    void updateStatus(@Param("id") Long id);

}
