package com.matheus.projetointegradoriii.api.controller;

import com.matheus.projetointegradoriii.api.assembler.car.CarDTOAssembler;
import com.matheus.projetointegradoriii.api.assembler.car.CarDTODisassembler;
import com.matheus.projetointegradoriii.api.model.car.CarDTO;
import com.matheus.projetointegradoriii.api.model.car.CarInputDTO;
import com.matheus.projetointegradoriii.domain.model.Car;
import com.matheus.projetointegradoriii.domain.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;
    private CarDTOAssembler carDTOAssembler;
    private CarDTODisassembler carDTODisassembler;

    public CarController(CarService carService, CarDTOAssembler carDTOAssembler, CarDTODisassembler carDTODisassembler) {
        this.carService = carService;
        this.carDTOAssembler = carDTOAssembler;
        this.carDTODisassembler = carDTODisassembler;
    }

    @GetMapping
    public List<CarDTO> getAll() {
        return carDTOAssembler.toDtoCollection(carService.getAll());
    }

    @GetMapping("/isAvailable/{isAvailable}")
    public List<CarDTO> getAllByAvailability(@PathVariable("isAvailable") boolean isAvailable) {
        return carDTOAssembler.toDtoCollection(carService.getAllByAvailability(isAvailable));
    }


    @GetMapping("/{carId}")
    public CarDTO getById(@PathVariable("carId") Long carId) {
        return carDTOAssembler.toDTO(carService.getCar(carId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO add(@RequestBody @Valid CarInputDTO carInput) {
        Car car = carDTODisassembler.toEntityObject(carInput);

        return carDTOAssembler.toDTO(carService.insert(car));
    }

    @PutMapping("/{carId}")
    public CarDTO update(@PathVariable("carId") Long carId, @RequestBody @Valid CarInputDTO carInputDTO) {
        Car car = carService.getCar(carId);

        carDTODisassembler.copyToEntityObject(carInputDTO, car);

        return carDTOAssembler.toDTO(carService.insert(car));
    }

    @DeleteMapping(("/{carId}"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("carId") Long carId) {
        carService.delete(carId);
    }

    @PutMapping("/{carId}/activated")
    public CarDTO activate(@PathVariable("carId") Long carId) {
        return carDTOAssembler.toDTO(carService.activate(carId));
    }

    @DeleteMapping("/{carId}/activated")
    public CarDTO deactivate(@PathVariable("carId") Long carId) {
        return carDTOAssembler.toDTO(carService.deactivate(carId));
    }
}
