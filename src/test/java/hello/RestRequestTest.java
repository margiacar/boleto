package hello;

import bankslip.entities.Bankslip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =  RANDOM_PORT)
public class RestRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testCreateBankslipOK() throws Exception {
        final String URL = "http://localhost:8080/bankslips";
        Bankslip request = new Bankslip();
        request.setCustomer("Marcio");
        request.setDueDate(new Date("2019-03-22"));
        request.setTotalInCents(new BigDecimal(10.50));
        ResponseEntity<Bankslip> response = this.restTemplate.postForEntity(
                URL, request, Bankslip.class
        );
        Bankslip bankslip = response.getBody();

        assertThat(bankslip.getId()).isNotNull();
    }
}
