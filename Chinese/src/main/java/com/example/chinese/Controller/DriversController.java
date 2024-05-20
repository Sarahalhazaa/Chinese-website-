package com.example.chinese.Controller;

import com.example.chinese.Api.ApiResponse;
import com.example.chinese.Model.Drivers;
import com.example.chinese.Service.DriversService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/vi/Drivers")
@RequiredArgsConstructor
public class DriversController {
    Logger logger = LoggerFactory.getLogger(DriversController.class);
    private final DriversService driversService;


    @GetMapping("/get")
    public ResponseEntity getDriver() {
        logger.info("inside the get all Driver");
        return ResponseEntity.status(200).body(driversService.getDrivers());
    }

    @PostMapping("/add")
    public ResponseEntity addDriver(@RequestBody @Valid Drivers drivers) {
        logger.info("inside add Driver");
        driversService.addDrivers(drivers);
        return ResponseEntity.ok().body(new ApiResponse("Driver added"));

    }

    @PutMapping("/Update/{id}")
    public ResponseEntity UpdateDriver(@PathVariable Integer id, @RequestBody @Valid Drivers drivers) {
        logger.info("inside Update Driver");
        driversService.updateDrivers(id, drivers);

        return ResponseEntity.ok().body(new ApiResponse("Driver Update"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDriver(@PathVariable Integer id) {
        logger.info("inside delete Driver");
        driversService.deleteDrivers(id);
        return ResponseEntity.ok().body(new ApiResponse("Driver Deleted"));

    }
    //---------------------------  end CRUD  ---------------------------------

    //------------------------------    1    ----------------------------------
    @GetMapping("/ordersDelivery")
    public ResponseEntity ordersDelivery() {
        logger.info("inside orders Delivery");
        return ResponseEntity.status(200).body(driversService.findOrders());
    }

    //------------------------------    2    ----------------------------------
    @PostMapping("/delivery/{driverId}/{orderId}")
    public ResponseEntity delivery(@PathVariable Integer driverId, @PathVariable Integer orderId) {
        logger.info("inside delivery");
        driversService.delivery(driverId, orderId);
        return ResponseEntity.status(200).body(new ApiResponse("The task of delivering the order was assigned to the driver"));
    }

    //------------------------------    3    ----------------------------------
    @PutMapping("/updateStatus/{driverId}/{orderId}")
    public ResponseEntity updateStatus(@PathVariable Integer driverId, @PathVariable Integer orderId) {
        logger.info("inside update Status");
        driversService.updateStatus(driverId, orderId);

        return ResponseEntity.status(200).body(new ApiResponse("order has been delivered"));
    }
    //------------------------------    4    ----------------------------------
    @GetMapping("/previousOrders/{driverId}")
    public ResponseEntity previousOrders(@PathVariable Integer driverId){
        logger.info("inside previous Orders");
        return ResponseEntity.status(200).body(driversService.previousOrders(driverId));
    }
    //------------------------------    5    ----------------------------------
    @PutMapping("/bonus/{driverId}/{numberOfOrders}/{bonus}")
    public ResponseEntity bonus(@PathVariable Integer driverId, @PathVariable Integer numberOfOrders ,@PathVariable Integer bonus){
        logger.info("inside bonus");
        driversService.bonus(driverId,numberOfOrders,bonus);

        return ResponseEntity.status(200).body(new ApiResponse("Bonus added"));

    }
}
