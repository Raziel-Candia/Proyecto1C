package mx.edu.utez.Proyecto1C.controller.usuarios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActualiUsuarioDTO {

    @NotBlank(message = "el username es obligatorio")
    @Size(min = 4, max = 20, message = "el username debe ser entre 4 y 20 caracteres")
    private String username;

    private String descripcion;
}


