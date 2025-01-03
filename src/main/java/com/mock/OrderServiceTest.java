package com.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class OrderServiceTest {

    @Test
    public void testPlaceOrderSuccess() {
        // Criar um Mock para PaymentService
        PaymentService paymentServiceMock = mock(PaymentService.class);

        // Configurar o Mock para simular comportamento
        when(paymentServiceMock.processPayment(100.0)).thenReturn(true);

        // Criar a classe de teste com o Mock
        OrderService orderService = new OrderService(paymentServiceMock);

        // Executar o método e verificar o resultado
        String result = orderService.placeOrder(100.0);
        assertEquals("Order placed successfully!", result);

        // Verificar se o método foi chamado com o parâmetro correto
        verify(paymentServiceMock).processPayment(100.0);
    }

    @Test
    public void testPlaceOrderFailure() {
        // Criar um Mock para PaymentService
        PaymentService paymentServiceMock = mock(PaymentService.class);

        // Configurar o Mock para simular falha
        when(paymentServiceMock.processPayment(200.0)).thenReturn(false);

        // Criar a classe de teste com o Mock
        OrderService orderService = new OrderService(paymentServiceMock);

        // Executar o método e verificar o resultado
        String result = orderService.placeOrder(200.0);
        assertEquals("Payment failed!", result);

        // Verificar se o método foi chamado com o parâmetro correto
        verify(paymentServiceMock).processPayment(200.0);
    }
}

