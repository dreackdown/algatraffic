package dev.hugofaria.algatransito.api.controller;

import dev.hugofaria.algatransito.api.mapper.VeiculoMapper;
import dev.hugofaria.algatransito.api.model.VeiculoModel;
import dev.hugofaria.algatransito.api.model.input.VeiculoInput;
import dev.hugofaria.algatransito.domain.model.Veiculo;
import dev.hugofaria.algatransito.domain.repository.VeiculoRepository;
import dev.hugofaria.algatransito.domain.service.ApreensaoVeiculoService;
import dev.hugofaria.algatransito.domain.service.RegistroVeiculoService;
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
    private final RegistroVeiculoService veiculoService;
    private final ApreensaoVeiculoService apreensaoService;
    private final VeiculoMapper veiculoMapper;

    @GetMapping
    public List<VeiculoModel> listar() {
        return veiculoMapper.toCollectionModel(veiculoRepository.findAll());
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoModel> buscar(@PathVariable Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .map(veiculoMapper::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoModel cadastrar(@Valid @RequestBody VeiculoInput veiculoInput) {
        Veiculo novoVeiculo = veiculoMapper.toEntity(veiculoInput);
        Veiculo veiculoCadastrado = veiculoService.cadastrar(novoVeiculo);

        return veiculoMapper.toModel(veiculoCadastrado);
    }

    @PutMapping("/{veiculoId}/apreensao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apreender(@PathVariable Long veiculoId) {
        apreensaoService.apreender(veiculoId);
    }

    @DeleteMapping("/{veiculoId}/apreensao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerApreensao(@PathVariable Long veiculoId) {
        apreensaoService.removerApreensao(veiculoId);
    }
}