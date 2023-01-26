package com.repairs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.repairs.controller.RepairsController;

@WebMvcTest(RepairsController.class)
public class ControllerTest {

	@Test
	void deleteTest() throws Exception {
		MockMvcRequestBuilders.get("/delete").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
	}

}