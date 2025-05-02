package br.com.banco.bem.controller;

import br.com.banco.bem.dto.ContaDTO;
import br.com.banco.bem.model.Conta;
import br.com.banco.bem.service.ContaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/conta")
public class ContaController {
    private final ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ContaDTO> salvarConta(@RequestBody @Valid ContaDTO dto){
        var dados = service.salvarTransferencia(dto);
        return ResponseEntity.status(201).body(dados);
    }

    @GetMapping("/listar")
    @Transactional
    public ResponseEntity<Map<String, Long>>listarTodos(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/filtrar")
    @Transactional
    public ResponseEntity<List<ContaDTO>>filtrar(
            @RequestParam BigDecimal saldoMinimo,
            @RequestParam BigDecimal saldoMaximo){

        List<ContaDTO> dto = service.filtrar(saldoMinimo, saldoMaximo);
        return ResponseEntity.ok(dto);
    }
}
