package com.alexandreHelpDesk.dtos;

import com.alexandreHelpDesk.domain.Tecnico;
import com.alexandreHelpDesk.enuns.Perfil;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TecnicoDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    protected  Integer id;
    @NotNull(message = "O Campo Nome é requerido")
    protected  String nome;
    @NotNull(message = "O Campo CPF é requerido")
    protected  String cpf;
    @NotNull(message = "O Campo EMAIL é requerido")
    protected  String email;
    @NotNull(message = "O Campo SENHA é requerido")
    protected  String senha;

    protected Set<Integer> perfis= new HashSet<>();

    protected LocalDate dataCriacao= LocalDate.now();
    public TecnicoDTO(){
        super();
        addPerfil(Perfil.CLIENTE);

    }

    public TecnicoDTO(Tecnico obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis= obj.getPerfis().stream().map(x->x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao= obj.getDataCriacao();
        addPerfil(Perfil.CLIENTE);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x-> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
