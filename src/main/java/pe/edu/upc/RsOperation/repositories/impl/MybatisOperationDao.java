package pe.edu.upc.RsOperation.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.upc.RsOperation.domains.Operation;
import pe.edu.upc.RsOperation.domains.User;
import pe.edu.upc.RsOperation.mappers.OperationMapper;
import pe.edu.upc.RsOperation.repositories.OperationDao;

import java.util.List;

@Repository
public class MybatisOperationDao implements OperationDao {

    @Autowired
    OperationMapper operationMapper;

    @Override
    public int createOperation(Operation operation) throws Exception {
        return operationMapper.createOperation(operation);
    }
    @Override
    public Operation getOperation(Operation operation) throws Exception {
        return operationMapper.getOperation(operation);
    }
    @Override
    public List<Operation> listOperation(Operation operation) throws Exception {
        return operationMapper.listOperation(operation);
    }
    @Override
    public int deleteOperation(Operation operation) throws Exception {
        return operationMapper.deleteOperation(operation);
    }

    @Override
    public int updateOperation(Operation operation) throws Exception {
        return operationMapper.updateOperation(operation);
    }
}
