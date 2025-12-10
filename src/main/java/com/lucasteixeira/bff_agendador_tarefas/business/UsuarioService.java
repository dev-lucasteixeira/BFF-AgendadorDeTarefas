package com.lucasteixeira.bff_agendador_tarefas.business;


import com.lucasteixeira.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.out.ViaCepDTOResponse;
import com.lucasteixeira.bff_agendador_tarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;


    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){

        return usuarioClient.salvaUsuario(usuarioDTO);
    }


    public String login(LoginRequestDTO loginRequestDTO){
        return usuarioClient.login(loginRequestDTO);
    }


    public UsuarioDTOResponse buscUsuarioPorEmail(String email, String token){
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        usuarioClient.deletaUsuarioPorEmail(email,token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto){
        return usuarioClient.atualizaDadosUsuario(dto, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token){

        return usuarioClient.atualizaTelefone(dto, idTelefone, token
        );
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest dto, String token){

        return usuarioClient.atualizaEndereco(dto, idEndereco, token
        );
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto){
        return usuarioClient.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto){
        return usuarioClient.cadastraTelefone(dto, token);
    }

    public ViaCepDTOResponse buscarEnderecoPorCep(String cep){
        return usuarioClient.buscarDadosCep(cep);
    }
}
