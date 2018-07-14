package pe.edu.upc.RsOperation.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import pe.edu.upc.RsOperation.models.Tag;

import java.util.List;

@Mapper
@Component
public interface TagMapper {

    @Select("<script> SELECT t.tag_id as tagId,t.description,t.state,t.creation_date as creationDate,t.update_date updateDate,t.category_id_fk as categoryIdFk FROM tags t where t.state=1 </script>"
    )
    List<Tag> listTag();

    @Select("<script> SELECT t.tag_id as tagId,t.description,t.state,t.creation_date as creationDate,t.update_date updateDate,t.category_id_fk as categoryIdFk FROM tags t " +
            "where t.state=1 "
            +
            " <if test=\"tagId != null\">and tag_id=#{tagId}</if> </script>"
    )
    Tag getTag(Tag tag);

}


