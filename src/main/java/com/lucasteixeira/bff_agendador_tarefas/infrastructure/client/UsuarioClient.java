package com.lucasteixeira.bff_agendador_tarefas.infrastructure.client;


import com.lucasteixeira.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import com.lucasteixeira.bff_agendador_tarefas.business.dto.out.ViaCepDTOResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    @CircuitBreaker(name = "ms-usuario", fallbackMethod = "fallbackBuscaUsuario")
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email);


    @PostMapping("/usuario")
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    //Ele faz o login, verifica e gera um token
    @PostMapping("/login")
     String login(@RequestBody LoginRequestDTO loginRequestDTO);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email);

    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto);

    @GetMapping("/endereco/{cep}")
    ViaCepDTOResponse buscarDadosCep(@PathVariable("cep") String cep);

    default UsuarioDTOResponse fallbackBuscaUsuario(String email, Throwable t) {
        return UsuarioDTOResponse.builder()
                .nome("Usuário Temporariamente Indisponível")
                .email(email)
                .build();
    }
}
