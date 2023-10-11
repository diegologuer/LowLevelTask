package com.Task.LowLevelTask;
import com.Task.LowLevelTask.controller.ProductController;
import com.Task.LowLevelTask.model.Product;
import com.Task.LowLevelTask.repository.ProductRepository;
import com.Task.LowLevelTask.service.ProductService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;




@SpringBootTest
@AutoConfigureMockMvc
public class LowLevelApplicationTests {
    
    @Autowired
    private MockMvc mockMvc;
  
    
    /*@Test
    public void testCreateProduct() throws Exception {
        // You can use MockMvc to simulate HTTP requests
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/products")
                .content("{\"name\":\"TestProduct\",\"description\":\"Test Description\",\"price\":10.0,\"quantity\":5}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }*/
    
    @Test
    public void testGetProductById() throws Exception {
        // Assuming you have a test product in your database
        Long productId = 1L;
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/products/" + productId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void testGetAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/products"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void testUpdateProduct() throws Exception {
        // Assuming you have a test product in your database
        Long productId = 1L;
        mockMvc.perform(MockMvcRequestBuilders
                .put("/api/products/" + productId)
                .content("{\"name\":\"UpdatedProduct\",\"description\":\"Updated Description\",\"price\":15.0,\"quantity\":10}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    /*@Test
    public void testDeleteProduct() throws Exception {
        // Assuming you have a test product in your database
        Long productId = 1L;
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/products/" + productId))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }*/
    
    @Test
    public void testProductConstructor() {
        Product product = new Product(1L, "TestProduct", "Test Description", 10.0, 5);
        assertNotNull(product);
        assertEquals("TestProduct", product.getName());
        assertEquals("Test Description", product.getDescription());
        assertEquals(10.0, product.getPrice(), 0.001); // 0.001 es una tolerancia para comparar números de punto flotante
        assertEquals(5, product.getQuantity());
    }
    
    @Test
    public void testIdGetterAndSetter() {
        Product product = new Product();
        product.setId(1L);
        assertEquals(1L, product.getId().longValue());
    }

    @Test
    public void testNameGetterAndSetter() {
        Product product = new Product();
        product.setName("TestProduct");
        assertEquals("TestProduct", product.getName());
    }

    @Test
    public void testDescriptionGetterAndSetter() {
        Product product = new Product();
        product.setDescription("Test Description");
        assertEquals("Test Description", product.getDescription());
    }

    @Test
    public void testPriceGetterAndSetter() {
        Product product = new Product();
        product.setPrice(10.0);
        assertEquals(10.0, product.getPrice(), 0.001); // Tolerancia para números de punto flotante
    }

    @Test
    public void testQuantityGetterAndSetter() {
        Product product = new Product();
        product.setQuantity(5);
        assertEquals(5, product.getQuantity());
    }
    
    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(productRepository);
    }

    @Test
    public void testCreateProduct() {
        Product newProduct = new Product(1L, "TestProduct", "Test Description", 10.0, 5);

        Mockito.when(productRepository.save(newProduct)).thenReturn(newProduct);

        Product createdProduct = productService.createProduct(newProduct);

        assertNotNull(createdProduct);
        assertEquals(newProduct, createdProduct);
    }

    @Test
    public void testGetProductById2() {
        Long productId = 1L;
        Product product = new Product(productId, "TestProduct", "Test Description", 10.0, 5);

        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Optional<Product> retrievedProduct = productService.getProductById(productId);

        assertTrue(retrievedProduct.isPresent());
        assertEquals(product, retrievedProduct.get());
    }

    @Test
    public void testGetAllProducts2() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "Product1", "Description1", 10.0, 5));
        productList.add(new Product(2L, "Product2", "Description2", 20.0, 3));

        Mockito.when(productRepository.findAll()).thenReturn(productList);

        List<Product> retrievedProducts = productService.getAllProducts();

        assertEquals(2, retrievedProducts.size());
        assertEquals(productList, retrievedProducts);
    }

    @Test
    public void testUpdateProduct2() {
        Long productId = 1L;
        Product updatedProduct = new Product(productId, "UpdatedProduct", "Updated Description", 15.0, 8);

        Mockito.when(productRepository.existsById(productId)).thenReturn(true);
        Mockito.when(productRepository.save(updatedProduct)).thenReturn(updatedProduct);

        Product result = productService.updateProduct(productId, updatedProduct);

        assertNotNull(result);
        assertEquals(updatedProduct, result);
    }

   
    
    

}
