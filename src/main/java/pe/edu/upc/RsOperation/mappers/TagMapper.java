package pe.edu.upc.RsOperation.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import pe.edu.upc.RsOperation.domains.Category;
import pe.edu.upc.RsOperation.domains.Tag;

import java.util.List;

@Mapper
@Component
public interface TagMapper {

    @Select("<script> SELECT t.tag_id,t.description,t.state,t.creation_date,t.update_date,t.category_id_fk FROM tags t where t.state=1 </script>"
    )
    List<Tag> listTag();
    @Select("<script> SELECT t.tag_id,t.description,t.state,t.creation_date,t.update_date,t.category_id_fk FROM tags t "  +
            "where t.state=1 "
            +
            " <if test=\"tag_id != null\">and tag_id=#{tag_id}</if> </script>"
    )
    Tag getTag(Tag tag);

}


