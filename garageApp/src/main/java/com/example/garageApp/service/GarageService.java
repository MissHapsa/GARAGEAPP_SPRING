package com.example.garageApp.service;

import com.example.garageApp.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GarageService {
    // creer les methodes CRUD
    // ajouter les methodes pour les requetes
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
        return cars;
    }

    public Car getCar(long id) {
        return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }

    public void deleteCar(long id) {
        cars.removeIf(car -> car.getId() == id);
        System.out.println("Voiture supprimée");

    }


    public void add(Car car) {
        cars.add(car);
        System.out.println("Voiture ajoutée");
    }
    public void updateCar(Car car, long id) {
        cars.forEach(car1 -> {
            if (car1.getId() == id) {
                car1.setBrand(car.getBrand());
                car1.setModel(car.getModel());
            car1.setYear(car.getYear());
            car1.setColor(car.getColor());
        }
        }
        );
        System.out.println("Voiture mise à jour");

    }
}
