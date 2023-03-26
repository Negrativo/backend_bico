package com.backend_bico.bico.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend_bico.bico.model.usuario.UsuarioRepository;
import com.backend_bico.bico.model.usuario.dto.UsuarioByIdDTO;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {

  private final UsuarioRepository usuarioRepository;

  public UsuarioByIdDTO login(String email, String senha) {
    return usuarioRepository.findByEmailAndSenha(email, senha);
  }

}
