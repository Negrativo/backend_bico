package com.backend_bico.bico.controller;

import com.backend_bico.bico.model.dtos.UsuarioEmailDTO;
import com.backend_bico.bico.model.dtos.UsuarioEmailSenhaDTO;
import com.backend_bico.bico.model.usuario.dto.UsuarioDTO;
import com.backend_bico.bico.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicio")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioEmailSenhaDTO loginDTO) {
        UsuarioDTO usuarioByIdDTO = loginService.login(loginDTO);
        return ResponseEntity.ok(usuarioByIdDTO);
    }

    @PostMapping("/cadastro/usuario-existente")
    public ResponseEntity<Boolean> verificarUsuarioExistente(@RequestBody UsuarioEmailDTO usuarioEmailDTO) {
        Boolean existente = loginService.verificarUsuarioExistente(usuarioEmailDTO.getEmail());
        return ResponseEntity.ok(existente);
    }

}
