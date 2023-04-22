package com.backend_bico.bico.integracao.usuario;

import com.backend_bico.bico.BicoApplicationTests;
import com.backend_bico.bico.model.usuario.Usuario;
import com.backend_bico.bico.model.usuario.UsuarioRepository;
import com.backend_bico.bico.model.usuario.dto.UsuarioCriarDTO;
import com.backend_bico.bico.model.usuario_servico.UsuarioServico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@TestComponent
public class UsuarioTest extends BicoApplicationTests {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioTest() {
        super();
    }

    @Test
    void criarUsuario_OK() {
        List<UsuarioServico> usuarioServicos = new ArrayList<>();
        UsuarioCriarDTO usuarioCriarDTO = new UsuarioCriarDTO("lucas", "teste", "teste", "123", "123", "teste", "123", usuarioServicos);
        Usuario usuario = new Usuario(usuarioCriarDTO);
        usuarioRepository.save(usuario);
        Usuario usuarioSalvo = usuarioRepository.findById(usuario.getId());
        Assertions.assertEquals(usuario.getNome(), usuarioSalvo.getNome());
    }
}
