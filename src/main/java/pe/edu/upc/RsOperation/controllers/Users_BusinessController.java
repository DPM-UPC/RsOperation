package pe.edu.upc.RsOperation.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.RsOperation.domains.Operation;
import pe.edu.upc.RsOperation.domains.User;
import pe.edu.upc.RsOperation.domains.Users_Business;
import pe.edu.upc.RsOperation.services.OperationService;
import pe.edu.upc.RsOperation.services.Users_BusinessService;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
@RestController
@RequestMapping(value = "/users_business")
public class Users_BusinessController {
    private static final Logger LOGGER = LogManager.getLogger(Operation.class);
    @Autowired
    Users_BusinessService user_businessService;
    @GetMapping()
    /*public ResponseEntity<List<Operation>> getOperationFrom(@PathVariable(value = "user_id", required = false) Integer userId)*/
    public ResponseEntity<List<Users_Business>> getUsers_BusinessFrom()
    {
        LOGGER.info("getOperationFrom(), user_Id: {}: ", "");


        List<Users_Business> user_businessResult;
        //User userReq = new User();
        //userReq.setUserId(user_id);
        try {
            user_businessResult = user_businessService.listUsers_Business();
            LOGGER.info("user_businessResult: " + user_businessResult);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        if (user_businessResult == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok().body(user_businessResult);
    }
}
