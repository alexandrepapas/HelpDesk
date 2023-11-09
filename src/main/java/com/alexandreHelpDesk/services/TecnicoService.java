package com.alexandreHelpDesk.services;

import com.alexandreHelpDesk.domain.Tecnico;
import com.alexandreHelpDesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj= tecnicoRepository.findById(id);
        return obj.orElse(null);
    }



}
