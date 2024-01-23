package dev.hugofaria.algatraffic.api.controller;

import dev.hugofaria.algatraffic.api.mapper.VeiculoMapper;
import dev.hugofaria.algatraffic.api.model.VeiculoDTO;
import dev.hugofaria.algatraffic.api.model.input.VeiculoInput;
import dev.hugofaria.algatraffic.domain.model.Veiculo;
import dev.hugofaria.algatraffic.domain.repository.VeiculoRepository;
import dev.hugofaria.algatraffic.domain.service.RegistroVeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;
    private final RegistroVeiculoService registroVeiculoService;
    private final VeiculoMapper veiculoMapper;

    @GetMapping
    public List<VeiculoDTO> listar() {
        return veiculoMapper.toCollectionDTO(veiculoRepository.findAll());
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoDTO> buscar(@PathVariable Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .map(veiculoMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoDTO cadastrar(@Valid @RequestBody VeiculoInput veiculoInput) {
        Veiculo novoVeiculo = veiculoMapper.toEntity(veiculoInput);
        Veiculo veiculoCadastrado = registroVeiculoService.cadastrar(novoVeiculo);

        return veiculoMapper.toDTO(veiculoCadastrado);
    }
}