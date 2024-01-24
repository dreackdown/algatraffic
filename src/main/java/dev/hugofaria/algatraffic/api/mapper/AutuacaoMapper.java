package dev.hugofaria.algatraffic.api.mapper;

import dev.hugofaria.algatraffic.api.model.AutuacaoDTO;
import dev.hugofaria.algatraffic.api.model.input.AutuacaoInput;
import dev.hugofaria.algatraffic.domain.model.Autuacao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class AutuacaoMapper {

    private final ModelMapper modelMapper;

    public Autuacao toEntity(AutuacaoInput autuacaoInput) {
        return modelMapper.map(autuacaoInput, Autuacao.class);
    }

    public AutuacaoDTO toDTO(Autuacao autuacao) {
        return modelMapper.map(autuacao, AutuacaoDTO.class);
    }

    public List<AutuacaoDTO> toCollectionDTO(List<Autuacao> autuacoes) {
        return autuacoes.stream()
                .map(this::toDTO)
                .toList();
    }
}