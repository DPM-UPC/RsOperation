package pe.edu.upc.RsOperation.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.upc.RsOperation.mappers.CategoryMapper;
import pe.edu.upc.RsOperation.models.Category;
import pe.edu.upc.RsOperation.repositories.CategoryDao;

import java.util.List;

@Repository
public class MybatisCategoryDao implements CategoryDao {
    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public List<Category> listCategory() throws Exception {
        return categoryMapper.listCategory();
    }
    @Override
    public Category getCategory(Category category) throws Exception {
        return categoryMapper.getCategory(category);
    }
}
