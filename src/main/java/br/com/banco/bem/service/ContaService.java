package br.com.banco.bem.service;

import br.com.banco.bem.dto.ContaDTO;
import br.com.banco.bem.model.Conta;
import br.com.banco.bem.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ContaService {
    private final ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    public ContaDTO salvarTransferencia(ContaDTO dto){
        if (dto.saldoDaConta().compareTo(dto.saldoTransferido()) >= 0){
            Conta transferencia = new Conta();
            transferencia.setNumeroConta(dto.numeroConta());
            transferencia.setSaldoDaConta(dto.saldoDaConta());
            transferencia.setSaldoTransferido(dto.saldoTransferido());
            transferencia.setSaldoFinal(dto.saldoDaConta().subtract(dto.saldoTransferido()));
            transferencia.setNumeroContaCredito(dto.numeroContaCredito());
            transferencia.setSaldoContaCredito(dto.saldoContaCredito());
            transferencia.setSaldoRecebido(dto.saldoTransferido());
            transferencia.setSaldoFinalCredito(dto.saldoContaCredito().add(dto.saldoTransferido()));
            transferencia.setDataHora(LocalDateTime.now());

            var validar = repository.save(transferencia);

            return new ContaDTO(
                    validar.getNumeroConta(),
                    validar.getSaldoDaConta(),
                    validar.getSaldoTransferido(),
                    validar.getSaldoFinal(),
                    validar.getNumeroContaCredito(),
                    validar.getSaldoContaCredito(),
                    validar.getSaldoRecebido(),
                    validar.getSaldoFinalCredito(),
                    validar.getDataHora()
            );

        }
        throw new IllegalArgumentException("O saldo da Conta menor que o saldo desejado transferir");
    }

    public Map<String, Long> listar(){
        return repository.contagemDeQuantidadeConta().stream()
                .collect(Collectors.toMap(
                        conta -> conta[0].toString(),
                        conta -> (Long) conta[1]
                ));
    }

    public List<ContaDTO> filtrar(BigDecimal saldoMinimo, BigDecimal saldoMaximo){
        return repository.filtrarContasPorSaldoFinal(saldoMinimo, saldoMaximo);
    }

}
