package com.example.garageApp.service;

import com.example.garageApp.model.Car;
import com.example.garageApp.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GarageService {
    // creer les methodes CRUD
    // ajouter les methodes pour les requetes

    @Autowired
    private GarageRepository garageRepository;
    static private  ArrayList<Car> cars = new ArrayList<>(Arrays.asList(
            new Car(1,"Polo", "Volkswagen", 2017, "RED"),
            new Car(2,"X5", "BMW", 2015, "BLUE"),
            new Car(3,"Golf", "Mercedes", 2014, "GREEN"),
            new Car(4,"Coupe", "Audi", 2018, "YELLOW"),
            new Car(5,"A4", "Volkswagen", 2016, "RED"),
            new Car(6,"208", "Peugeot", 2010, "BLUE"),
            new Car(7,"Megane", "Renault", 2018, "GREEN"),
            new Car(8,"A3", "Audi", 2017, "YELLOW"),
            new Car(9,"Passat", "Volkswagen", 2011, "RED"),
            new Car(10,"500", "Fiat", 2015, "BLUE")
    ));

    public List<Car> getCars() {
        // sans le repository CRUD SIMPLE
        // return cars;

        // avec le repository
        List<Car> cars = new ArrayList<>();
        garageRepository.findAll().forEach(car -> cars.add(car));
        return cars;
    }

    public Car getCar(long id) {
        // sans le repository CRUD SIMPLE
        // return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);

        // avec le repository
        return garageRepository.findById(id).orElse(null);
    }

    public void deleteCar(long id) {
        // sans le repository CRUD SIMPLE
        //cars.removeIf(car -> car.getId() == id);
        //System.out.println("Voiture supprimée");

        // avec le repository
        garageRepository.deleteById(id);
        System.out.println("Voiture supprimée");

    }


    public void add(Car car) {
        // sans le repository CRUD SIMPLE
        //cars.add(car);
        //System.out.println("Voiture ajoutée");

        // avec le repository
        garageRepository.save(car);
        System.out.println("Voiture ajoutée");
    }


    public void updateCar(Car car, long id) {

        // sans le repository CRUD SIMPLE

        //cars.forEach(car1 -> {
           // if (car1.getId() == id) {
              //  car1.setBrand(car.getBrand());
              //  car1.setModel(car.getModel());
            // car1.setYear(car.getYear());
           // car1.setColor(car.getColor());}});
        //System.out.println("Voiture mise à jour");

        // avec le repository
        garageRepository.save(car);
        System.out.println("Voiture mise à jour");
    }
}
