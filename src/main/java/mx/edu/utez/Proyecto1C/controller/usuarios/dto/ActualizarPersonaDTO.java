package mx.edu.utez.Proyecto1C.controller.usuarios.dto;


import jakarta.validation.constraints.NotBlank;

public class ActualizarPersonaDTO {

    @NotBlank(message = "el nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "el apellido es obligatorio")
    private String primerApellido;


    private String segundoApellido;

    @NotBlank(message = "la curp es obligatoria")
    private String curp;

    public String getnombre() {return nombre;}
    public void setnombre(String nombre){this.nombre = nombre;}

    public String getsegundoApellido() {return segundoApellido;}
    public void setsegundoApellido(String segundoApellido) {this.segundoApellido = segundoApellido;}

    public String getprimerApellido() {return primerApellido;}
    public void setprimerApellido(String primerApellido) {this.primerApellido=primerApellido;}

    public String getcurp() {return curp;}
    public void setcurp(String curp) {this.curp = curp;}
}
