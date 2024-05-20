package com.example.chinese.Controller;

import com.example.chinese.Api.ApiResponse;
import com.example.chinese.Model.Orders;
import com.example.chinese.Service.OrdersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/Orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;
    Logger logger = LoggerFactory.getLogger(OrdersController.class);
    @GetMapping("/get")
    public ResponseEntity getOrder(){
        logger.info("inside the get all Order");
        return ResponseEntity.status(200).body(ordersService.getOrders());
    }

    @PostMapping("/add")
    public ResponseEntity addOrder(@RequestBody @Valid Orders orders){
        logger.info("inside add Order");
       ordersService.addOrders(orders);
        return ResponseEntity.ok().body(new ApiResponse("Order added"));

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity UpdateOrder(@PathVariable Integer id, @RequestBody @Valid Orders orders){
        logger.info("inside Update Order");
        ordersService.updateOrders(id,orders);

        return ResponseEntity.ok().body(new ApiResponse("Order Update"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id){
        logger.info("inside delete Order");
       ordersService.deleteOrders(id);
        return ResponseEntity.ok().body(new ApiResponse("Order Deleted"));

    }
    //---------------------------  end CRUD  ---------------------------------
}
