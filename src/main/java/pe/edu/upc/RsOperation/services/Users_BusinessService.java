package pe.edu.upc.RsOperation.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.RsOperation.models.UsersBusiness;
import pe.edu.upc.RsOperation.repositories.UsersBusinessDao;

import java.util.List;

@Service
public class Users_BusinessService {
    private static final Logger LOGGER = LogManager.getLogger(OperationService.class);


    @Autowired
    UsersBusinessDao users_businessDao;

    public List<UsersBusiness> listUsers_Business() throws Exception {
        LOGGER.debug("listUsers_Business, UsersBusiness: {}", "");
        return users_businessDao.listUsers_Business();
    }

    public UsersBusiness getUsers_Business(UsersBusiness users_business) throws Exception {
        LOGGER.debug("getUsers_Business, getUsers_Business: {}",users_business);
        return users_businessDao.getUsers_Business(users_business);
    }
}
