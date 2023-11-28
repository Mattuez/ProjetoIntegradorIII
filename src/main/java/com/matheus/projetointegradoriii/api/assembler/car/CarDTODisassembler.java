package com.matheus.projetointegradoriii.api.assembler.car;

import com.matheus.projetointegradoriii.api.model.car.CarInputDTO;
import com.matheus.projetointegradoriii.domain.model.Car;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarDTODisassembler {

    private ModelMapper modelMapper;

    public CarDTODisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Car toEntityObject(CarInputDTO carInputDTO) {
        return modelMapper.map(carInputDTO, Car.class);
    }

    public void copyToEntityObject(CarInputDTO source, Car destination) {
        modelMapper.map(source, destination);
    }
}
