package mx.edu.utez.Proyecto1C.service.usuario;


import jakarta.transaction.Transactional;
import mx.edu.utez.Proyecto1C.controller.usuarios.dto.RequestCrearUsuarioDTO;
import mx.edu.utez.Proyecto1C.exception.customExcepcions.BadRequestException;
import mx.edu.utez.Proyecto1C.model.persona.Persona;
import mx.edu.utez.Proyecto1C.model.usuario.Roles;
import mx.edu.utez.Proyecto1C.model.usuario.Usuario;
import mx.edu.utez.Proyecto1C.repository.persona.PersonaRepository;
import mx.edu.utez.Proyecto1C.repository.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    //inyeccion de dependencias
    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
    }
    @Transactional
    // servicios
    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }


    public Usuario createUser(RequestCrearUsuarioDTO payload){
        //validar si el username ya existe
        if(usuarioRepository.findByUsername(payload.getUsername()).isPresent()){
            throw new BadRequestException("ya hay un registro con ese usuario");
        }
        //registrar persona
        Persona newPersona = new Persona();
        newPersona.setNombres(payload.getNombres());
        newPersona.setPrimerApellido(payload.getPrimerApellido());
        newPersona.setSegundoApellido(payload.getSegundoApellido());
        newPersona.setFechaNacimiento(payload.getFechaNacimiento());
        newPersona.setCorreo(payload.getCorreo());
        newPersona.setCurp(payload.getCurp());

        //creando un registro de persona y obteniendo sus nuevos datos
        newPersona = personaRepository.save(newPersona);

        //crear una instancia de usuario y llenarla en base a la info de playload
        Usuario newUser = new Usuario();
        newUser.setUsername(payload.getUsername());
        newUser.setPassword(payload.getPassword());
        newUser.setDescripcion(payload.getDescripcion());
        newUser.setEnable(true);
        newUser.setRol(
                Roles.valueOf(payload.getRol())
        );

        //relacionar la persona registrada con este nuevo usuario
        newUser.setPersona(newPersona);

        return usuarioRepository.save(newUser);
    }
}
