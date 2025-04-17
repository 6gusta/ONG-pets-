package com.Crud._gusta;

import com.Crud._gusta.model.CadastroOng;
import com.Crud._gusta.repository.OngCadastroRepository;
import com.Crud._gusta.service.OngSendService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


public class PostOngServiceTest {

    @Mock
    private OngCadastroRepository ongRepository;

    @InjectMocks
    private OngSendService ongSendService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastraOngComSucesso(){

        CadastroOng ong = new CadastroOng();

        ong.setNome("ONG Amor Animal");
        ong.setEmail("contato@ong.com");
        ong.setSenha("123456");
        ong.setRole("ONG");

        when(ongRepository.save(any(CadastroOng.class))).thenReturn(ong);

        CadastroOng resultado = ongSendService.SendService(
                ong.getNome(),
                ong.getEmail(),
                ong.getSenha(),
                ong.getRole()
        );

        assertNotNull(resultado);
        assertEquals("ONG Amor Animal", resultado.getNome());
        verify(ongRepository, times(1)).save(any(CadastroOng.class));
    }
}
