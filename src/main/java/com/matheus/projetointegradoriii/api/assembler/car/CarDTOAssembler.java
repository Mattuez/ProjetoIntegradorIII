package com.matheus.projetointegradoriii.api.assembler.car;

import com.matheus.projetointegradoriii.api.model.car.CarDTO;
import com.matheus.projetointegradoriii.domain.model.Car;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarDTOAssembler {

    private ModelMapper modelMapper;

    public CarDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CarDTO toDTO(Car car) {
        return modelMapper.map(car, CarDTO.class);
    }

    public List<CarDTO> toDtoCollection(List<Car> cars) {
        return cars.stream()
                .map(car -> toDTO(car))
                .toList();
    }
}
