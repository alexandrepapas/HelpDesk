package com.alexandreHelpDesk.resources;

import com.alexandreHelpDesk.domain.Tecnico;
import com.alexandreHelpDesk.dtos.TecnicoDTO;
import com.alexandreHelpDesk.services.TecnicoService;
import jakarta.servlet.Servlet;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/tecnicos")
public class    TecnicoResource {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping(value="/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
        Tecnico obj= tecnicoService.findById(id);
        return  ResponseEntity.ok().body(new TecnicoDTO(obj));
    }
    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findall(){
        List<Tecnico> list= tecnicoService.findAll();
        List<TecnicoDTO> listDto= list.stream().map(obj-> new TecnicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO tecnicoDTO){
        Tecnico tecnico = tecnicoService.create(tecnicoDTO);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tecnico.getId()).toUri();
        return  ResponseEntity.created(null).build();

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> update(@PathVariable Integer id,@Valid @RequestBody TecnicoDTO objDto){
        Tecnico obj = tecnicoService.update(id, objDto);
        return  ResponseEntity.ok(new TecnicoDTO(obj));
    }

}
teste123
