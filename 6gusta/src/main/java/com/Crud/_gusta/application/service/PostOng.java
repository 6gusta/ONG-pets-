package com.Crud._gusta.application.service;


import com.Crud._gusta.domain.model.InteressadosPet;
import com.Crud._gusta.infrastructure.repository.InteressadosOngRepository;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PostOng {

   private final InteressadosOngRepository interessadosOngRepository;
   private final EmailService emailService;

    private static final Logger LOGGER = Logger.getLogger(PostOng.class.getName());

    public PostOng(InteressadosOngRepository interessadosOngRepository, EmailService emailService) {
        this.interessadosOngRepository = interessadosOngRepository;
        this.emailService = emailService;
    }



    public InteressadosPet PostOng(String nome, String email, String whatsap, String descricao) {



            InteressadosPet interessadosPet = new InteressadosPet();
            interessadosPet.setNome(nome);
            interessadosPet.setEmail(email);
            interessadosPet.setDescricao(descricao);
            interessadosPet.setTelefone(whatsap);

        InteressadosPet salvo = interessadosOngRepository.save(interessadosPet);

        // Envia o e-mail para a ONG
        String destinatario = "luiz.carvalho7110@sounidesc.com.br"; // coloque aqui o e-mail real da ONG
        String assunto = "Novo interessado no pet!";
        String corpo = "Nome: " + nome + "\nE-mail: " + email + "\nWhatsApp: " + whatsap + "\nDescrição: " + descricao;

        emailService.enviarEmail(destinatario, assunto, corpo);

        return salvo;




        }


    }

