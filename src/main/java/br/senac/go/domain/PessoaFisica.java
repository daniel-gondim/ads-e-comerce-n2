package br.senac.go.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends BaseModel {

    @Column(length = 50, nullable = false)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id")
    private Pessoa pessoa;
}