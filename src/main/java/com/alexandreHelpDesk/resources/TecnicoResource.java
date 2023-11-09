package com.alexandreHelpDesk.resources;

import com.alexandreHelpDesk.domain.Tecnico;
import com.alexandreHelpDesk.dtos.TecnicoDTO;
import com.alexandreHelpDesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping(value="/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
        Tecnico obj= tecnicoService.findById(id);
        return  ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

}

