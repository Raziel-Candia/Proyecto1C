package mx.edu.utez.Proyecto1C.controller.persona;

import jakarta.validation.Valid;
import mx.edu.utez.Proyecto1C.controller.usuarios.dto.ActualizarPersonaDTO;
import mx.edu.utez.Proyecto1C.model.persona.Persona;
import mx.edu.utez.Proyecto1C.service.persona.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@CrossOrigin({"*"})
public class PersonaController {
    //inyeccion de dependencia
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    //exposicion de servicios
    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(
            @PathVariable Long id,
            @RequestBody @Valid ActualizarPersonaDTO payload) {
        return ResponseEntity
                .status(200)
                .body(this.personaService.actualizarPersona(id, payload));
    }
}
