package com.Crud._gusta.application.service;



import com.Crud._gusta.domain.model.PetModel;
import com.Crud._gusta.infrastructure.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DeletePet {

    @Autowired
    CadastroRepository cadastroRepository;

    private static final Logger LOGGER = Logger.getLogger(DeletePet.class.getName());

    public Boolean DelPet(Long idpet) {
        PetModel model = cadastroRepository.findById(idpet)
                .orElseThrow(() -> new IllegalArgumentException("Pet não encontrado com ID: " + idpet));

        cadastroRepository.delete(model);
        LOGGER.warning("Deletado com sucesso");

        return true;
    }
}
