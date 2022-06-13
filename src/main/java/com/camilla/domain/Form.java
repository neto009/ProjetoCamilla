package com.camilla.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

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
    @NotNull(message = "O campo não pode ser nulo")
    @NotEmpty(message = "O campo telefone não pode ser vazio")
    @NotBlank(message = "O campo telefone não pode estar em branco")
    @Min(value = 8, message = "O telefone deve possuir no minimo 08 digitos!")
    @Pattern(regexp = "\\d+", message = "Você deve informar apenas números!")
    private String telefone;
    @NotEmpty
    @NotNull
    @NotBlank
    @Email(message = "Você deve informar um e-mail válido!")
    private String email;
    @NotNull
    @NotEmpty
    @NotBlank
    private String valorImovel;
}
