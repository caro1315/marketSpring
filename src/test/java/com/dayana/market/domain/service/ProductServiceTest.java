package com.dayana.market.domain.service;

import com.dayana.market.domain.Product;
import com.dayana.market.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void getAllVariosTest(){
        // Assets
        List<Product> products = Arrays.asList(new Product(),new Product());

        // Act
        when(productRepository.getAll()).thenReturn(products);

        List<Product> resultado = productService.getAll();

        // Assert
        assertEquals(2, resultado.size());
        verify(productRepository, times(1)).getAll();
    }

    @Test
    public void getProductExisteTest(){
        //Assets
        int productId = 1;
        Product product = new Product();
        product.setName("Pera");
        Optional<Product> optionalProduct = Optional.of(product);

        //Act
        when(productRepository.getProduct(productId)).thenReturn(optionalProduct);

        Optional<Product> resultado = productService.getProduct(productId);

        //Assert
        assertEquals("Pera",resultado.get().getName());
        assertTrue(resultado.isPresent());
        verify(productRepository, times(1)).getProduct(productId);
    }

    @Test
    public void getProductNoExisteTest(){
        //Assets
        int productId = 7894;
        Product product = null;

        Optional<Product> optionalProduct = Optional.ofNullable(product);

        //Act
        when(productRepository.getProduct(productId)).thenReturn(optionalProduct);

        Optional<Product> resultado = productService.getProduct(productId);

        //Assert
        assertFalse(resultado.isPresent());
        verify(productRepository, times(1)).getProduct(productId);
    }

}
