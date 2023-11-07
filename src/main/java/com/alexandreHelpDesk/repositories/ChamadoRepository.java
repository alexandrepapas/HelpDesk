package com.alexandreHelpDesk.repositories;


import com.alexandreHelpDesk.domain.Chamado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado,Integer> {

}
