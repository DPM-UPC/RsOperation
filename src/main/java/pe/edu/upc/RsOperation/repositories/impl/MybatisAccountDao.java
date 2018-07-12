package pe.edu.upc.RsOperation.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.upc.RsOperation.domains.Account;
import pe.edu.upc.RsOperation.domains.Users_Business;
import pe.edu.upc.RsOperation.mappers.AccountMapper;
import pe.edu.upc.RsOperation.mappers.Users_BusinessMapper;
import pe.edu.upc.RsOperation.repositories.AccountDao;

import java.util.List;

@Repository
public class MybatisAccountDao implements AccountDao {
    @Autowired
    AccountMapper accountMapper;


    @Override
    public List<Account> listAccount() throws Exception {
        return accountMapper.listAccount();
    }
    @Override
    public Account getAccount(Account account) throws Exception {
        return accountMapper.getAccount(account);
    }
}
