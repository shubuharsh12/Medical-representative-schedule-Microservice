package com.pharmacysupply.controller;

import com.pharmacysupply.entity.RepSchedule;
import com.pharmacysupply.entity.MedicineStock;
import com.pharmacysupply.helper.DateDealer;
import com.pharmacysupply.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDate;

import java.util.List;

@RestController
@CrossOrigin
/*      A convenience annotation that is itself annotated with @Controller and @ResponseBody.Types that carry this
        annotation are treated as controllers where @RequestMapping methods assume @ResponseBody semantics by default.
        NOTE: @RestController is processed if an appropriate HandlerMapping-HandlerAdapter
         pair is configured such as the RequestMappingHandlerMapping-RequestMappingHandlerAdapter
         pair which are the default in the MVC Java config and the MVC namespace.
        */

@RequestMapping("/RepSchedule")
//RequestMapping is an Annotation for mapping web
// requests onto methods in request-handling classes with
// flexible method signatures, here the api is RepSchedule.
public class SupplyController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private RestTemplate restTemplate;

//SupplyController is a primary function which will handle the date.
    public SupplyController() {
    }
    //here we send the date as the input in api, to satisfy the business requirement
    @GetMapping("/{date}")
    public ResponseEntity<List<RepSchedule>> getDoctors(@PathVariable("date") String date) {
        try {
            //Declaring a localDate variable d , which initial value is Null
            LocalDate d = null;
            //d will store the date information it got from api.
            d = LocalDate.parse(date);
            //list is a doctor_list type  of variable which will have all the data.
            List<RepSchedule> list = this.doctorService.getAllDoctors();
            //Here we create a new class that will deal with the given date and make sure it follows the logic.
            DateDealer dateDealer = new DateDealer();
            //creating new class that will call the list with the date and return the list with the date function
            //implemented in it.
            list = dateDealer.placeDates(list, d);
            //Getting the information from the Medicine_Stock service for the business logic
            List<MedicineStock> list_medicine = restTemplate.getForObject("http://localhost:8082/MedicineStockInformation/", List.class);

            if (list.size() <= 0) {
                //If no data is received, then send the HTTP "Not Found" error.
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }//if the data is found, send the CREATED status and also show the data
            return ResponseEntity.status(HttpStatus.OK).body(list);
            //If the exception is caught, then show the bad Request
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
    }



}
