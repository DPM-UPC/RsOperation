package pe.edu.upc.RsOperation.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import pe.edu.upc.RsOperation.domains.Account;
import pe.edu.upc.RsOperation.domains.Category;

import java.util.List;

@Mapper
@Component
public interface CategoryMapper {
    @Select("<script> SELECT c.category_id,c.description,c.state,c.creation_date,c.update_date,c.account_id_fk FROM categories c where c.state=1 </script>"
    )
    List<Category> listCategory();
    @Select("<script> SELECT c.category_id,c.description,c.state,c.creation_date,c.update_date,c.account_id_fk FROM categories c "  +
            "where c.state=1 "
            +
            " <if test=\"category_id != null\">and category_id=#{category_id}</if> </script>"
    )
    Category getCategory(Category category);

}
