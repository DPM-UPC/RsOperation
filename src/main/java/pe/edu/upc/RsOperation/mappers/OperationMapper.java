package pe.edu.upc.RsOperation.mappers;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import pe.edu.upc.RsOperation.models.Operation;

import java.util.List;


@Mapper
@Component
public interface OperationMapper {
    @Insert("insert into operations (amount, operation_date, " +
            "state,creation_date,user_business_id_fk,account_id_fk,category_id_fk,tag_id_fk) " +
            "values(#{amount}, #{operationDate},1,now(),#{userBusinessIdFk},#{accountIdFk}" +
            ",#{categoryIdFk},#{tagIdFk}"
            + ")")
    @Options(useGeneratedKeys = true, keyProperty = "operationId", keyColumn = "operation_id")
    int createOperation(Operation operation);

    @Select("<script>  SELECT m.operation_id as operationId,m.operation_date as operation_date,m.amount, m.operation_date as operationDate,m.state,m.creation_date as creationDate,m.update_date as updateDate," +
            " m.user_business_id_fk as userBusinessIdFk, m.account_id_fk as accountIdFk,m.category_id_fk as categoryIdFk,m.tag_id_fk as tagIdFk FROM operations m where m.state=1  " +
            " <if test=\"operationId != null\">and operation_id=#{operationId}</if> </script>")
    Operation getOperation(Operation operation);

    @Select("<script> SELECT m.operation_id as operationId,m.operation_date as operation_date,m.amount, m.operation_date as operationDate,m.state,m.creation_date as creationDate,m.update_date as updateDate, " +
            "m.user_business_id_fk as userBusinessIdFk, m.account_id_fk as accountIdFk,m.category_id_fk as categoryIdFk,m.tag_id_fk as tagIdFk FROM operations m where m.state=1 " +
            "<if test=\"operation.userBusinessIdFk != null\"> and user_business_id_fk=#{operation.userBusinessIdFk}</if> " +
            "<if test=\"operation.accountIdFk != null\"> and account_id_fk=#{operation.accountIdFk}</if> " +
            "<if test=\"period != null\"> and MONTH(operation_date)=#{period}</if> </script>"
    )
    List<Operation> listOperation(@Param("operation") Operation operation, @Param("period") Integer period);

    @Update("update operations set state=0 WHERE operation_id=#{operationId}")
    int deleteOperation(Operation operation);

    @Update("<script> update operations <set> update_date=now() " +
            "<if test=\"amount != null\">,amount=#{amount}</if>"+
            "<if test=\"state != null\">,state=#{state}</if>"+
            "<if test=\"userBusinessIdFk != null\">,user_business_id_fk=#{userBusinessIdFk}</if>" +
            "<if test=\"accountIdFk != null\">,account_id_fk=#{accountIdFk}</if>" +
            "<if test=\"categoryIdFk != null\">,category_id_fk=#{categoryIdFk}</if>" +
            "<if test=\"tagIdFk != null\">,tag_id_fk=#{tagIdFk}</if>" +
            " </set> WHERE operation_id=#{operationId}</script>")
    int updateOperation(Operation operation);


}
