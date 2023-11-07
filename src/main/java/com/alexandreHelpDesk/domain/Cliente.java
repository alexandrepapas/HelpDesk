package com.alexandreHelpDesk.domain;

import com.alexandreHelpDesk.enuns.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Cliente extends  Pessoa{

    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados= new ArrayList<>();


    public Cliente (){
        addPerfil(Perfil.CLIENTE);
    }
    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);

    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
