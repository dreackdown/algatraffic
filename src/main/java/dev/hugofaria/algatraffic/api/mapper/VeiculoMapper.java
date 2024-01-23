package dev.hugofaria.algatraffic.api.mapper;

import dev.hugofaria.algatraffic.api.model.VeiculoDTO;
import dev.hugofaria.algatraffic.api.model.input.VeiculoInput;
import dev.hugofaria.algatraffic.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class VeiculoMapper {
    private final ModelMapper modelMapper;

    public Veiculo toEntity(VeiculoInput veiculoInput) {
        return modelMapper.map(veiculoInput, Veiculo.class);
    }

    public VeiculoDTO toDTO(Veiculo veiculo) {
        return modelMapper.map(veiculo, VeiculoDTO.class);
    }

    public List<VeiculoDTO> toCollectionDTO(List<Veiculo> veiculos) {
        return veiculos.stream()
                .map(this::toDTO)
                .toList();
    }
}