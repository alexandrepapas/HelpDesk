package com.alexandreHelpDesk;

import com.alexandreHelpDesk.domain.Chamado;
import com.alexandreHelpDesk.domain.Cliente;
import com.alexandreHelpDesk.domain.Tecnico;
import com.alexandreHelpDesk.enuns.Perfil;
import com.alexandreHelpDesk.enuns.Prioridade;
import com.alexandreHelpDesk.enuns.Status;
import com.alexandreHelpDesk.repositories.ChamadoRepository;
import com.alexandreHelpDesk.repositories.ClienteRepository;
import com.alexandreHelpDesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1= new Tecnico(null,"Alexandre P","08630274662","alehy@email.com","123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cl1= new Cliente(null,"Linus Tovalrds","05630275622","linus@email.com","458");

		Chamado c1= new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO,"Chamado 01","Primeiro Chamado",tec1,cl1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cl1));
		chamadoRepository.saveAll(Arrays.asList(c1));


	}
}
