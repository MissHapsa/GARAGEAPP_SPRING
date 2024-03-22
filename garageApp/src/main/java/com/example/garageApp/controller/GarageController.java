package com.example.garageApp.controller;
import com.example.garageApp.model.Car;
import com.example.garageApp.service.GarageService;
import org.apache.tomcat.util.http.fileupload.ProgressListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GarageController {

// ****************************************************************************************
// ****************    CRUD DE MON APPPLICATION   ****************************
// ****************************************************************************************

    @Autowired
    private GarageService garageService;

    @RequestMapping("/cars")

    public List<Car> getCars() {
        return garageService.getCars();
    }
// cette methode renvoie la liste des vehicules dans la page cars.html en json mais aussi sur Postman
// ****************************************************************************************


    @RequestMapping("/car/{id}")
    public Car getCar(@PathVariable long id) {
        return garageService.getCar(id);
    }
// lorsuqe je specifie l id dans l url, j ai bien acces aux infos du vehicule en question
// ****************************************************************************************


    @RequestMapping(method = RequestMethod.DELETE, value = "/car/{id}")
    public void deleteCar(@PathVariable long id) {
        garageService.deleteCar(id);
    }
// car 3 a ete effacé via postaman, l id 3 n'apparait plus et j'ai bien le message "car deleted" dans la console intelij
// ****************************************************************************************

    @RequestMapping(method = RequestMethod.POST, value = "/cars")
    public void addCar(@RequestBody Car car) {
        garageService.add(car);

    }


//  en utilisant postman, j ai bien ajouté un vehicule via postman et j'ai bien le message "voiture ajoutée" dans la console
// dans postman il faut selectionner POST et le body en json et ensuite il faut selectionner le fichier json qui contient les infos du nouveau vehicule
// **********************************************************************************************

    @RequestMapping(method = RequestMethod.PUT, value = "/car/{id}")
    public void updateCar(@RequestBody Car car, @PathVariable long id) {
        garageService.updateCar(car, id);}
}


