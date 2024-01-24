package dev.hugofaria.algatraffic.api.controller;

import dev.hugofaria.algatraffic.api.mapper.AutuacaoMapper;
import dev.hugofaria.algatraffic.api.model.AutuacaoDTO;
import dev.hugofaria.algatraffic.api.model.input.AutuacaoInput;
import dev.hugofaria.algatraffic.domain.model.Autuacao;
import dev.hugofaria.algatraffic.domain.model.Veiculo;
import dev.hugofaria.algatraffic.domain.service.RegistroAutuacaoService;
import dev.hugofaria.algatraffic.domain.service.RegistroVeiculoService;
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
    public AutuacaoDTO registrar(@PathVariable Long veiculoId, @Valid @RequestBody AutuacaoInput autuacaoInput) {
        Autuacao novaAutuacao = autuacaoMapper.toEntity(autuacaoInput);

        Autuacao autuacaoRegistrada = autuacaoService
                .registrar(veiculoId, novaAutuacao);

        return autuacaoMapper.toDTO(autuacaoRegistrada);
    }

    @GetMapping
    public List<AutuacaoDTO> listar(@PathVariable Long veiculoId) {
        Veiculo veiculo = veiculoService.buscar(veiculoId);
        return autuacaoMapper.toCollectionDTO(veiculo.getAutuacoes());
    }
}