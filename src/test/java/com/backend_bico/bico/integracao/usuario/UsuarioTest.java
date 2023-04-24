package com.backend_bico.bico.integracao.usuario;

import com.backend_bico.bico.BicoApplicationTests;
import com.backend_bico.bico.model.cargo.Servico;
import com.backend_bico.bico.model.cargo.ServicoRepository;
import com.backend_bico.bico.model.usuario.Usuario;
import com.backend_bico.bico.model.usuario.UsuarioRepository;
import com.backend_bico.bico.model.usuario.dto.UsuarioCriarDTO;
import com.backend_bico.bico.model.usuario_servico.UsuarioServico;
import com.backend_bico.bico.model.usuario_servico.UsuarioServicoRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;

import java.util.List;

@TestComponent
public class UsuarioTest extends BicoApplicationTests {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private UsuarioServicoRepository usuarioServicoRepository;

    private List<Servico> servicos;
    private Servico computacaoServ, programadorWeb, programadorJava;

    public UsuarioTest() {
        super();
    }

    @Before
    public void prepararDados() {

    }

    @Test
    void criarUsuario_OK() {
        computacaoServ = new Servico("computacao", "tecnologia");
        programadorWeb = new Servico("programador Web", "tecnologia");
        programadorJava = new Servico("programador Java", "tecnologia");
        this.servicos = servicoRepository.saveAll(List.of(computacaoServ, programadorJava, programadorWeb));

        UsuarioCriarDTO usuarioCriarDTO = new UsuarioCriarDTO("lucas", "teste", "teste", "123");
        Usuario usuario = new Usuario(usuarioCriarDTO);
        usuarioRepository.save(usuario);
        UsuarioServico usuarioServico = new UsuarioServico(usuario, computacaoServ);
        usuario.setUsuarioServico(usuarioServico);
        computacaoServ.setUsuarioServico(usuarioServico);
        usuarioServicoRepository.save(usuarioServico);
        usuarioRepository.save(usuario);
        Usuario usuarioSalvo = usuarioRepository.findById(usuario.getId());
        Assertions.assertEquals(usuario.getNome(), usuarioSalvo.getNome());
    }

    @Test
    void buscarUsuario_porServico() {
        computacaoServ = new Servico("computacao", "tecnologia");
        programadorWeb = new Servico("programador Web", "tecnologia");
        programadorJava = new Servico("programador Java", "tecnologia");
        this.servicos = servicoRepository.saveAll(List.of(computacaoServ, programadorJava, programadorWeb));

        UsuarioCriarDTO usuarioLucasCriarDTO = new UsuarioCriarDTO("Lucas", "teste", "teste", "123");
        UsuarioCriarDTO usuarioJonasCriarDTO = new UsuarioCriarDTO("Jonas", "teste", "teste", "123");
        UsuarioCriarDTO usuarioGabrielCriarDTO = new UsuarioCriarDTO("Gabriel", "teste", "teste", "123");

        Usuario usuarioLucas = new Usuario(usuarioLucasCriarDTO);
        Usuario usuarioJonas = new Usuario(usuarioJonasCriarDTO);
        Usuario usuarioGabriel = new Usuario(usuarioGabrielCriarDTO);

        usuarioRepository.saveAll(List.of(usuarioLucas, usuarioJonas, usuarioGabriel));

        UsuarioServico usuarioServicoLucas = new UsuarioServico(usuarioLucas, computacaoServ);
        UsuarioServico usuarioServicoJonas = new UsuarioServico(usuarioJonas, programadorWeb);
        UsuarioServico usuarioServicoGabriel = new UsuarioServico(usuarioGabriel, programadorJava);

        usuarioLucas.setUsuarioServico(usuarioServicoLucas);
        usuarioJonas.setUsuarioServico(usuarioServicoJonas);
        usuarioGabriel.setUsuarioServico(usuarioServicoGabriel);
        computacaoServ.setUsuarioServico(usuarioServicoLucas);
        programadorWeb.setUsuarioServico(usuarioServicoJonas);
        programadorJava.setUsuarioServico(usuarioServicoGabriel);

        usuarioServicoRepository.saveAll(List.of(usuarioServicoLucas, usuarioServicoJonas, usuarioServicoGabriel));
        usuarioRepository.saveAll(List.of(usuarioLucas, usuarioJonas, usuarioGabriel));

        List<Usuario> usuariosByJava = usuarioRepository.findByServico(programadorJava.getNome());

        Assertions.assertEquals(usuariosByJava.get(0).getNome(), "Gabriel");
    }

    @Test
    void verificarServivosUsuario() {
        computacaoServ = new Servico("computacao", "tecnologia");
        programadorWeb = new Servico("programador Web", "tecnologia");
        programadorJava = new Servico("programador Java", "tecnologia");
        this.servicos = servicoRepository.saveAll(List.of(computacaoServ, programadorJava, programadorWeb));

        UsuarioCriarDTO usuarioLucasCriarDTO = new UsuarioCriarDTO("Lucas", "teste", "teste", "123");

        Usuario usuarioLucas = new Usuario(usuarioLucasCriarDTO);

        usuarioRepository.save(usuarioLucas);

        UsuarioServico usuarioServicoComp = new UsuarioServico(usuarioLucas, computacaoServ);
        UsuarioServico usuarioServicoWeb = new UsuarioServico(usuarioLucas, programadorWeb);
        UsuarioServico usuarioServicoJava = new UsuarioServico(usuarioLucas, programadorJava);

        usuarioLucas.setUsuarioServico(usuarioServicoComp);
        usuarioLucas.setUsuarioServico(usuarioServicoWeb);
        usuarioLucas.setUsuarioServico(usuarioServicoJava);
        computacaoServ.setUsuarioServico(usuarioServicoComp);
        programadorWeb.setUsuarioServico(usuarioServicoWeb);
        programadorJava.setUsuarioServico(usuarioServicoJava);

        usuarioServicoRepository.saveAll(List.of(usuarioServicoComp, usuarioServicoWeb, usuarioServicoJava));
        usuarioRepository.save(usuarioLucas);

        List<String> nomeProfissoesUsuario = usuarioRepository.nomeServicosByUsuarioId(usuarioLucas.getId());

        Assertions.assertAll(
                () -> Assertions.assertEquals(nomeProfissoesUsuario.get(0), "computacao"),
                () -> Assertions.assertEquals(nomeProfissoesUsuario.get(1), "programador Java"),
                () -> Assertions.assertEquals(nomeProfissoesUsuario.get(2), "programador Web")
        );
    }
}
