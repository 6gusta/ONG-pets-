package com.Crud._gusta;

import com.Crud._gusta.model.CadastroOng;
import com.Crud._gusta.model.Model;
import com.Crud._gusta.repository.CadastroRepository;
import com.Crud._gusta.service.CadastroPetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CadastroPetTest {

    @Mock
    private CadastroRepository cadastroRepository;

    @InjectMocks
    private CadastroPetService cadastroPetService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveCadastrarPetComSucesso(){
        Model model = new Model();
        model.setNome("Ralf");
        model.setIdade("23");
        model.setSexo("M");
        model.setPorte("Grande");
        model.setCidade("Inga");
        model.setCaracteristicas("Ralf");
        model.setDescricao("Ralf");
        model.setFotoperfil("nullo");

        when(cadastroRepository.save(any(Model.class))).thenReturn(model);

        Model resultado = cadastroPetService.cadastropet(

                model.getNome(),
                model.getIdade(),
                model.getSexo(),
                model.getPorte(),
                model.getCidade(),
                model.getCaracteristicas(),
                model.getDescricao(),
                model.getFotoperfil(),
                model.getEstado()

        );

        assertNotNull(resultado);
        assertEquals("Ralf", resultado.getNome());
        verify(cadastroRepository, times(1)).save(any(Model.class));

    }
}
