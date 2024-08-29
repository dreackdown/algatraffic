package dev.hugofaria.algatransito.api.controller;

import dev.hugofaria.algatransito.api.mapper.AutuacaoMapper;
import dev.hugofaria.algatransito.api.model.AutuacaoModel;
import dev.hugofaria.algatransito.api.model.input.AutuacaoInput;
import dev.hugofaria.algatransito.domain.model.Autuacao;
import dev.hugofaria.algatransito.domain.model.Veiculo;
import dev.hugofaria.algatransito.domain.service.RegistroAutuacaoService;
import dev.hugofaria.algatransito.domain.service.RegistroVeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {

    private final AutuacaoMapper autuacaoMapper;
    private final RegistroAutuacaoService autuacaoService;
    private final RegistroVeiculoService veiculoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoModel registrar(@PathVariable Long veiculoId, @Valid @RequestBody AutuacaoInput autuacaoInput) {
        Autuacao novaAutuacao = autuacaoMapper.toEntity(autuacaoInput);

        Autuacao autuacaoRegistrada = autuacaoService.registrar(veiculoId, novaAutuacao);

        return autuacaoMapper.toModel(autuacaoRegistrada);
    }

    @GetMapping
    public List<AutuacaoModel> listar(@PathVariable Long veiculoId) {
        Veiculo veiculo = veiculoService.buscar(veiculoId);
        return autuacaoMapper.toCollectionModel(veiculo.getAutuacoes());
    }
}