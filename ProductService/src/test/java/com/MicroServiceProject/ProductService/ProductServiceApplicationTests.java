package com.MicroServiceProject.ProductService;

import com.MicroServiceProject.ProductService.dto.ProductRequest;
import com.MicroServiceProject.ProductService.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.assertions.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	ProductRepository productRepository;

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.12");

	static {
		mongoDBContainer.start();
	}

	@DynamicPropertySource
	static void setProperty(DynamicPropertyRegistry dynamicPropertyRegistry)
	{
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void createProduct() throws Exception {
		ProductRequest productRequest = getProduct();
		String productRequestString = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestString))
				.andExpect(status().isOk());
		Assertions.assertTrue(productRepository.findAll().size() == 1);

	}

	private ProductRequest getProduct()
	{
		return ProductRequest.builder()
				.name("HeadSet")
				.description("Boat")
				.price(20000)
				.build();
	}

	void getAllProduct()
	{

	}
}
