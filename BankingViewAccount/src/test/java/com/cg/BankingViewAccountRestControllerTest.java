package com.cg;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.entity.Account;
import com.cg.exceptions.AccountException;
import com.cg.exceptions.CustomerException;

class BankingViewAccountRestControllerTest {

	private RestTemplate rt = new RestTemplate();

	@Test
	public void testViewDetailsbyAccID() {
		String url ="http://localhost:8034/cgbank/viewaccountbyaccid/PBI1856427";
		ResponseEntity<List<Account>> resp = rt.exchange(url,HttpMethod.GET, null, new ParameterizedTypeReference<List<Account>>(){});
		assertFalse(resp.getBody().isEmpty());
	}
	@Test
	public void testViewDetailsbyAccIDNotFound() throws AccountException {
		String url = "http://localhost:8034/cgbank/viewaccountbyaccid/PBI1856434";
		assertThrows(HttpClientErrorException.class, ()-> rt.exchange(url,HttpMethod.GET,null, new ParameterizedTypeReference<List<Account>>(){}));
		
	}
	
	@Test
	public void testViewDetailsbyCustID() {
		String url ="http://localhost:8034/cgbank/viewaccountsbycustid/11734";
		ResponseEntity<List<Account>> resp = rt.exchange(url,HttpMethod.GET, null, new ParameterizedTypeReference<List<Account>>(){});
		assertFalse(resp.getBody().isEmpty());
	}
	
	@Test
	public void testViewDetailsbyCustIDNotFound() throws CustomerException{
		String url = "http://localhost:8034/cgbank/viewaccountsbycustid/10934";
		assertThrows(HttpClientErrorException.class, ()-> rt.exchange(url,HttpMethod.GET,null, new ParameterizedTypeReference<List<Account>>(){}));
		
	}

}
