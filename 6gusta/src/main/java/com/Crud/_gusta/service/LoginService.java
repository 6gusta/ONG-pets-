package com.Crud._gusta.service;

import com.Crud._gusta.model.CadastroOng;
import com.Crud._gusta.model.LoginDTO;
import com.Crud._gusta.repository.OngCadastroRepository;
import com.Crud._gusta.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LoginService {

    private final OngCadastroRepository ongCadastroRepository;

    private static final Logger LOGGER = Logger.getLogger(LoginService.class.getName());

    public LoginService(OngCadastroRepository ongCadastroRepository) {
        this.ongCadastroRepository = ongCadastroRepository;
    }
     @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtil jwtUtil;
    public String  auntenticao(LoginDTO logindto){

     try {


         CadastroOng auth = ongCadastroRepository.findByNome(logindto.getNome());
         if (auth != null && passwordEncoder.matches(logindto.getSenha(), auth.getSenha())) {

             LOGGER.info(" login bem sucedido " + auth);
             return jwtUtil.GerarToken(auth.getNome(), auth.getRole());


         }
     }catch (Exception e){



         LOGGER.severe( " erro no metodo de cadastra um pet" + e.getMessage());

        }
        return null;

    }
}
