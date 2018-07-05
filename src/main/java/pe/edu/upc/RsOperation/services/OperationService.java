package pe.edu.upc.RsOperation.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.RsOperation.domains.Operation;
import pe.edu.upc.RsOperation.domains.User;
import pe.edu.upc.RsOperation.exception.ResourceException;
import pe.edu.upc.RsOperation.repositories.OperationDao;

import java.util.List;


@Service
public class OperationService {
    private static final Logger LOGGER = LogManager.getLogger(OperationService.class);


    @Autowired
    OperationDao operationDao;

    @Transactional
    public Operation createOperation(Operation operation) throws Exception {
        LOGGER.debug("createOperation, operation: {}", operation);
        if (!validateCreateRequest(operation))
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Parametro(s) invalido(s)");
        operationDao.createOperation(operation);
        LOGGER.debug("movement_Id obtenido: " + operation.getOperation_Id());
        return getOperation(new Operation(operation.getOperation_Id()));
    }
    public void deleteOperation(Operation operation) throws Exception {
        LOGGER.debug("deleteOperation, operation: {}", operation);
        if (!validateDeleteRequest(operation))
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Parametro(s) invalido(s)");
        operationDao.deleteOperation(operation);
    }

    public Operation getOperation(Operation operation) throws Exception {
        LOGGER.debug("getOperation, operation: {}", operation);
        Operation newOperation = operationDao.getOperation(operation);
        return newOperation;
    }
    public List<Operation> listOperation(User user) throws Exception {
        LOGGER.debug("listOperation, operation: {}", user);
        return operationDao.listOperation(user);
    }


    public static boolean validateCreateRequest(Operation operation) {
        boolean result = false;
        if (operation != null)
            if (operation.getConcept() != null && !operation.getConcept().isEmpty())
                if (operation.getAmount() != null && !operation.getAmount().isNaN())
                    result = true;

        return result;


    }
    public static boolean validateDeleteRequest(Operation operation) {
        boolean result = false;
        if (operation != null)
            if (operation.getOperation_Id() != null )
                result = true;

        return result;
    }
}
