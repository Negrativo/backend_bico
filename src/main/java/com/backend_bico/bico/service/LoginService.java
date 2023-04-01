package com.backend_bico.bico.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend_bico.bico.model.dtos.UsuarioEmailSenhaDTO;
import com.backend_bico.bico.model.usuario.Usuario;
import com.backend_bico.bico.model.usuario.UsuarioRepository;
import com.backend_bico.bico.model.usuario.dto.UsuarioByIdDTO;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {

  private final UsuarioRepository usuarioRepository;

  public UsuarioByIdDTO login(UsuarioEmailSenhaDTO loginDTO) {
    return usuarioRepository.findByEmailAndSenha(loginDTO.getEmail(), loginDTO.getSenha());
  }

  public Boolean verificarUsuarioExistente(String email) {
    Optional<Usuario> existente = usuarioRepository.verificarUsuarioExistente(email);
    return existente.isPresent();
  }

}
