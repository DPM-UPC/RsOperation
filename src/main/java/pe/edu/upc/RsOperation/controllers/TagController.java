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
import pe.edu.upc.RsOperation.domains.Tag;
import pe.edu.upc.RsOperation.services.TagService;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping(value = "/tags")
public class TagController {
    private static final Logger LOGGER = LogManager.getLogger(Tag.class);
    @Autowired
    TagService tagService;
    @GetMapping()
    public ResponseEntity<List<Tag>> getTagFrom()
    {
        LOGGER.info("getTagFrom(), : {}: ", "");


        List<Tag> tagResult;
        try {
            tagResult = tagService.listTag();
            LOGGER.info("tagResult: " + tagResult);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        if (tagResult == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok().body(tagResult);
    }
}
