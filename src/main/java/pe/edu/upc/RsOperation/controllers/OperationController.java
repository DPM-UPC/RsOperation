package pe.edu.upc.RsOperation.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.RsOperation.domains.Operation;
import pe.edu.upc.RsOperation.domains.User;
import pe.edu.upc.RsOperation.domains.Users_Business;
import pe.edu.upc.RsOperation.services.OperationService;


import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping(value = "/operations")
public class OperationController {
    private static final Logger LOGGER = LogManager.getLogger(Operation.class);

    @Autowired
    OperationService operationService;
    private Integer user_business_id;

    @PostMapping
    public ResponseEntity<Operation> createOperation(@RequestBody Operation operation) {
        LOGGER.info("createOperation(), operation: " + operation);
        Operation operationResult;
        try {
            operationResult = operationService.createOperation(operation);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(CREATED).body(operationResult);
    }



    @DeleteMapping("/{operation_id:^[0-9]*$}")
    public ResponseEntity deleteOperation(@PathVariable("operation_id") Integer operation_id) {

            LOGGER.info("deleteOperation(), operation_Id: " + operation_id);

        try {
          operationService.deleteOperation(new Operation(operation_id));
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(NO_CONTENT).build();
    }

    /*public ResponseEntity<List<Operation>> getOperationFrom(@PathVariable(value = "user_id", required = false) Integer userId)*/


    @GetMapping()
    public ResponseEntity<List<Operation>> getOperationFrom(@RequestParam(value = "user_business_id") Integer user_business_id)
    {
        LOGGER.info("getOperationFrom(), user_business_id: {}: ", user_business_id);
        List<Operation> operationResult;
        Operation operationReq = new Operation();
        operationReq.setUser_business_id_fk(user_business_id);
        try {
            operationResult = operationService.listOperation(operationReq);

            LOGGER.info("operationResult: " + operationResult);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        if (operationResult == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok().body(operationResult);
    }

    @PutMapping
    public ResponseEntity<Operation> updateOperation(@RequestBody Operation operation) {
        LOGGER.info("updateOperation(), operation: " + operation);
        Operation operationResult;
        try {
            operationResult = operationService.updateOperation(operation);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok().body(operationResult);
    }


}
