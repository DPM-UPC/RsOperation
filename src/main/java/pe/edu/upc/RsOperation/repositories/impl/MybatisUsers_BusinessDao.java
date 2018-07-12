package pe.edu.upc.RsOperation.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.upc.RsOperation.domains.Operation;
import pe.edu.upc.RsOperation.domains.User;
import pe.edu.upc.RsOperation.domains.Users_Business;
import pe.edu.upc.RsOperation.mappers.UserMapper;
import pe.edu.upc.RsOperation.mappers.Users_BusinessMapper;
import pe.edu.upc.RsOperation.repositories.Users_BusinessDao;

import java.util.List;
@Repository
public class MybatisUsers_BusinessDao implements Users_BusinessDao {
    @Autowired
    Users_BusinessMapper users_businessMapper;


    @Override
    public List<Users_Business> listUsers_Business() throws Exception {
        return users_businessMapper.listUsers_Business();
    }
    @Override
    public Users_Business getUsers_Business(Users_Business users_business) throws Exception {
        return users_businessMapper.getUsers_Business(users_business);
    }

}
