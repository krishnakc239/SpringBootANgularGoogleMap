package com.altrimetrik.countryservice.controller;

import com.altrimetrik.countryservice.model.Country;
import com.altrimetrik.countryservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/hello")
    public String hello(){
        System.out.println("inside hello mathod");
        return "hello!!!";
    }
    @GetMapping(value = "/",produces = "application/json")
    public ResponseEntity<List<Country>> index(){
        System.out.println("inside  getAll method method");
        return countryService.getAll();
    }
    @RequestMapping(value = "/{code}", produces = "application/json")
    public ResponseEntity<Country> getCOuntryCOde(@PathVariable String code){
        System.out.println("passed code =="+ code);
        System.out.println(countryService.getCountry(code));
        return countryService.getCountry(code);

    }

    @GetMapping("/search")
    public ResponseEntity<Set<Country>> search(
                                @RequestParam(required = false) String  id,
                                 @RequestParam(required = false) boolean incomeLevel,
                               @RequestParam(required = false) boolean lendingType,
                               @RequestParam(required = false) boolean region){

        return countryService.searchCountry(id,region,incomeLevel,lendingType);
    }
}
