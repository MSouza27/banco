package br.com.banco.bem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "conta")
@Getter
@Setter
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Conta Pagadora
    private BigDecimal numeroConta;
    private BigDecimal saldoDaConta;
    private BigDecimal saldoTransferido;
    private BigDecimal saldoFinal;

    //Conta Recebe
    private BigDecimal numeroContaCredito;
    private BigDecimal saldoContaCredito;
    private BigDecimal saldoRecebido;
    private BigDecimal saldoFinalCredito;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataHora;

}
