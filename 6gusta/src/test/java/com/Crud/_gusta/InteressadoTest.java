package com.Crud._gusta;

import com.Crud._gusta.model.InteressadosPet;
import com.Crud._gusta.repository.InteressadosOngRepository;
import com.Crud._gusta.service.PostOng;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class InteressadoTest {

    @Mock
    InteressadosOngRepository interCadastroRepository;

    @InjectMocks
    PostOng postOng;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveCadastrarInteressado() {
        // Arrange
        InteressadosPet interessado = new InteressadosPet();
        interessado.setNome("Ong");
        interessado.setDescricao("Animal");
        interessado.setTelefone("6199192834");
        interessado.setEmail("ong.com@gusta.com.br");

        when(interCadastroRepository.save(any(InteressadosPet.class))).thenReturn(interessado);

        // Act
        InteressadosPet resultado = postOng.PostOng(
                interessado.getNome(),
                interessado.getEmail(),
                interessado.getDescricao(),
                interessado.getTelefone()
        );

        // Assert
        assertNotNull(resultado);
        assertEquals("Ong", resultado.getNome());
        verify(interCadastroRepository, times(1)).save(any(InteressadosPet.class));
    }
}
