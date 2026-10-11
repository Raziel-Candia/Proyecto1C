package mx.edu.utez.Proyecto1C.service.usuario;


import mx.edu.utez.Proyecto1C.model.usuario.Usuario;
import mx.edu.utez.Proyecto1C.repository.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    //inyeccion de dependencias
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    // servicios
    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }
}
