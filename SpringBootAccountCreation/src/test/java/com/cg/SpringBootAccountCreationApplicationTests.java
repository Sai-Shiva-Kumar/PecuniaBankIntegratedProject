package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.cg.dto.AccountForm;
import com.cg.dto.CustomerForm;
import com.cg.exceptions.AgeException;
import com.cg.exceptions.CustomerException;
import com.cg.service.AccountService;
@RunWith(SpringRunner.class)

@SpringBootTest
public class SpringBootAccountCreationApplicationTests {
@Autowired
AccountService service;

	
	@Test
	public void addAccountNotNUll() throws CustomerException  {
		AccountForm accForm = new AccountForm("salaried",87654,"2020942019");
		assertEquals("salaried2020942019", service.addAccount(accForm));
	}
	@Test
	public void addCustomerNotNUll() throws CustomerException, AgeException {
		CustomerForm custForm = new CustomerForm("duesp","roi2","ghatkesar","17806767862893","ATSQ667035","9709786555","MALE",LocalDate.of(1999, 03, 21));
				assertEquals("2020942019", service.addCustomer(custForm));
	}
}