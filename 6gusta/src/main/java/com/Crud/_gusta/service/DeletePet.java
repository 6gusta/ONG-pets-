package com.Crud._gusta.service;



import com.Crud._gusta.model.PetModel;
import com.Crud._gusta.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DeletePet {

    @Autowired
    CadastroRepository cadastroRepository;

    private static final Logger LOGGER = Logger.getLogger(DeletePet.class.getName());


    public  Boolean DelPet(Long idpet) {

        try {
            PetModel model  = cadastroRepository.findById(idpet).orElse(null);
            if(model != null) {
                LOGGER.warning(" O pet não existe");
            }

            cadastroRepository.delete(model);
            LOGGER.warning(" Deletado com sucesso");



            return true;
        }catch (Exception e) {

            LOGGER.warning(" ERRO AO TENTA EXECUTAR O METODO ");
            e.printStackTrace();
            return false;

        }



    }
}
