package mx.edu.utez.Proyecto1C.controller.usuarios.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarPersonaDTO {

    @NotBlank(message = "el nombre es obligatorio")
    private String nombres;

    @NotBlank(message = "el primer apellido es obligatorio")
    private String primerApellido;

    private String segundoApellido;

    @Past(message = "la fecha de nacimiento debe ser una fecha pasada")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @NotBlank(message = "el correo es obligatorio")
    @Email(message = "el correo es invalido")
    private String correo;

    @NotBlank(message = "la curp es obligatoria")
    @Pattern(
            regexp = "^[A-Z]{4}\\d{6}[HMX][A-Z]{2}[B-DF-HJ-NP-TV-Z]{3}[A-Z0-9]\\d$",
            message = "la curp no tiene un formato valido (18 caracteres en mayusculas)"
    )
    private String curp;
}
