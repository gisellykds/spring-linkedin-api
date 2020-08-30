package com.api.linkedin.vaga.repository;

import com.api.linkedin.utils.enums.NivelExperiencia;
import com.api.linkedin.utils.enums.TipoEmpregoVaga;
import com.api.linkedin.vaga.entity.DetalhesVaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalhesVagaRepository extends JpaRepository<DetalhesVaga, Long> {

    List<DetalhesVaga> findAllByNivelExperiencia(NivelExperiencia nivelExperiencia);

    List<DetalhesVaga> findAllByTipoEmpregoVaga(TipoEmpregoVaga tipoEmpregoVaga);

}
