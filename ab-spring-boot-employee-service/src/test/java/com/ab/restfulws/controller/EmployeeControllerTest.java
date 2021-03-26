package com.ab.restfulws.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ab.restfulws.model.Employee;
import com.ab.restfulws.repository.EmployeeContactRepository;
import com.ab.restfulws.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
	@MockBean
	private EmployeeService employeeService;

	@MockBean
	private EmployeeContactRepository employeeContactRepository;

	@Autowired
	private MockMvc mockMvc;

	@WithMockUser(username = "user1", password = "user1")
	@Test
	void testFindEmployeeByName() throws Exception {
		Employee employee = getEmployeeMockData();
		Mockito.when(employeeService.findEmployeeByName(Mockito.anyString())).thenReturn(employee);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/name/employee1")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		String actual = mvcResult.getResponse().getContentAsString();
		String expected = "{\"employeeID\":1,\"employeeName\":\"employee1\",\"employeeContacts\":null,\"environmentInfo\":null}";
		JSONAssert.assertEquals(expected, actual, true);

	}
	@WithMockUser(username = "user1", password = "user1")
	@Test
	public void testSaveEmployee() throws Exception {
		Employee employee = getEmployeeMockData();
		String employeeJson = "{\"employeeID\":1,\"employeeName\":\"employee1\",\"employeeContacts\":null,\"environmentInfo\":null}";
		Mockito.when(employeeService.saveEmployee(Mockito.any(Employee.class))).thenReturn(employee);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee").accept(MediaType.APPLICATION_JSON)
				.content(employeeJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		int actual = mvcResult.getResponse().getStatus();
		int expected = 201;
		assertEquals(expected, actual);
	}

	private Employee getEmployeeMockData() {
		Employee employee = new Employee(1, "employee1");
		return employee;

	}

}
