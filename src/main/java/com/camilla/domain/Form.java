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
    @Pattern(regexp = "\\d+", message = "Você deve informar apenas números!")
    private String telefone;
    @NotEmpty(message = "O campo e-mail não pode ser vazio")
    @NotNull(message = "O campo não pode ser nulo")
    @NotBlank(message = "O campo e-mail não pode estar em branco")
    @Email(message = "Você deve informar um e-mail válido!")
    private String email;
    @NotNull(message = "O campo não pode ser nulo")
    @NotEmpty
    @NotBlank
    private String valorImovel;
}
