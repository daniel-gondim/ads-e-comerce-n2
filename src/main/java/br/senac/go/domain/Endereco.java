package br.senac.go.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "endereco")
public class Endereco extends BaseModel{

    private String logradouro;

    @Column(name = "data_inicio", length = 50, nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_inicio", length = 50, nullable = false)
    private LocalDateTime dataFim;
    //private Contato contato;

}
