package pe.edu.upc.RsOperation.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.RsOperation.exception.ResourceException;
import pe.edu.upc.RsOperation.models.Account;
import pe.edu.upc.RsOperation.models.Category;
import pe.edu.upc.RsOperation.models.Operation;
import pe.edu.upc.RsOperation.models.Tag;
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
        LOGGER.debug("movement_Id obtenido: " + operation.getOperationId());
        return getOperation(new Operation(operation.getOperationId()));
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

        Account account = accountDao.getAccount(new Account(newOperation.getAccountIdFk()));
        newOperation.setAccount(account);

        Tag tag = tagDao.getTag(new Tag(newOperation.getTagIdFk()));
        newOperation.setTag(tag);

        Category category = categoryDao.getCategory(new Category(newOperation.getCategoryIdFk()));

        newOperation.getTag().setCategory(category);

        return newOperation;
    }

    public List<Operation> listOperation(Operation operation, Integer period) throws Exception {
        LOGGER.debug("listOperation, operation: {}", operation.getUserBusinessIdFk());
        List<Operation> listOperation = operationDao.listOperation(operation, period);

        for (Operation rowoperation : listOperation) {

            Account account = accountDao.getAccount(new Account(rowoperation.getAccountIdFk()));
            rowoperation.setAccount(account);

            Tag tag = tagDao.getTag(new Tag(rowoperation.getTagIdFk()));
            rowoperation.setTag(tag);

            Category category = categoryDao.getCategory(new Category(rowoperation.getCategoryIdFk()));

            rowoperation.getTag().setCategory(category);

            LOGGER.debug("listOperation, rowoperation 1: {}", rowoperation);

        }

        return listOperation;

    }

    public Operation updateOperation(Operation operation) throws Exception {
        LOGGER.debug("updateOperation, operation: {}", operation);
        if (!validateUpdateRequest(operation))
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Parametro(s) invalido(s)");
        operationDao.updateOperation(operation);
        return getOperation(new Operation(operation.getOperationId()));
    }

    public static boolean validateCreateRequest(Operation operation) {
        boolean result = false;
        if (operation != null)
            if (operation.getOperationDate() != null)
                if (operation.getAmount() != null)
                    result = true;

        return result;


    }

    public static boolean validateUpdateRequest(Operation operation) {
        boolean result = false;
        if (operation != null)
            if (operation.getOperationId() != null)
                result = true;

        return result;


    }

    public static boolean validateDeleteRequest(Operation operation) {
        boolean result = false;
        if (operation != null)
            if (operation.getOperationId() != null)
                result = true;

        return result;
    }
}
