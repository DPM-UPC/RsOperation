package pe.edu.upc.RsOperation.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import pe.edu.upc.RsOperation.models.Category;

import java.util.List;

@Mapper
@Component
public interface CategoryMapper {
    @Select("<script> SELECT c.category_id as categoryId,c.description,c.state,c.creation_date as creationDate,c.update_date as updateDate,c.account_id_fk as accountIdFk " +
            "FROM categories c where c.state=1 </script>"
    )
    List<Category> listCategory();

    @Select("<script> SELECT c.category_id as categoryId,c.description,c.state,c.creation_date as creationDate,c.update_date as updateDate,c.account_id_fk as accountIdFk " +
            "FROM categories c where c.state=1 " +
            " <if test=\"categoryId != null\">and category_id=#{categoryId}</if> </script>"
    )
    Category getCategory(Category category);

}
