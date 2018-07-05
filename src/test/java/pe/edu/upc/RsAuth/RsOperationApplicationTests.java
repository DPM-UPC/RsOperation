package pe.edu.upc.RsAuth;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.upc.RsOperation.domains.User;
import pe.edu.upc.RsOperation.services.AccessTokenService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RsOperationApplicationTests {

    private static final Logger LOGGER = LogManager.getLogger(RsOperationApplicationTests.class);

    @Autowired
    AccessTokenService accessTokenService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void accessTokenTest() throws Exception {

        User user = new User();
        user.setUserName("paolo29");
        user.setUserPassword("admin");

        LOGGER.info(accessTokenService.getAuthToken(user));
    }

}
