package pe.edu.upc.RsOperation.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.RsOperation.exception.ResourceException;
import pe.edu.upc.RsOperation.models.Operation;
import pe.edu.upc.RsOperation.services.OperationService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/operations")
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
        } catch (ResourceException e) {
            LOGGER.error("error recurso detectado: ", e);
            return ResponseEntity.status(e.getHttpStatus()).body(null);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(CREATED).body(operationResult);
    }

    @DeleteMapping("/{operation_id:^[0-9]*$}")
    public ResponseEntity deleteOperation(@PathVariable("operation_id") Integer operationId) {

        LOGGER.info("deleteOperation(), operationId: " + operationId);

        try {
            operationService.deleteOperation(new Operation(operationId));
        } catch (ResourceException e) {
            LOGGER.error("error recurso detectado: ", e);
            return ResponseEntity.status(e.getHttpStatus()).body(null);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @GetMapping()
    public ResponseEntity<List<Operation>> listOperationFrom(@RequestParam(value = "user_business_id") Integer userBusinessId, @RequestParam(value = "account_id", required = false) Integer accountId
            , @RequestParam(value = "period", required = false) Integer period) {
        LOGGER.info("listOperationFrom(), userBusinessId: {}: , accountId: {}, period: {}", userBusinessId, accountId, period);
        List<Operation> operationResult;
        Operation operationReq = new Operation();
        operationReq.setUserBusinessIdFk(userBusinessId);
        operationReq.setAccountIdFk(accountId);
        try {
            operationResult = operationService.listOperation(operationReq, period);

            LOGGER.info("operationResult: " + operationResult);
        } catch (ResourceException e) {
            LOGGER.error("error recurso detectado: ", e);
            return ResponseEntity.status(e.getHttpStatus()).body(null);
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
        } catch (ResourceException e) {
            LOGGER.error("error recurso detectado: ", e);
            return ResponseEntity.status(e.getHttpStatus()).body(null);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok().body(operationResult);
    }


}
