package pe.edu.upc.RsOperation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.upc.RsOperation.models.Operation;
import pe.edu.upc.RsOperation.services.OperationService;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RsOperationApplicationTests {

    private static final Logger LOGGER = LogManager.getLogger(RsOperationApplicationTests.class);

    @Autowired
    OperationService operationService;

    @Test
    public void contextLoads() {
    }

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

    @Test
    public void dateTest() {
        /*Calendar calendar = Calendar.getInstance();
        Integer month=calendar.get(Calendar.MONTH);

        LOGGER.info(month<10?"0"+month:month);*/

        LOGGER.info(new BigDecimal("0").setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }

}
