package pe.edu.upc.RsOperation.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.RsOperation.models.Account;
import pe.edu.upc.RsOperation.repositories.AccountDao;

import java.util.List;

@Service
public class AccountService {
    private static final Logger LOGGER = LogManager.getLogger(AccountService.class);


    @Autowired
    AccountDao accountDao;
    public List<Account> listAccount() throws Exception {
        LOGGER.debug("listAccount, listAccount: {}", "");
        return accountDao.listAccount();
    }

    public Account getAccount(Account account) throws Exception {
        LOGGER.debug("getAccount, getAccount: {}",account);
        return accountDao.getAccount(account);
    }
}
