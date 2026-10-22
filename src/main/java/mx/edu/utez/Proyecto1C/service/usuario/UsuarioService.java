package mx.edu.utez.Proyecto1C.service.usuario;

import jakarta.transaction.Transactional;
import mx.edu.utez.Proyecto1C.controller.usuarios.dto.ActualiUsuarioDTO;
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
    // Inyección de dependencias
    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
    }

    @Transactional
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Usuario createUser(RequestCrearUsuarioDTO payload) {
        // Validar si el username ya existe
        if (usuarioRepository.findByUsername(payload.getUsername()).isPresent()) {
            throw new BadRequestException("ya hay un registro con este usuario");
        }

        // Registrar persona
        Persona newPersona = new Persona();
        newPersona.setNombres(payload.getNombres());
        newPersona.setPrimerApellido(payload.getPrimerApellido());
        newPersona.setSegundoApellido(payload.getSegundoApellido());
        newPersona.setFechaNacimiento(payload.getFechaNacimiento());
        newPersona.setCorreo(payload.getCorreo());
        newPersona.setCurp(payload.getCurp());

        newPersona = personaRepository.save(newPersona);

        Usuario newUser = new Usuario();
        newUser.setUsername(payload.getUsername());
        newUser.setPassword(payload.getPassword());
        newUser.setDescripcion(payload.getDescripcion());
        newUser.setEnable(true);
        newUser.setRol(
                Roles.valueOf(payload.getRol())
        );


        newUser.setPersona(newPersona);

        return usuarioRepository.save(newUser);
    }


    public Usuario getUserById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Usuario no encontrado con el id: " + id));
    }


    @Transactional
    public Usuario activarUsuario(Long id) {
        Usuario usuario = getUserById(id);
        usuario.setEnable(true);
        return usuarioRepository.save(usuario);
    }


    @Transactional
    public Usuario desactivarUsuario(Long id) {
        Usuario usuario = getUserById(id);
        usuario.setEnable(false);
        return usuarioRepository.save(usuario);
    }


    @Transactional
    public Usuario actualizarUsuario(Long id, ActualiUsuarioDTO payload) {
        Usuario usuario = getUserById(id);

        return usuarioRepository.save(usuario);
    }
}