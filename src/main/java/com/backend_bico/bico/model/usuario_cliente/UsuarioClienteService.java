package com.backend_bico.bico.model.usuario_cliente;

import com.backend_bico.bico.model.usuario_cliente.dto.UsuarioAlterarSenhaDTO;
import com.backend_bico.bico.model.usuario_cliente.dto.UsuarioAtualizarDTO;
import com.backend_bico.bico.model.usuario_cliente.dto.UsuarioByIdDTO;
import com.backend_bico.bico.model.usuario_cliente.dto.UsuarioCriarDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioClienteService {

    public static final String AS_SENHAS_NAO_CONFEREM = "AS SENHAS NÃO CONFEREM.";

    private final UsuarioClienteRepository usuarioClienteRepository;

    @Transactional
    public UsuarioCliente save(UsuarioCriarDTO usuarioDTO) {
        UsuarioCliente usuario = new UsuarioCliente(usuarioDTO);
        return usuarioClienteRepository.save(usuario);
    }

    public List<UsuarioCliente> getAll() {
        return usuarioClienteRepository.findAll();
    }

    public UsuarioByIdDTO findById(UUID usuarioId) {
        UsuarioCliente usuarioCliente = usuarioClienteRepository.findById(usuarioId);
        return new UsuarioByIdDTO(usuarioCliente);
    }

    @Transactional
    public UsuarioCliente updateById(UUID usuarioId, UsuarioAtualizarDTO usuarioDTO) {
        UsuarioCliente usuarioCliente = usuarioClienteRepository.findById(usuarioId);
        usuarioCliente.update(usuarioDTO);
        return usuarioClienteRepository.save(usuarioCliente);
    }

    @Transactional
    public void updateSenha(UUID usuarioId, UsuarioAlterarSenhaDTO usuarioAlterarSenhaDTO) {
        UsuarioCliente usuarioCliente = usuarioClienteRepository.findById(usuarioId);
        usuarioCliente.validarSenhas(usuarioAlterarSenhaDTO);
        usuarioCliente.updateSenha(usuarioAlterarSenhaDTO.getNovaSenha());
        usuarioClienteRepository.save(usuarioCliente);
    }

    @Transactional
    public void deleteById(UUID usuarioId) {
        usuarioClienteRepository.deleteById(usuarioId);
    }

}
