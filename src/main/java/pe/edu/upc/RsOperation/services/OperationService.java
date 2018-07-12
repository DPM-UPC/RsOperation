package pe.edu.upc.RsOperation.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.RsOperation.domains.*;
import pe.edu.upc.RsOperation.exception.ResourceException;
import pe.edu.upc.RsOperation.repositories.*;

import java.util.List;


@Service
public class OperationService {
    private static final Logger LOGGER = LogManager.getLogger(OperationService.class);

    @Autowired
    Users_BusinessDao users_businessDao;
    @Autowired
    AccountDao accountDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    TagDao tagDao;
    @Autowired
    OperationDao operationDao;

    @Transactional
    public Operation createOperation(Operation operation) throws Exception {
        LOGGER.debug("createOperation, operation: {}", operation);
        if (!validateCreateRequest(operation))
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Parametro(s) invalido(s)");
        operationDao.createOperation(operation);
        LOGGER.debug("movement_Id obtenido: " + operation.getOperation_id());
        return getOperation(new Operation(operation.getOperation_id()));
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
    public List<Operation> listOperation(Operation operation) throws Exception {
        LOGGER.debug("listOperation, operation: {}", operation.getUser_business_id_fk());
       List<Operation> listOperation = operationDao.listOperation(operation);

        for (Operation rowoperation:listOperation) {
            LOGGER.debug("listOperation, rowoperation 0: {}", rowoperation);
            Users_Business users_Business = users_businessDao.getUsers_Business(new Users_Business(rowoperation.getUser_business_id_fk()));
            rowoperation.setUsers_business(users_Business);

            Account account = accountDao.getAccount(new Account(rowoperation.getAccount_id_fk()));
            rowoperation.setAccount(account);

            Category category = categoryDao.getCategory(new Category(rowoperation.getCategory_id_fk()));
            rowoperation.setCategory(category);

            Tag tag = tagDao.getTag(new Tag(rowoperation.getTag_id_fk()));
            rowoperation.setTag(tag);

            LOGGER.debug("listOperation, rowoperation 1: {}", rowoperation);

        }

        return listOperation;

    }
    public Operation updateOperation(Operation operation) throws Exception {
        LOGGER.debug("updateOperation, operation: {}", operation);
        if (!validateUpdateRequest(operation))
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Parametro(s) invalido(s)");
        operationDao.updateOperation(operation);
        return getOperation(new Operation(operation.getOperation_id()));
    }

    public static boolean validateCreateRequest(Operation operation) {
        boolean result = false;
        if (operation != null)
            if (operation.getConcept() != null && !operation.getConcept().isEmpty())
                if (operation.getAmount() != null && !operation.getAmount().isNaN())
                    result = true;

        return result;


    }
    public static boolean validateUpdateRequest(Operation operation) {
        boolean result = false;
        if (operation != null)
            if (operation.getOperation_id() != null )
                    result = true;

        return result;


    }
    public static boolean validateDeleteRequest(Operation operation) {
        boolean result = false;
        if (operation != null)
            if (operation.getOperation_id() != null )
                result = true;

        return result;
    }
}
