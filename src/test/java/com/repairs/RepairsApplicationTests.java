package com.repairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.repairs.model.CustomerModel;
import com.repairs.service.ValidateService;

@SpringBootTest
class RepairsApplicationTests {
	
	ValidateService service = new ValidateService();
	CustomerModel custModel;
	
	@Test
	void validateServiceTest1() {
		CustomerModel custModel = new CustomerModel("Tamil","Chennai","9874563210","Male");
		String output = service.inputCheck(custModel);
		assertEquals("1", output);
		
	}

	@Test
	void validateServiceTest2() {
		CustomerModel custModel = new CustomerModel("Tamil","Chennai","9874563210","notselected");
		String output = service.inputCheck(custModel);
		assertEquals("5", output);
		
	}

	@Test
	void validateServiceTest3() {
		CustomerModel custModel = new CustomerModel("Tamil","Chennai","9874563210","female");
		String output = service.inputCheck(custModel);
		assertEquals("1", output);
		
	}

	@Test
	void validateServiceTest4() {
		CustomerModel custModel = new CustomerModel("","Chennai","9874563210","female");
		String output = service.inputCheck(custModel);
		assertEquals("4", output);
		
	}

	@Test
	void validateServiceTest5() {
		CustomerModel custModel = new CustomerModel("Abc","Chennai","5874563210","female");
		String output = service.inputCheck(custModel);
		assertEquals("3", output);
		
	}
	@Test
	void validateServiceTest6() {
		CustomerModel custModel = new CustomerModel("Abc","","7874563210","female");
		String output = service.inputCheck(custModel);
		assertEquals("2", output);
		
	}

}
