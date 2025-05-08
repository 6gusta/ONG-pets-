package com.Crud._gusta.service;

import com.Crud._gusta.model.Model;
import com.Crud._gusta.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UpdatePets {

    @Autowired
    CadastroRepository cadastro;

public Model uppets(Long  idpet, Model novousaurio){


    Optional <Model> opt = cadastro.findById(idpet);

    if(opt.isPresent()){
        Model model = opt.get();
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
