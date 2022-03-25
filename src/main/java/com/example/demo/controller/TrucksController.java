package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Trucks;
import com.example.demo.repository.TrucksRepository;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;
import java.util.Optional;
import java.util.HashMap;

@RestController
// Define a common base url for all the api's
@RequestMapping("/getAllTrucks")
public class TrucksController {

    @Autowired
    private TrucksRepository trucksRepository;

//    @GetMapping
//    public List<Trucks> getAllTrucks(){
//        return trucksRepository.findAll();
//    }

    // Create Trucks REST API
    @PostMapping
    public ResponseEntity<?> createTrucks(@RequestBody Trucks truck){ // @RequestBody changes the json object to java object
        Optional<Trucks> existingTruck = trucksRepository.findById(truck.getTruck_id());

        HashMap<String, Object> response = new HashMap<>();

        if(existingTruck.isEmpty()){
            truck.setCount(truck.getSpace());
            trucksRepository.save(truck);
            response.put("status", "Success");
        }else{
            response.put("status", "Failure");
            response.put("message", "Truck already exists");

        }

        return ResponseEntity.ok(response);
    }

    // Create get truck by truck id
    @GetMapping //path variable binds the value of the id to method argument of the below method
    public ResponseEntity<?> getTruckById(@RequestParam long truckId){
        Optional<Trucks> truck = trucksRepository.findById(truckId);

        HashMap<String, Object> response = new HashMap<>();

        if(truck.isEmpty()){
            response.put("status", "Failure");

        }else{
            response.put("status", "Success");
            response.put("count", truck.get().getSpace());

        }

        return ResponseEntity.ok(response);


    }

    // Update truck rest API
    @PutMapping
    public ResponseEntity<?> updateTruck(@RequestBody Trucks truckDetails){
        Optional<Trucks> updateTruck = trucksRepository.findById(truckDetails.getTruck_id());

        HashMap<String, Object> response = new HashMap<>();

        if(updateTruck.get().getSpace() == 0){
            response.put("status", "Failure");
            response.put("message", "Truck is full");

        }else{
            updateTruck.get().setSpace(updateTruck.get().getSpace()-1);
            long spaceNumber = updateTruck.get().getCount() - updateTruck.get().getSpace();
            trucksRepository.save(updateTruck.get());
            response.put("status", "Success");
            response.put("spaceNumber", spaceNumber);
        }
        return ResponseEntity.ok(response);

    }
}
