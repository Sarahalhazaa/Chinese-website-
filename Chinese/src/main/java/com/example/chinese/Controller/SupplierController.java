package com.example.chinese.Controller;

import com.example.chinese.Api.ApiResponse;
import com.example.chinese.Model.Supplier;
import com.example.chinese.Service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/Supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;
    Logger logger = LoggerFactory.getLogger(SupplierController.class);

    @GetMapping("/get")
    public ResponseEntity getSupplier(){
        logger.info("inside the get all Supplier");
        return ResponseEntity.status(200).body(supplierService.getSupplier());
    }

    @PostMapping("/add")
    public ResponseEntity addSupplier(@RequestBody @Valid Supplier supplier){
        logger.info("inside add Supplier");
       supplierService.addSupplier(supplier);
        return ResponseEntity.ok().body(new ApiResponse("Supplier added"));

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity UpdateSupplier(@PathVariable Integer id, @RequestBody @Valid Supplier supplier){
        logger.info("inside Update Supplier");
       supplierService.updateSupplier(id,supplier);
        return ResponseEntity.ok().body(new ApiResponse("Supplier Update"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSupplier(@PathVariable Integer id){
        logger.info("inside delete Supplier");
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok().body(new ApiResponse("Supplier Deleted"));

    }
    //---------------------------  end CRUD  ---------------------------------

    //------------------------------    1    ----------------------------------
    @PutMapping("/evaluation/{customerId}/{orderId}/{supplierId}/{evaluation}")
    public ResponseEntity evaluation(@PathVariable Integer customerId, @PathVariable Integer orderId, @PathVariable Integer supplierId,@PathVariable Integer evaluation){
        logger.info("inside evaluation Supplier ");
       supplierService.evaluation(customerId, orderId, supplierId, evaluation);

    return ResponseEntity.ok().body(new ApiResponse("evaluation Updated"));

    }
//----------------------------------  2 ------------------------------------------
    @PutMapping("/updateStatus/{orderId}")
    public ResponseEntity updateStatus(@PathVariable Integer orderId){
        logger.info("inside updateStatus");
        supplierService.updateStatus(orderId);
        return ResponseEntity.status(200).body(new ApiResponse("status Updated"));
    }
}
