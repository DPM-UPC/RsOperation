package pe.edu.upc.RsOperation.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.RsOperation.models.Account;
import pe.edu.upc.RsOperation.services.AccountService;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
    private static final Logger LOGGER = LogManager.getLogger(Account.class);
    @Autowired
    AccountService accountService;
    @GetMapping()
    public ResponseEntity<List<Account>> getAccountFrom()
    {
        LOGGER.info("getAccountFrom(), : {}: ", "");


        List<Account> accountResult;
        try {
            accountResult = accountService.listAccount();
            LOGGER.info("accountResult: " + accountResult);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        if (accountResult == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok().body(accountResult);
    }
}
