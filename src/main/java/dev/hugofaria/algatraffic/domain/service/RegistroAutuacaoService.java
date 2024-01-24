package dev.hugofaria.algatraffic.domain.service;

import dev.hugofaria.algatraffic.domain.model.Autuacao;
import dev.hugofaria.algatraffic.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroAutuacaoService {

    private final RegistroVeiculoService veiculoService;

    @Transactional
    public Autuacao registrar(Long veiculoId, Autuacao novaAutuacao) {
        Veiculo veiculo = veiculoService.buscar(veiculoId);
        return veiculo.adicionarAutuacao(novaAutuacao);
    }
}