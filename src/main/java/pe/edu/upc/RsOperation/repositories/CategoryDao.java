package pe.edu.upc.RsOperation.repositories;

import pe.edu.upc.RsOperation.domains.Account;
import pe.edu.upc.RsOperation.domains.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> listCategory() throws Exception;
    Category getCategory(Category category) throws Exception;

}
