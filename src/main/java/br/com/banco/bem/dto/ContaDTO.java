package br.com.banco.bem.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ContaDTO(
        BigDecimal numeroConta,
        BigDecimal saldoDaConta,
        BigDecimal saldoTransferido,
        BigDecimal saldoFinal,
        BigDecimal numeroContaCredito,
        BigDecimal saldoContaCredito,
        BigDecimal saldoRecebido,
        BigDecimal saldoFinalCredito,
        LocalDateTime dataHora
) {


}
