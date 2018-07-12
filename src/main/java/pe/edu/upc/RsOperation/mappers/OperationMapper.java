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
            "state,creation_date,user_business_id_fk,account_id_fk,category_id_fk,tag_id_fk) " +
            "values(now(),#{concept},#{amount},1,now(),#{user_business_id_fk},#{account_id_fk}" +
            ",#{category_id_fk},#{tag_id_fk}"
            + ")")
    @Options(useGeneratedKeys = true, keyProperty = "operation_id", keyColumn = "operation_id")
    int createOperation(Operation operation);

    @Select("<script>  SELECT m.operation_id,m.operation_date,m.concept,m.amount,m.state,m.creation_date,m.update_date,m.user_business_id_fk, " +
            " m.account_id_fk,m.category_id_fk,m.tag_id_fk FROM operations m where m.state=1  " +
            " <if test=\"operation_id != null\">and operation_id=#{operation_id}</if> </script>")
    Operation getOperation(Operation operation);

    @Select("<script> SELECT m.operation_id,m.operation_date,m.concept,m.amount,m.state,m.creation_date,m.update_date,m.user_business_id_fk, " +
            "m.account_id_fk,m.category_id_fk,m.tag_id_fk FROM operations m where m.state=1 " +
            "<if test=\"user_business_id_fk != null\"> and user_business_id_fk=#{user_business_id_fk}</if> </script>"
    )
    List<Operation> listOperation(Operation operation);

    @Update("update operations set state=0 WHERE operation_id=#{operation_id}")
    int deleteOperation(Operation operation);


    @Update("<script> update operations <set> update_date=now() " +
            "<if test=\"concept != null\">,concept=#{concept}</if>" +
            "<if test=\"amount != null\">,amount=#{amount}</if>"+
            "<if test=\"state != null\">,state=#{state}</if>"+
            "<if test=\"user_business_id_fk != null\">,user_business_id_fk=#{user_business_id_fk}</if>"+
            "<if test=\"account_id_fk != null\">,account_id_fk=#{account_id_fk}</if>"+
            "<if test=\"category_id_fk != null\">,category_id_fk=#{category_id_fk}</if>"+
            "<if test=\"tag_id_fk != null\">,tag_id_fk=#{tag_id_fk}</if>"+
            " </set> WHERE operation_id=#{operation_id}</script>")
    int updateOperation(Operation operation);


}
