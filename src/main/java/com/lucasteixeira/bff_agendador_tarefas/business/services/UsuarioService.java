package com.lucasteixeira.bff_agendador_tarefas.business.services;


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
        return usuarioClient.buscaUsuarioPorEmail(email);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        usuarioClient.deletaUsuarioPorEmail(email);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto){
        return usuarioClient.atualizaDadosUsuario(dto);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token){

        return usuarioClient.atualizaTelefone(dto, idTelefone);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest dto, String token){

        return usuarioClient.atualizaEndereco(dto, idEndereco);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto){
        return usuarioClient.cadastraEndereco(dto);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto){
        return usuarioClient.cadastraTelefone(dto);
    }

    public ViaCepDTOResponse buscarEnderecoPorCep(String cep){
        return usuarioClient.buscarDadosCep(cep);
    }
}
