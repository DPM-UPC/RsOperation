package pe.edu.upc.RsOperation.mappers;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import pe.edu.upc.RsOperation.domains.Operation;
import pe.edu.upc.RsOperation.domains.User;

import java.util.List;


@Mapper
@Component
public interface OperationMapper {
    @Insert("insert into operations (operation_date,concept,amount," +
            "state,creation_date,user_business_id,account_id,category_id,tag_id,user_id) " +
            "values(now(),#{concept},#{amount},1,now(),#{user_business_Id},#{account_Id}"+
            ",#{category_Id},#{tag_Id},#{user_Id}"
            +")")
    @Options(useGeneratedKeys = true, keyProperty = "operation_Id", keyColumn = "operation_id")
    int createOperation(Operation operation);

    @Select("<script>  select m.operation_id,m.operation_date,m.concept,m.amount,m.state,m.creation_date,m.update_date,m.user_business_id," +
            " m.account_id,m.category_id,m.tag_id FROM operations m " +
            " where m.state=1  <if test=\"operation_Id != null\">and operation_id=#{operation_Id}</if> </script>")
    Operation getOperation(Operation operation);

    @Select("<script> select m.operation_id,m.operation_date,m.concept,m.amount,m.state,m.creation_date,m.update_date,m.user_business_id," +
            "m.account_id,m.category_id,m.tag_id FROM operations m where m.state=1 "+
            "<if test=\"userId != null\"> and user_id=#{userId}</if> </script>"
    )
    List<Operation> listOperation(User user);

    @Update("update operations set state=0 WHERE operation_id=#{operation_Id}")
    int deleteOperation(Operation operation);


}
