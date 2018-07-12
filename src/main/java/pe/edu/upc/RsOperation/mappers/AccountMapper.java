package pe.edu.upc.RsOperation.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import pe.edu.upc.RsOperation.domains.Account;
import pe.edu.upc.RsOperation.domains.Users_Business;

import java.util.List;

@Mapper
@Component
public interface AccountMapper {
    @Select("<script> SELECT a.account_id,a.description,a.main_account,a.sign,a.state,a.creation_date,a.update_date FROM accounts a where a.state=1 </script>"
    )
    List<Account> listAccount();
    @Select("<script> SELECT a.account_id,a.description,a.main_account,a.sign,a.state,a.creation_date, "  +
            "a.update_date FROM accounts a where a.state=1 "
            +
            " <if test=\"account_id != null\">and account_id=#{account_id}</if> </script>"
    )
    Account getAccount(Account account);

}
