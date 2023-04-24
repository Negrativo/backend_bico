package com.backend_bico.bico.service;

import com.backend_bico.bico.model.dtos.UsuarioEmailSenhaDTO;
import com.backend_bico.bico.model.usuario.Usuario;
import com.backend_bico.bico.model.usuario.UsuarioRepository;
import com.backend_bico.bico.model.usuario.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDTO login(UsuarioEmailSenhaDTO loginDTO) {
        return usuarioRepository.findByEmailAndSenha(loginDTO.getEmail(), loginDTO.getSenha());
    }

    public Boolean verificarUsuarioExistente(String email) {
        Optional<Usuario> existente = usuarioRepository.verificarUsuarioExistente(email);
        return existente.isPresent();
    }

}
