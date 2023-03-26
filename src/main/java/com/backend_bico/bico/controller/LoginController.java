package com.backend_bico.bico.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend_bico.bico.model.usuario.dto.UsuarioByIdDTO;
import com.backend_bico.bico.service.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inicio")
@RequiredArgsConstructor
public class LoginController {

  private final LoginService loginService;

  @PostMapping("/login")
  public ResponseEntity<UsuarioByIdDTO> login(String email, String senha) {
    UsuarioByIdDTO usuarioByIdDTO = loginService.login(email, senha);
    return ResponseEntity.ok(usuarioByIdDTO);
  }

}
