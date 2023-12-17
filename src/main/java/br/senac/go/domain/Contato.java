package br.senac.go.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "contato")
public class Contato extends BaseModel {
    @Column(name = "data_inicio", length = 50, nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim", length = 50, nullable = false)
    private LocalDateTime dataFim;

    //Relacionamento Bi-direcional
    /**
     * Sugestão é sempre LAZY (forma preguiçosa de fazer a consulta).
     * A consulta é realizada somente quando a propriedade é 'invocada'.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
    /**
     * A configuração @OneToMany por padrão o fetch é sempre LAZY
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones;
}
