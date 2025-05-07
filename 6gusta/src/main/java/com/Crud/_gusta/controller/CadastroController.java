package com.Crud._gusta.controller;


import com.Crud._gusta.exceptionsGenerics.CustomException;
import com.Crud._gusta.model.CadastroOng;
import com.Crud._gusta.model.InteressadosPet;
import com.Crud._gusta.model.LoginDTO;
import com.Crud._gusta.model.Model;
import com.Crud._gusta.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200",  allowCredentials = "true")
@RequestMapping("/api")
public class CadastroController {

    private final CadastroPetService cadastroPetService;
    private final OngSendService ongSendService;
    private final GetPetsService getPetsService;
    private final LoginService loginService;
    private final GetOng getOngService;
    private final PostOng postOngService;

    public CadastroController(CadastroPetService cadastroPetService, OngSendService ongSendService, GetPetsService getPetsService, LoginService loginService, GetOng getOngService, PostOng postOngService) {
        this.cadastroPetService = cadastroPetService;
        this.ongSendService = ongSendService;
        this.getPetsService = getPetsService;
        this.loginService = loginService;
        this.getOngService = getOngService;
        this.postOngService = postOngService;
    }

    @PostMapping("/admin/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        String user = loginService.auntenticao(loginDTO);

        if (user != null) {
            return ResponseEntity.ok("Login bem-sucedido");
        }


        throw new CustomException("Credenciais inválidas", "LOGIN_INVALID");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerPet(@RequestBody Model pet) {
        try {
            System.out.println(" recebendo dados do pet"+ pet.toString());
            Model petSalvo = cadastroPetService.cadastropet(
                    pet.getNome(),
                    pet.getIdade(),
                    pet.getSexo(),
                    pet.getPorte(),
                    pet.getCidade(),
                    pet.getCaracteristicas(),
                    pet.getDescricao(),
                    pet.getFotoperfil()
            );



            if (petSalvo != null) {
                return ResponseEntity.ok("Pet cadastrado com sucesso");
            } else {
                return ResponseEntity.status(400).body("Erro ao cadastrar o pet");
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro no servidor: " + e.getMessage());
        }
    }

    @PostMapping("admin/registerong")
    public ResponseEntity<String> registerOng(@RequestBody CadastroOng cadastroOng) {
        try {
            CadastroOng ongSalva = ongSendService.SendService(
                    cadastroOng.getNome(),
                    cadastroOng.getEmail(),
                    cadastroOng.getSenha(),
                    cadastroOng.getRole()
            );

            if (ongSalva != null) {
                return ResponseEntity.ok("ONG registrada com sucesso");
            } else {
                return ResponseEntity.status(400).body("Erro ao registrar a ONG");
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro no servidor: " + e.getMessage());
        }
    }

    @GetMapping("/pets/{idpet}")
    public ResponseEntity<?> buscapet(@PathVariable("idpet") Long idpet) {
        Optional<Model> pet = getPetsService.buscarpet(idpet);

        return pet.map(ResponseEntity::ok)
                .orElseThrow(() -> new CustomException("Pet não encontrado", "PET_NOT_FOUND"));
    }

    @GetMapping("/pet")
    public ResponseEntity<List<Model>> listarPets() {
        List<Model> pets = getPetsService.listarTodos();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/ongs")
    public ResponseEntity<List<InteressadosPet>> interessadosPets() {
        List<InteressadosPet> ongs = getOngService.buscaONGs();

        return ResponseEntity.ok(ongs);


    }



    @GetMapping("/ong/{idCadastrado}")

    public ResponseEntity<?> buscarOng(@PathVariable("idCadastrado") Long idCadastrado) {

        Optional<InteressadosPet> ong = getOngService.buscaONG(idCadastrado);
        if (ong.isPresent()) {
            return ResponseEntity.ok(ong.get());
        }else{
            return  ResponseEntity.status(404).body("Erro ao buscar interessado");
        }



    }

    @PostMapping("/Cadastrointer")
    public ResponseEntity<String> cadastroInteressado(@RequestBody InteressadosPet interessado) {
        try {
            InteressadosPet salvo = postOngService.PostOng(
                    interessado.getNome(),
                    interessado.getEmail(),
                    interessado.getTelefone(),
                    interessado.getDescricao()
            );

            if (salvo != null) {
                return ResponseEntity.ok("Interessado cadastrado com sucesso");
            } else {
                return ResponseEntity.badRequest().body("Erro ao salvar interessado");
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro no servidor: " + e.getMessage());
        }
    }





}