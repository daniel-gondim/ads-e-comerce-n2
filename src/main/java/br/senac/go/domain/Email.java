package br.senac.go.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "email")
public class Email extends BaseModel{

    @Column(name = "endereco_email", length = 50, nullable = false)
    private String enderecoEmail;

    @Column(name = "data_inicio", length = 50, nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim", length = 50, nullable = false)
    private LocalDateTime dataFim;
    //private Contato contato;
}
