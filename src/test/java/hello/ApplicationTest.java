package hello;

import bankslip.controllers.BankslipController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = bankslip.Application.class)
public class ApplicationTest {

    @Autowired
    private BankslipController controller;

//    @Test
//    public void contextLoads() throws Exception {
//       assertThat(controller).isNotNull();
//    }
}
