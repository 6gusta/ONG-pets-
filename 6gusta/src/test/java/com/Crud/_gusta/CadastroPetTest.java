package com.Crud._gusta;

import com.Crud._gusta.domain.model.PetModel;
import com.Crud._gusta.infrastructure.repository.CadastroRepository;
import com.Crud._gusta.application.service.CadastroPetService;
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
        PetModel model = new PetModel();
        model.setNome("Ralf");
        model.setIdade("23");
        model.setSexo("M");
        model.setPorte("Grande");
        model.setCidade("Inga");
        model.setCaracteristicas("Ralf");
        model.setDescricao("Ralf");
        model.setFotoperfil("nullo");

        when(cadastroRepository.save(any(PetModel.class))).thenReturn(model);

        PetModel resultado = cadastroPetService.cadastropet(

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
        verify(cadastroRepository, times(1)).save(any(PetModel.class));

    }
}
