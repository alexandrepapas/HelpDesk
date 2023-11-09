package com.alexandreHelpDesk.services;

import com.alexandreHelpDesk.domain.Tecnico;
import com.alexandreHelpDesk.execptions.ObjectNotFoundExecpetion;
import com.alexandreHelpDesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj= tecnicoRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundExecpetion("Objeto não encontrado id: "+id));
    }

    public List<Tecnico> findAll() {
        return  tecnicoRepository.findAll();
    }
}
