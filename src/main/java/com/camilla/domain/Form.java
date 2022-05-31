package com.camilla.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "O campo não pode ser nulo")
    @NotEmpty(message = "O campo nome não pode ser vazio")
    @NotBlank(message = "O campo nome não pode estar em branco")
    private String nome;
    @NotNull
    @NotEmpty
    @NotBlank
    private String telefone;
    @NotEmpty
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotEmpty
    @NotBlank
    private Double valorImovel;
}
