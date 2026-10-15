package mx.edu.utez.Proyecto1C.controller.usuarios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ActualiUsuarioDTO {
    @NotBlank(message = "el usuario es obligatorio")
    @Size(min=3, max=50, message = "el usuario debe tener entre 3 a 50 caracteres")
    private String descripcion;
    private String username;

    public String getusername() {return username;}
    public void setusername(String username) {this.username = username;}

    public String getdescripcion() {return descripcion;}
    public void setdescripcion(String descripcion) {this.descripcion = descripcion;}
}
