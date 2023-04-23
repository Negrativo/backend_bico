package com.backend_bico.bico.service;

import com.backend_bico.bico.model.Coordenadas;
import com.backend_bico.bico.model.dtos.SolicitacaoDTO;
import com.backend_bico.bico.model.usuario.Usuario;
import com.backend_bico.bico.model.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolicitacaoService {

    private static final double RAIO_DA_TERRA = 6371000;

    private final UsuarioRepository usuarioRepository;

    public void solicitar(SolicitacaoDTO solicitacaoDTO) {
        String servico = solicitacaoDTO.getServico();
        String diaSolicitado = solicitacaoDTO.getDiaSolicitado();
        String horarioSolicitado = solicitacaoDTO.getHorarioSolicitado();
        String observacao = solicitacaoDTO.getObservacao();
        String latitude = solicitacaoDTO.getLatitude();
        String longitude = solicitacaoDTO.getLongitude();
        String endereco = solicitacaoDTO.getEndereco();

        // TO DO - Mapear usuarios por cordenadas
        List<Usuario> usuariosbyServico = usuarioRepository.findByServico(servico);

        Map<Usuario, Coordenadas> usuariosComCoordenadas = usuariosbyServico.stream()
                .collect(Collectors.toMap(Function.identity(), Usuario::getCoordenadas));

        Coordenadas cordenadaRef = new Coordenadas(latitude, longitude);
        Usuario usuarioProximo = getUsuarioMaisProximo(cordenadaRef, usuariosComCoordenadas);

        Coordenadas coordenadasProximo = usuariosComCoordenadas.get(usuarioProximo);
        System.out.printf("O usuário mais próximo é %s, com latitude %f e longitude %f.%n",
                usuarioProximo, coordenadasProximo.getLatitude(), coordenadasProximo.getLongitude());

    }

    private Usuario getUsuarioMaisProximo(Coordenadas cordenadaRef, Map<Usuario, Coordenadas> usuarios) {
        Usuario usuarioProximo = null;
        double distanciaMinima = Double.MAX_VALUE;
        for (Map.Entry<Usuario, Coordenadas> entry : usuarios.entrySet()) {
            Usuario usuario = entry.getKey();
            Coordenadas coordenadas = entry.getValue();
            double distancia = distancia(cordenadaRef, coordenadas);
            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                usuarioProximo = usuario;
            }
        }
        return usuarioProximo;
    }

    private static double distancia(Coordenadas c1, Coordenadas c2) {
        double lat1 = Math.toRadians(c1.getLatitude());
        double lon1 = Math.toRadians(c1.getLongitude());
        double lat2 = Math.toRadians(c2.getLatitude());
        double lon2 = Math.toRadians(c2.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = RAIO_DA_TERRA * c;

        return d;
    }

}
