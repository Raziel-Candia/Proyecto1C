package mx.edu.utez.Proyecto1C.controller.usuarios.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCrearUsuarioDTO {

    @NotBlank(message = "el username es obligatorio")
    @Size(min = 4, max = 20, message = "el username debe ser entre 4 y 20 caracteres")
    private String username;

    @NotBlank(message = "la contraseña es obligatoria")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d).{8,}$",
            message = "La contraseña debe tener al menos 8 caracteres, una mayúscula y un número"
    )
    private String password;

    @NotBlank(message = "el rol es obligatorio")
    @Pattern(
            regexp = "^(ADMIN|GESTOR|ESTUDIANTE)$",
            message = "El rol debe ser ADMIN, GESTOR o ESTUDIANTE"
    )
    private String rol;

    private String descripcion;

    //datos de la persona

    @NotBlank(message = "el nombre es obli8gatorio")
    private String nombres;

    @NotBlank(message = "es obligatorio el segundo apellido")
    private String primerApellido;

    private String segundoApellido;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @NotBlank(message = "es obligatorio el correo")
    @Email(message = "el correo es invalido")
    private String correo;

    @NotBlank(message = "la curp es obligatoria")
    private String curp;
}
