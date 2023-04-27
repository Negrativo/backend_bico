package com.backend_bico.bico.service;

import com.backend_bico.bico.model.Coordenadas;
import com.backend_bico.bico.model.cargo.Servico;
import com.backend_bico.bico.model.cargo.ServicoRepository;
import com.backend_bico.bico.model.dtos.SolicitacaoDTO;
import com.backend_bico.bico.model.servico_solicitado.ServicoSolicitado;
import com.backend_bico.bico.model.servico_solicitado.ServicoSolicitadoRepository;
import com.backend_bico.bico.model.usuario.Usuario;
import com.backend_bico.bico.model.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolicitacaoService {

    private static final double RAIO_DA_TERRA = 6371000;

    private final UsuarioRepository usuarioRepository;
    private final ServicoRepository servicoRepository;
    private final ServicoSolicitadoRepository servicoSolicitadoRepository;

    public void solicitar(SolicitacaoDTO solicitacaoDTO) {
        UUID usuarioSolicitanteId = solicitacaoDTO.getUsuarioSolicitante();
        String nomeServico = solicitacaoDTO.getServico();
        String diaSolicitado = solicitacaoDTO.getDiaSelecionado();
        String horarioSolicitado = solicitacaoDTO.getHorarioSolicitado();
        String observacao = solicitacaoDTO.getObservacao();
        String latitude = solicitacaoDTO.getLatitude();
        String longitude = solicitacaoDTO.getLongitude();
        String endereco = solicitacaoDTO.getEndereco();

        Usuario usuarioSolicitante = usuarioRepository.findById(usuarioSolicitanteId);
        Servico servico = servicoRepository.findByNome(nomeServico);
        LocalTime horarioSolicitadoTime = LocalTime.parse(horarioSolicitado);
        LocalDateTime diaSolicitadoTime = LocalDateTime.parse(diaSolicitado);

        Map<Usuario, Coordenadas> usuariosComCoordenadas = getUsuariosComCordenadasByServico(nomeServico);
        Coordenadas cordenadaRef = new Coordenadas(latitude, longitude);
        Usuario usuarioProximo = getUsuarioMaisProximo(cordenadaRef, usuariosComCoordenadas);

        Coordenadas coordenadasProximo = usuariosComCoordenadas.get(usuarioProximo);
        System.out.printf("O usuário mais próximo é %s, com latitude %f e longitude %f.%n",
                usuarioProximo, coordenadasProximo.getLatitude(), coordenadasProximo.getLongitude());

        // TO DO Ajustar vinda de mes, dia e horas para criar o periodo da solicitação
        ServicoSolicitado servicoSolicitado = new ServicoSolicitado(usuarioSolicitante, usuarioProximo, servico, diaSolicitadoTime, horarioSolicitadoTime, observacao, latitude, longitude, endereco);
        servicoSolicitadoRepository.save(servicoSolicitado);
    }

    private Map<Usuario, Coordenadas> getUsuariosComCordenadasByServico(String servico) {
        List<Usuario> usuariosbyServico = usuarioRepository.findByServico(servico);
        return usuariosbyServico.stream()
                .collect(Collectors.toMap(Function.identity(), Usuario::getCoordenadas));
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
