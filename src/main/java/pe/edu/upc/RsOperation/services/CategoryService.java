package pe.edu.upc.RsOperation.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.RsOperation.domains.Account;
import pe.edu.upc.RsOperation.domains.Category;
import pe.edu.upc.RsOperation.repositories.AccountDao;
import pe.edu.upc.RsOperation.repositories.CategoryDao;

import java.util.List;
@Service
public class CategoryService {
    private static final Logger LOGGER = LogManager.getLogger(CategoryService.class);


    @Autowired
    CategoryDao categoryDao;
    public List<Category> listCategory() throws Exception {
        LOGGER.debug("listCategory, listCategory: {}", "");
        return categoryDao.listCategory();
    }

    public Category getCategory(Category category) throws Exception {
        LOGGER.debug("getCategory, getCategory: {}",category);
        return categoryDao.getCategory(category);
    }
}
