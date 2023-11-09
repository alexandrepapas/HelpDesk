package com.alexandreHelpDesk.services;

import com.alexandreHelpDesk.domain.Chamado;
import com.alexandreHelpDesk.domain.Cliente;
import com.alexandreHelpDesk.domain.Tecnico;
import com.alexandreHelpDesk.enuns.Perfil;
import com.alexandreHelpDesk.enuns.Prioridade;
import com.alexandreHelpDesk.enuns.Status;
import com.alexandreHelpDesk.repositories.ChamadoRepository;
import com.alexandreHelpDesk.repositories.ClienteRepository;
import com.alexandreHelpDesk.repositories.PessoaRepository;
import com.alexandreHelpDesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {


    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;


    public void instanciaDB(){
        Tecnico tec1= new Tecnico(null,"Alexandre P","08555275562","alexandrep@email.com","123");
        tec1.addPerfil(Perfil.ADMIN);

        Tecnico tec2 = new Tecnico(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", "123");
        Tecnico tec3 = new Tecnico(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", "123");
        Tecnico tec4 = new Tecnico(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", "123");
        Tecnico tec5 = new Tecnico(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com","123");

        Cliente cl1= new Cliente(null,"Linus Tovalrds","05630275622","linus@email.com","458");
        Cliente cl2= new Cliente(null,"Gerald Marilius ","05630275644","gerald@email.com","458");
        Cliente cl3= new Cliente(null,"topius teste123 ","05330275655","topius@email.com","458");
        Cliente cl4= new Cliente(null,"Marlucia GenteFina ","05230275622","marlo@email.com","458");
        Cliente cl5= new Cliente(null,"Batman Fernandes  ","051302756526","brucew@email.com","458");



        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cl1);
        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cl2);
        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cl3);
        Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cl3);
        Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cl1);
        Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cl5);



        pessoaRepository.saveAll(Arrays.asList(tec1,tec2,tec3,tec4,tec5,cl1,cl2,cl3,cl4,cl5));
        chamadoRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6));

    }
}
