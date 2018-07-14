package pe.edu.upc.RsOperation.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import pe.edu.upc.RsOperation.models.Account;

import java.util.List;

@Mapper
@Component
public interface AccountMapper {
    @Select("<script> SELECT a.account_id as accountId,a.description,a.main_account as mainAccount,a.sign,a.state,a.creation_date as creationDate," +
            "a.update_date as updateDate FROM accounts a where a.state=1 </script>"
    )
    List<Account> listAccount();

    @Select("<script> SELECT a.account_id as accountId,a.description,a.main_account as mainAccount,a.sign,a.state,a.creation_date as creationDate, " +
            "a.update_date as updateDate FROM accounts a where a.state=1 "
            +
            " <if test=\"accountId != null\">and account_id=#{accountId}</if> </script>"
    )
    Account getAccount(Account account);

}
