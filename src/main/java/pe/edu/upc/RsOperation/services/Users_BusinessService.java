package pe.edu.upc.RsOperation.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.RsOperation.domains.Operation;
import pe.edu.upc.RsOperation.domains.User;
import pe.edu.upc.RsOperation.domains.Users_Business;
import pe.edu.upc.RsOperation.repositories.OperationDao;
import pe.edu.upc.RsOperation.repositories.Users_BusinessDao;

import java.util.List;

@Service
public class Users_BusinessService {
    private static final Logger LOGGER = LogManager.getLogger(OperationService.class);


    @Autowired
    Users_BusinessDao users_businessDao;
    public List<Users_Business> listUsers_Business() throws Exception {
        LOGGER.debug("listUsers_Business, Users_Business: {}", "");
        return users_businessDao.listUsers_Business();
    }

    public Users_Business getUsers_Business(Users_Business users_business) throws Exception {
        LOGGER.debug("getUsers_Business, getUsers_Business: {}",users_business);
        return users_businessDao.getUsers_Business(users_business);
    }
}
