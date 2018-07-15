package pe.edu.upc.RsOperation.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.upc.RsOperation.mappers.UsersBusinessMapper;
import pe.edu.upc.RsOperation.models.UsersBusiness;
import pe.edu.upc.RsOperation.repositories.UsersBusinessDao;

import java.util.List;
@Repository
public class MybatisUsersBusinessDao implements UsersBusinessDao {
    @Autowired
    UsersBusinessMapper users_businessMapper;


    @Override
    public List<UsersBusiness> listUsers_Business() throws Exception {
        return users_businessMapper.listUsers_Business();
    }
    @Override
    public UsersBusiness getUsers_Business(UsersBusiness users_business) throws Exception {
        return users_businessMapper.getUsers_Business(users_business);
    }

}
