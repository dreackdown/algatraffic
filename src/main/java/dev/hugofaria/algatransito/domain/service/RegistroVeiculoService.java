package dev.hugofaria.algatransito.domain.service;

import dev.hugofaria.algatransito.domain.exception.EntidadeNaoEncontradaException;
import dev.hugofaria.algatransito.domain.exception.NegocioException;
import dev.hugofaria.algatransito.domain.model.Proprietario;
import dev.hugofaria.algatransito.domain.model.StatusVeiculo;
import dev.hugofaria.algatransito.domain.model.Veiculo;
import dev.hugofaria.algatransito.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class RegistroVeiculoService {

    private final VeiculoRepository veiculoRepository;

    private final RegistroProprietarioService proprietarioService;

    public Veiculo buscar(Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veículo não encontrado"));
    }

    @Transactional
    public Veiculo cadastrar(Veiculo novoVeiculo) {
        if (novoVeiculo.getId() != null) {
            throw new NegocioException("Veículo a ser cadastrado não deve possuir um código.");
        }

        boolean placaEmUso = veiculoRepository.findByPlaca(novoVeiculo.getPlaca())
                .filter(veiculo -> !veiculo.equals(novoVeiculo))
                .isPresent();

        if (placaEmUso) {
            throw new NegocioException("Já existe um veículo cadastrado com essa placa.");
        }

        Proprietario proprietario = proprietarioService.buscar(novoVeiculo.getProprietario().getId());

        novoVeiculo.setProprietario(proprietario);
        novoVeiculo.setStatus(StatusVeiculo.REGULAR);
        novoVeiculo.setDataCadastro(OffsetDateTime.now());

        return veiculoRepository.save(novoVeiculo);
    }
}