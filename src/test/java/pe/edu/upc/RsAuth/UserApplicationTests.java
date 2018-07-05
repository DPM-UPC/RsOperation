package pe.edu.upc.RsAuth;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.upc.RsOperation.domains.AccessSecurity;
import pe.edu.upc.RsOperation.domains.Country;
import pe.edu.upc.RsOperation.domains.User;
import pe.edu.upc.RsOperation.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

    private static final Logger LOGGER = LogManager.getLogger(UserApplicationTests.class);

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void userCreationTest() throws Exception {
        User user = new User();
        AccessSecurity accessSecurity = new AccessSecurity();
        Country country = new Country();

        user.setUserName("paolo29");
        user.setEmail("paolosp29@gmail.com");
        accessSecurity.setPassword("admin");
        country.setCountryId(1);//Peru

        user.getAccessSecurities().add(accessSecurity);
        user.setCountry(country);
        LOGGER.info(userService.createUser(user));
    }

    @Test
    public void userUpdateTest() throws Exception {
        User user = new User();

        user.setUserId(1);
        user.setEmail("paolosp29@gmail.com");

        LOGGER.info(userService.updateUser(user));
    }

    @Test
    public void userGetTest() throws Exception {
        User user = new User();

        //user.setUserId(1);
        user.setUserName("paolo29");

        LOGGER.info(userService.getUser(user));
    }

    @Test
    public void userListTest() throws Exception {
        User user = new User();

        LOGGER.info(userService.listUser(user));
    }

    @Test
    public void userDeleteTest() throws Exception {
        User user = new User();

        user.setUserId(1);
        userService.deleteUser(user);
    }

}
