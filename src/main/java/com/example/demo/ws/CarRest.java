package com.example.demo.ws;

import com.example.demo.dao.CarRepository;
import com.example.demo.model.Car;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarRest {
    private final CarRepository carRepository;
    public CarRest(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @GetMapping("/")
    Mono<Car> findOneByTitle(Long id){
     return this.carRepository.findOneById(id);
    }
    @PostMapping("/create/")
    Car createOrUpdateMovie(@RequestBody Car newCar) {
        return this.carRepository.save(newCar);
    }
}
