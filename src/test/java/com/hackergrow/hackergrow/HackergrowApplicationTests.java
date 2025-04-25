package com.hackergrow.hackergrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HackergrowApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testUsuarioIdAvatar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Test User");
        usuario.setCorreo("test@example.com");
        usuario.setContrasena("password");
        usuario.setNombreDeUsuario("testuser");
        usuario.setIdAvatar(2L);

        assertEquals(2L, usuario.getIdAvatar());
    }
}
