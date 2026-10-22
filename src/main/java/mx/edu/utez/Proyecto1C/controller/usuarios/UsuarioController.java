package mx.edu.utez.Proyecto1C.controller.usuarios;


import jakarta.validation.Valid;
import mx.edu.utez.Proyecto1C.controller.usuarios.dto.ActualiUsuarioDTO;
import mx.edu.utez.Proyecto1C.controller.usuarios.dto.RequestCrearUsuarioDTO;
import mx.edu.utez.Proyecto1C.model.usuario.Usuario;
import mx.edu.utez.Proyecto1C.service.usuario.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin({"*"})
public class UsuarioController {
    //inyecccion de dependencia
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //exposicion de servicios
    @GetMapping
    public ResponseEntity<List<Usuario>>  getAllUsers(){
        return ResponseEntity
                .status(200)
                .body(this.usuarioService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<Usuario> createUser
            (@RequestBody @Valid RequestCrearUsuarioDTO payload){
        return ResponseEntity
                .status(201)
                .body(
                        this.usuarioService.createUser(payload)
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        return ResponseEntity
                .status(200)
                .body(this.usuarioService.getUserById(id));
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Usuario> activarUsuario(@PathVariable Long id) {
        return ResponseEntity
                .status(200)
                .body(this.usuarioService.activarUsuario(id));
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Usuario> desactivarUsuario(@PathVariable Long id) {
        return ResponseEntity
                .status(200)
                .body(this.usuarioService.desactivarUsuario(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @PathVariable Long id,
            @RequestBody @Valid ActualiUsuarioDTO payload) {
        return ResponseEntity
                .status(200)
          .body(this.usuarioService.actualizarUsuario(id, payload));
    }
}
