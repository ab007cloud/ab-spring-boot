package com.ab.restfulws.controller;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.json.JSONException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.junit4.SpringRunner;

import com.ab.restfulws.AbSpringBootEmployeeServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AbSpringBootEmployeeServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeServiceControllerIT {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@LocalServerPort
	private int port;

	TestRestTemplate testRestTemplate = new TestRestTemplate();
	HttpHeaders httpHeaders = new HttpHeaders();

	@Before
	public void before() {

		httpHeaders.add("Authorization", createHttpHeaders("user1", "user1"));
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testFindEmployeeById() throws JSONException {
		LOGGER.info("Integration Test is running on PORT :" + port);
		String url = "http://localhost:" + port + "/employee/1";
		HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);

		ResponseEntity<String> responseEntity = testRestTemplate.exchange(url, HttpMethod.GET, httpEntity,
				String.class);

		String actual = responseEntity.getBody();
		LOGGER.info("Actual :" + actual);
		String expected = "{employeeID:1,employeeName:employee1,employeeContacts:[],environmentInfo:null}";
		JSONAssert.assertEquals(expected, actual, true);

	}

	private String createHttpHeaders(String userId, String password) {

		String auth = userId + ":" + password;
		byte[] encodedAuth = Base64.encode(auth.getBytes(Charset.forName("US-ASCII")));
		String headerValue = "Basic " + new String(encodedAuth);

		return headerValue;

	}

}
