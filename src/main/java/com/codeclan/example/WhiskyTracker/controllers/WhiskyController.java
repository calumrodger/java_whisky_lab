package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value="/whisky1")
    public ResponseEntity<List<Whisky>> findWhiskyByYear(
            @RequestParam(name="year", required = false) int year){
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }


    @GetMapping(value="/whisky2")
    public ResponseEntity<List<Whisky>> findWhiskyByDistilleryNameAndAge(
            @RequestParam (name="distillery", required = false) String distillery,
            @RequestParam(name="age", required = false) int age){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndAge(
                distillery, age), HttpStatus.OK);
    }

    @GetMapping(value="/whisky3")
    public ResponseEntity<List<Whisky>> findWhiskyByRegion(
            @RequestParam (name="region", required = false) String region){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
    }


}
