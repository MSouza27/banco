package br.com.banco.bem.repository;

import br.com.banco.bem.dto.ContaDTO;
import br.com.banco.bem.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query("SELECT c.numeroConta, COUNT(c) FROM Conta c GROUP BY c.numeroConta")
    List<Object[]>contagemDeQuantidadeConta();

    @Query("SELECT c FROM Conta c WHERE c.saldoFinal >= :saldoMinimo AND c.saldoFinal <= :saldoMaximo")
    List<ContaDTO>filtrarContasPorSaldoFinal(
            @Param("saldoMinimo")BigDecimal saldoMinimo,
            @Param("saldoMaximo")BigDecimal saldoMaximo
            );
}
