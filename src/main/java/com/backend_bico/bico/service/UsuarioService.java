package com.backend_bico.bico.service;

import com.backend_bico.bico.model.cargo.Servico;
import com.backend_bico.bico.model.cargo.ServicoRepository;
import com.backend_bico.bico.model.usuario.Usuario;
import com.backend_bico.bico.model.usuario.UsuarioRepository;
import com.backend_bico.bico.model.usuario.dto.UsuarioAlterarSenhaDTO;
import com.backend_bico.bico.model.usuario.dto.UsuarioAtualizarDTO;
import com.backend_bico.bico.model.usuario.dto.UsuarioByIdDTO;
import com.backend_bico.bico.model.usuario.dto.UsuarioCriarDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioService {

    public static final String AS_SENHAS_NAO_CONFEREM = "AS SENHAS NÃO CONFEREM.";

    private final UsuarioRepository usuarioRepository;
    private final ServicoRepository servicoRepository;

    @Transactional
    public Usuario save(UsuarioCriarDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public UsuarioByIdDTO findById(UUID usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId);
        return new UsuarioByIdDTO(usuario);
    }

    @Transactional
    public Usuario updateById(UUID usuarioId, UsuarioAtualizarDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(usuarioId);

        List<Servico> servicos = servicoRepository.findAll();
        List<Servico> servicosSelecionado = servicos.stream()
                .filter(servico -> usuarioDTO.getProfissoes().contains(servico.getNome()))
                .toList();

        usuario.update(usuarioDTO, servicosSelecionado);
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void updateSenha(UUID usuarioId, UsuarioAlterarSenhaDTO usuarioAlterarSenhaDTO) {
        Usuario usuario = usuarioRepository.findById(usuarioId);
        usuario.validarSenhas(usuarioAlterarSenhaDTO);
        usuario.updateSenha(usuarioAlterarSenhaDTO.getNovaSenha());
        usuarioRepository.save(usuario);
    }

    @Transactional
    public void deleteById(UUID usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

}
