package com.lucasteixeira.bff_agendador_tarefas.business.dto.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTORequest {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "Por favor, insira um e-mail válido")
    @NotBlank(message = "O e-mail é obrigatório")
    private String email;

    @NotBlank(message = "O senha é obrigatório")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;

    private List<EnderecoDTORequest> endereco;
    private List<TelefoneDTORequest> telefone;
}
