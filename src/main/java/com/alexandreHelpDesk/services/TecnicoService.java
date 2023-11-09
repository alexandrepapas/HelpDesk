package com.alexandreHelpDesk.services;

import com.alexandreHelpDesk.domain.Pessoa;
import com.alexandreHelpDesk.domain.Tecnico;
import com.alexandreHelpDesk.dtos.TecnicoDTO;
import com.alexandreHelpDesk.execptions.DataIntegrityViolationException;
import com.alexandreHelpDesk.execptions.ObjectNotFoundExecpetion;
import com.alexandreHelpDesk.repositories.PessoaRepository;
import com.alexandreHelpDesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj= tecnicoRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundExecpetion("Objeto não encontrado id: "+id));
    }

    public List<Tecnico> findAll() {
        return  tecnicoRepository.findAll();
    }

    public Tecnico create(TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(null);
        validaPorCpfEEmail(tecnicoDTO);
        Tecnico newObj = new Tecnico(tecnicoDTO);
        return tecnicoRepository.save( newObj);
    }

    private void validaPorCpfEEmail(TecnicoDTO tecnicoDTO){
        Optional<Pessoa> obj= pessoaRepository.findByCpf(tecnicoDTO.getCpf());
        if(obj.isPresent()  && obj.get().getId() != tecnicoDTO.getId()){
            throw  new DataIntegrityViolationException("CPF JA Cadastrado  no sistema! ");
        }

        obj = pessoaRepository.findByEmail(tecnicoDTO.getEmail());
        if(obj.isPresent()  && obj.get().getId() != tecnicoDTO.getId()){
            throw  new DataIntegrityViolationException("Email Já Cadastrado  no sistema!");
        }
    }


}
