package dev.hugofaria.algatraffic.config;

import dev.hugofaria.algatraffic.api.model.VeiculoDTO;
import dev.hugofaria.algatraffic.domain.model.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Veiculo.class, VeiculoDTO.class)
                .addMappings(mapper -> mapper.map(Veiculo::getPlaca, VeiculoDTO::setNumeroPlaca));

        return modelMapper;
    }
}