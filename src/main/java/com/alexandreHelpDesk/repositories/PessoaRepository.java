package com.alexandreHelpDesk.repositories;

import com.alexandreHelpDesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository  extends JpaRepository<Pessoa,Integer> {
}