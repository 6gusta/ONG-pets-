package com.Crud._gusta.service;


import com.Crud._gusta.model.InteressadosPet;
import com.Crud._gusta.repository.InteressadosOngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PostOng {

   private final InteressadosOngRepository interessadosOngRepository;

    private static final Logger LOGGER = Logger.getLogger(PostOng.class.getName());

    public PostOng(InteressadosOngRepository interessadosOngRepository) {
        this.interessadosOngRepository = interessadosOngRepository;
    }



    public InteressadosPet PostOng(String nome, String email, String whatsap, String descricao) {
        try {


            InteressadosPet interessadosPet = new InteressadosPet();
            interessadosPet.setNome(nome);
            interessadosPet.setEmail(email);
            interessadosPet.setDescricao(descricao);
            interessadosPet.setTelefone(whatsap);

            return interessadosOngRepository.save(interessadosPet);

        }catch (Exception e) {
            LOGGER.severe(" erro ao cria um cadastro");
            return null;

        }


    }
}
