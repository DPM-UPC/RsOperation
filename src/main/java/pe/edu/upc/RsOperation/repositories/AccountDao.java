package pe.edu.upc.RsOperation.repositories;

import pe.edu.upc.RsOperation.models.Account;

import java.util.List;

public interface AccountDao {
    List<Account> listAccount() throws Exception;
    Account getAccount(Account account) throws Exception;

}
