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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginService(OngCadastroRepository ongCadastroRepository) {
        this.ongCadastroRepository = ongCadastroRepository;
    }

    public String autenticar(LoginDTO loginDTO) {
        CadastroOng cadastro = ongCadastroRepository.findByNome(loginDTO.getNome());

        if (cadastro == null) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }

        if (!passwordEncoder.matches(loginDTO.getSenha(), cadastro.getSenha())) {
            throw new IllegalArgumentException("Senha incorreta.");
        }

        String role = cadastro.getRole();
        if (role == null || role.isBlank()) {
            throw new IllegalStateException("Usuário não possui perfil definido.");
        }

        String token = jwtUtil.gerarToken(cadastro.getNome(), role);
        LOGGER.info("Login bem-sucedido para: " + cadastro.getNome());
        System.out.println("Token gerado: " + token);

        return token;
    }
}
