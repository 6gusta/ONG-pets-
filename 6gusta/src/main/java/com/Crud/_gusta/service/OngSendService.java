package com.Crud._gusta.service;


import com.Crud._gusta.model.CadastroOng;
import com.Crud._gusta.repository.OngCadastroRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OngSendService {

    private final OngCadastroRepository ongCadastroRepository;
    private static final Logger LOGGER = Logger.getLogger(OngSendService.class.getName());

    public OngSendService(OngCadastroRepository ongCadastroRepository) {
        this.ongCadastroRepository = ongCadastroRepository;
    }

    public CadastroOng SendService(String nome, String email, String senha, String role) {
        try {


            CadastroOng cadastro = new CadastroOng();
            cadastro.setNome(nome);
            cadastro.setEmail(email);
            cadastro.setSenha(BCrypt.hashpw(senha, BCrypt.gensalt()));
            cadastro.setRole(role);

            return ongCadastroRepository.save(cadastro);


        } catch (Exception e) {
            LOGGER.severe(" erro ao cria um cadastro");

            return null;


        }
    }

}
