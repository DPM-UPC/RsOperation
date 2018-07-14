package pe.edu.upc.RsOperation.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import pe.edu.upc.RsOperation.models.UsersBusiness;

import java.util.List;
@Mapper
@Component
public interface UsersBusinessMapper {

    @Select("<script> SELECT ub.user_business_id,ub.state,ub.creation_date,ub.update_date,ub.user_id_fk, " +
            "ub.business_id_fk FROM users_business ub where ub.state=1 </script>"
    )
    List<UsersBusiness> listUsers_Business();

    @Select("<script> SELECT ub.user_business_id,ub.state,ub.creation_date,ub.update_date,ub.user_id_fk, " +
            "ub.business_id_fk FROM users_business ub where ub.state=1"
            +
            " <if test=\"user_business_id != null\">and user_business_id=#{user_business_id}</if> </script>"
    )
    UsersBusiness getUsers_Business(UsersBusiness users_business);

}
