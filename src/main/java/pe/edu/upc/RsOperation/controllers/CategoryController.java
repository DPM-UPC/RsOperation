package pe.edu.upc.RsOperation.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.RsOperation.domains.Account;
import pe.edu.upc.RsOperation.domains.Category;
import pe.edu.upc.RsOperation.services.AccountService;
import pe.edu.upc.RsOperation.services.CategoryService;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    private static final Logger LOGGER = LogManager.getLogger(Account.class);
    @Autowired
    CategoryService categoryService;
    @GetMapping()
    public ResponseEntity<List<Category>> getCategoryFrom()
    {
        LOGGER.info("getCategoryFrom(), : {}: ", "");


        List<Category> categoryResult;
        try {
            categoryResult = categoryService.listCategory();
            LOGGER.info("categoryResult: " + categoryResult);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        if (categoryResult == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok().body(categoryResult);
    }


}
