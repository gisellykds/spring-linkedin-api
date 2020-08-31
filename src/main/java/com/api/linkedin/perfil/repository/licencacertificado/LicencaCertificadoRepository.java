package com.api.linkedin.perfil.repository.licencacertificado;

import com.api.linkedin.perfil.entity.LicencaCertificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicencaCertificadoRepository extends JpaRepository<LicencaCertificado, Long> {
    List<LicencaCertificado> findAllByIdPerfil(Long idPerfil);
}
