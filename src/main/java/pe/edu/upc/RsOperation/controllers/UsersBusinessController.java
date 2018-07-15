package pe.edu.upc.RsOperation.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.RsOperation.models.Operation;
import pe.edu.upc.RsOperation.models.UsersBusiness;
import pe.edu.upc.RsOperation.services.Users_BusinessService;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
@RestController
@RequestMapping(value = "/usersBusiness")
public class UsersBusinessController {
    private static final Logger LOGGER = LogManager.getLogger(Operation.class);
    @Autowired
    Users_BusinessService userBusinessService;
    @GetMapping()
    /*public ResponseEntity<List<Operation>> listOperationFrom(@PathVariable(value = "user_id", required = false) Integer userId)*/
    public ResponseEntity<List<UsersBusiness>> getUsersBusinessFrom()
    {
        LOGGER.info("listOperationFrom(), user_Id: {}: ", "");


        List<UsersBusiness> userBusinessResult;
        //User userReq = new User();
        //userReq.setUserId(user_id);
        try {
            userBusinessResult = userBusinessService.listUsers_Business();
            LOGGER.info("user_businessResult: " + userBusinessResult);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        if (userBusinessResult == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok().body(userBusinessResult);
    }
}
