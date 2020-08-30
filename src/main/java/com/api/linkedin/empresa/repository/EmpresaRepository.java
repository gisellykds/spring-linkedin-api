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
    @Query("UPDATE Empresa AS e SET e.status = '1' WHERE e.id = :id")
    void updateStatusInativa(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Empresa AS e SET e.status = '0' WHERE e.id = :id")
    void updateStatusAtiva(Long id);
}
