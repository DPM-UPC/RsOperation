package pe.edu.upc.RsOperation.repositories;

import pe.edu.upc.RsOperation.domains.Operation;
import pe.edu.upc.RsOperation.domains.User;

import java.util.List;

public interface OperationDao {

    int createOperation(Operation operation) throws Exception;

    int updateOperation(Operation operation) throws Exception;

    Operation getOperation(Operation operation) throws Exception;

    List<Operation> listOperation(Operation operation) throws Exception;

    int deleteOperation(Operation operation) throws Exception;
}
