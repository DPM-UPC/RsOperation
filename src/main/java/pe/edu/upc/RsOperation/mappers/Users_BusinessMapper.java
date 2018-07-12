package pe.edu.upc.RsOperation.mappers;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import pe.edu.upc.RsOperation.domains.Users_Business;


import java.util.List;
@Mapper
@Component
public interface Users_BusinessMapper {

    @Select("<script> SELECT ub.user_business_id,ub.business_description,ub.state,ub.creation_date,ub.update_date,ub.user_id_fk, "  +
            "ub.business_id_fk FROM users_business ub where ub.state=1 </script>"
    )
    List<Users_Business> listUsers_Business();
    @Select("<script> SELECT ub.user_business_id,ub.business_description,ub.state,ub.creation_date,ub.update_date,ub.user_id_fk, "  +
            "ub.business_id_fk FROM users_business ub where ub.state=1"
            +
            " <if test=\"user_business_id != null\">and user_business_id=#{user_business_id}</if> </script>"
    )
    Users_Business getUsers_Business(Users_Business users_business);

}
