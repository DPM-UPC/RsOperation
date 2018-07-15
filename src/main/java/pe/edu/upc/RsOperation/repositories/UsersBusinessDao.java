package pe.edu.upc.RsOperation.repositories;

import pe.edu.upc.RsOperation.models.UsersBusiness;

import java.util.List;

public interface UsersBusinessDao {
    List<UsersBusiness> listUsers_Business() throws Exception;

    UsersBusiness getUsers_Business(UsersBusiness users_business) throws Exception;


}
