package pe.edu.upc.RsOperation.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.RsOperation.domains.Operation;
import pe.edu.upc.RsOperation.domains.User;
import pe.edu.upc.RsOperation.services.OperationService;


import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping(value = "/operation")
public class OperationController {
    private static final Logger LOGGER = LogManager.getLogger(Operation.class);

    @Autowired
    OperationService operationService;

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
    public ResponseEntity deleteOperation(@PathVariable("operation_id") Integer operation_Id) {

            LOGGER.info("deleteOperation(), operation_Id: " + operation_Id);

        try {
          operationService.deleteOperation(new Operation(operation_Id));
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @GetMapping("/{user_id:^[0-9]*$}")
    public ResponseEntity<List<Operation>> getOperationFrom(@PathVariable(value = "user_id", required = false) Integer userId) {
        LOGGER.info("getOperationFrom(), user_Id: {}: ", userId);
        List<Operation> operationResult;
        User userReq = new User();
        userReq.setUserId(userId);
        try {
            operationResult = operationService.listOperation(userReq);
            LOGGER.info("operationResult: " + operationResult);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        if (operationResult == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok().body(operationResult);
    }



}
