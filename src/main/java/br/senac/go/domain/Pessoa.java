package br.senac.go.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
@Table(name = "pessoa")
public class Pessoa extends BaseModel {

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(name = "data_inicio", length = 50, nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim", length = 50, nullable = false)
    private LocalDateTime dataFim;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private List<Contato> contatos;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id")
    private List<PessoaFisica> pessoaFisicas;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id")
    private List<PessoaJuridica> pessoaJuridicas;
}
