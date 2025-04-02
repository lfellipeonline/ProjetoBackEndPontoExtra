package com.lfellipe.ProjetoBackEndPontoExtra.repository;

import com.lfellipe.ProjetoBackEndPontoExtra.entity.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoasRepository extends JpaRepository<Pessoas, Long> {
}
