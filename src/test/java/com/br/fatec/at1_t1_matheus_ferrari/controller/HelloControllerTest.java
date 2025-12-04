package com.br.fatec.at1_t1_matheus_ferrari.controller;

import com.br.fatec.at1_t1_matheus_ferrari.CONTROLLER.HelloController;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class HelloControllerTest {

    private final HelloController controller = new HelloController();

    @Test
    void deveRetornarMensagemHello() {
        // Testamos diretamente o retorno do método `hello()`
        String resultado = controller.hello();
        assertEquals("Matheus Ferrari Abrahão", resultado);
    }

}