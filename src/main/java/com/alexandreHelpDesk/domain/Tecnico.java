package com.alexandreHelpDesk.domain;

import com.alexandreHelpDesk.dtos.TecnicoDTO;
import com.alexandreHelpDesk.enuns.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Tecnico extends  Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados= new ArrayList<>();



    public Tecnico(){
        addPerfil(Perfil.CLIENTE);
    }

    public Tecnico(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);

    }
    public Tecnico(TecnicoDTO obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis= obj.getPerfis().stream().map(x->x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao= obj.getDataCriacao();
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
