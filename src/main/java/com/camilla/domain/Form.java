package com.camilla.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
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
    @Temporal(TemporalType.DATE)
    @Column(name = "publication_date", columnDefinition = "DATE")
    private Date publicationDate;

}
