package pe.edu.upc.RsOperation.repositories;

import pe.edu.upc.RsOperation.domains.Users_Business;

import java.util.List;

public interface Users_BusinessDao {
    List<Users_Business> listUsers_Business() throws Exception;
    Users_Business getUsers_Business(Users_Business users_business) throws Exception;


}
