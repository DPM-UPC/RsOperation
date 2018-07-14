package pe.edu.upc.RsAuth;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.upc.RsOperation.RsOperationApplication;
import pe.edu.upc.RsOperation.models.Operation;
import pe.edu.upc.RsOperation.services.OperationService;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RsOperationApplication.class)
public class RsOperationApplicationTests {

    private static final Logger LOGGER = LogManager.getLogger(RsOperationApplicationTests.class);

    @Autowired
    OperationService operationService;

    //@Test
    public void createOperation() throws Exception {
        Operation operation = new Operation();
        operation.setAmount(new BigDecimal(2.33));
        operation.setUserBusinessIdFk(1);
        operation.setAccountIdFk(1);
        operation.setCategoryIdFk(1);
        operation.setTagIdFk(1);
        operationService.createOperation(operation);
    }

}
