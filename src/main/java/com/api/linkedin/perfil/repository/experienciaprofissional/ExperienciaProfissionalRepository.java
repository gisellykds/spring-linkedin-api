package com.api.linkedin.perfil.repository.experienciaprofissional;

import com.api.linkedin.perfil.entity.ExperienciaProfissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienciaProfissionalRepository extends JpaRepository<ExperienciaProfissional, Long> {
    List<ExperienciaProfissional> findAllByIdPerfil(Long idPerfil);
}
