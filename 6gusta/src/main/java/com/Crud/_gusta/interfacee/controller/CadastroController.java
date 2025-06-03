package com.Crud._gusta.interfacee.controller;


import com.Crud._gusta.application.service.*;
import com.Crud._gusta.exceptionsGenerics.CustomException;
import com.Crud._gusta.domain.model.CadastroOng;
import com.Crud._gusta.domain.model.InteressadosPet;
import com.Crud._gusta.domain.model.LoginDTO;

import com.Crud._gusta.domain.model.PetModel;
import com.Crud._gusta.infrastructure.repository.OngCadastroRepository;
import com.Crud._gusta.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api")

public class CadastroController {

    private final CadastroPetService cadastroPetService;
    private final OngSendService ongSendService;
    private final GetPetsService getPetsService;
    private final LoginService loginService;
    private final GetOng getOngService;
    private final PostOng postOngService;
    private final UpdatePets updatePetsService;
    private  final DeletePet deletePetService;
    private final FiltroPetsService filtroPetsService;
    private final OngCadastroRepository ongCadastroRepository;
    private  final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public CadastroController(CadastroPetService cadastroPetService, OngSendService ongSendService, GetPetsService getPetsService, LoginService loginService, GetOng getOngService, PostOng postOngService, UpdatePets updatePetsService, DeletePet deletePetService, FiltroPetsService filtroPetsService, OngCadastroRepository ongCadastroRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.cadastroPetService = cadastroPetService;
        this.ongSendService = ongSendService;
        this.getPetsService = getPetsService;
        this.loginService = loginService;
        this.getOngService = getOngService;
        this.postOngService = postOngService;
        this.updatePetsService = updatePetsService;
        this.deletePetService = deletePetService;
        this.filtroPetsService = filtroPetsService;
        this.ongCadastroRepository = ongCadastroRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }
    @Operation(summary = "Atualiza os dados de um pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar o pet")
    })
    @PutMapping("/user/{idpet}")
    public ResponseEntity<?> atualizarpet(@PathVariable("idpet") Long idpet, @RequestBody PetModel pet){
        PetModel model = updatePetsService.uppets(idpet, pet);

        if(model != null){
            return new ResponseEntity(model, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Exclui um pet pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pet não encontrado")
    })
    @DeleteMapping("/excluirpets/{idpet}")
    public ResponseEntity<?> excluirpets(@PathVariable("idpet") Long idpet) {

        boolean sucesso = deletePetService.DelPet(idpet);

        if (sucesso) {

            return ResponseEntity.ok(Map.of("mensagem", "pet excluído com sucesso"));
        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erro", "PET NÃO ENCONTRADO"));
        }
    }

    @Operation(summary = "Filtra pets por porte, cidade, estado ou idade")
    @GetMapping("/filtra")

    public ResponseEntity<List<PetModel>> foltrapets(



            @RequestParam(required = false) String porte,
            @RequestParam(required = false) String cidade,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String idade
    ){
        List<PetModel> resultado = filtroPetsService.filtrar(porte, cidade, estado, idade);
        return ResponseEntity.ok(resultado);
    }

    @Operation(summary = "Realiza o login e retorna o token JWT")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO loginDTO) {
        try {
            String token = loginService.autenticar(loginDTO);
            return ResponseEntity.ok(Map.of("token", token));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno.");
        }
    }

    @Operation(summary = "Registra um novo pet no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar o pet"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })

      @PostMapping("/register")
    public ResponseEntity<String> registerPet(@RequestBody PetModel pet) {

            System.out.println(" recebendo dados do pet"+ pet.toString());
            PetModel petSalvo = cadastroPetService.cadastropet(
                    pet.getNome(),
                    pet.getIdade(),
                    pet.getSexo(),
                    pet.getPorte(),
                    pet.getCidade(),
                    pet.getCaracteristicas(),
                    pet.getDescricao(),
                    pet.getFotoperfil(),
                    pet.getEstado()
            );

            if (petSalvo != null) {
                return ResponseEntity.ok("Pet cadastrado com sucesso");
            } else {
                return ResponseEntity.status(400).body("Erro ao cadastrar o pet");
            }
    }


    @Operation(summary = "Registra uma nova ONG")
    @PostMapping("/admin/registerong")
    public ResponseEntity<String> registerOng(@RequestBody CadastroOng cadastroOng) {


            CadastroOng ongSalva = ongSendService.SendService(
                    cadastroOng.getNome(),
                    cadastroOng.getEmail(),
                    cadastroOng.getSenha()
            );

            if (ongSalva != null) {
                return ResponseEntity.ok("ONG registrada com sucesso");
            } else {
                return ResponseEntity.status(400).body("Erro ao registrar a ONG");
            }

    }

    @Operation(summary = "Busca um pet pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet encontrado"),
            @ApiResponse(responseCode = "404", description = "Pet não encontrado")
    })


    @GetMapping("/pets/{idpet}")
    public ResponseEntity<?> buscapet(@PathVariable("idpet") Long idpet) {
        Optional<PetModel> pet = getPetsService.buscarpet(idpet);

        return pet.map(ResponseEntity::ok)
                .orElseThrow(() -> new CustomException("Pet não encontrado", "PET_NOT_FOUND"));
    }


    @Operation(summary = "Lista todos os pets cadastrados")
    @GetMapping("/pet")
    public ResponseEntity<List<PetModel>> listarPets() {
        List<PetModel> pets = getPetsService.listarTodos();
        return ResponseEntity.ok(pets);
    }


    @Operation(summary = "Lista todos os interessados em adotar")
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
    @Operation(summary = "Cadastra um novo interessado")
    @PostMapping("/Cadastrointer")
    public ResponseEntity<String> cadastroInteressado(@RequestBody InteressadosPet interessado) {

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


    }

}