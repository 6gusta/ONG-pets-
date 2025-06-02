package com.Crud._gusta.domain.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginDTO {
   @NotBlank(message = "O nome de usuário é obrigatório")
   private  String nome;
   @NotBlank(message = " A senha e  obrigatoria ")
   private String senha;
}
