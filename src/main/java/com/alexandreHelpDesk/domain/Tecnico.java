package com.alexandreHelpDesk.domain;

import com.alexandreHelpDesk.enuns.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Tecnico extends  Pessoa{

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

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
