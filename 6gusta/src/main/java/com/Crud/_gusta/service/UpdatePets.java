package com.Crud._gusta.service;


import com.Crud._gusta.model.PetModel;
import com.Crud._gusta.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UpdatePets {

    @Autowired
    CadastroRepository cadastro;

public PetModel uppets(Long  idpet, PetModel novousaurio){


    Optional <PetModel> opt = cadastro.findById(idpet);

    if(opt.isPresent()){
        PetModel model = opt.get();
        model.setNome(novousaurio.getNome());
        model.setIdade(novousaurio.getIdade());
        model.setSexo(novousaurio.getSexo());
        model.setPorte(novousaurio.getPorte());
        model.setCidade(novousaurio.getCidade());
        model.setCaracteristicas(novousaurio.getCaracteristicas());
        model.setDescricao(novousaurio.getDescricao());
        model.setFotoperfil(novousaurio.getFotoperfil());

        return cadastro.save(model);
    }else{
        return null;
    }

}

}
