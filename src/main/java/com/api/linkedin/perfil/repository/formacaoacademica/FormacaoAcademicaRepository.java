package com.api.linkedin.perfil.repository.formacaoacademica;

import com.api.linkedin.perfil.entity.FormacaoAcademica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormacaoAcademicaRepository extends JpaRepository<FormacaoAcademica, Long> {
    List<FormacaoAcademica> findAllByIdPerfil(Long idPerfil);
}
