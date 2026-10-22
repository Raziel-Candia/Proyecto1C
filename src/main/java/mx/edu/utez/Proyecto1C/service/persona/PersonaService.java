package mx.edu.utez.Proyecto1C.service.persona;

import jakarta.transaction.Transactional;
import mx.edu.utez.Proyecto1C.controller.usuarios.dto.ActualizarPersonaDTO;
import mx.edu.utez.Proyecto1C.exception.customExcepcions.NotFoundException;
import mx.edu.utez.Proyecto1C.model.persona.Persona;
import mx.edu.utez.Proyecto1C.repository.persona.PersonaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    //inyeccion de dependencias
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Transactional
    public Persona actualizarPersona(Long id, ActualizarPersonaDTO payload) {
        //validar que la persona exista
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "no existe una persona con el id " + id));


        persona.setNombres(payload.getNombres());
        persona.setPrimerApellido(payload.getPrimerApellido());
        persona.setSegundoApellido(payload.getSegundoApellido());
        persona.setFechaNacimiento(payload.getFechaNacimiento());
        persona.setCorreo(payload.getCorreo());
        persona.setCurp(payload.getCurp());

        return personaRepository.save(persona);
    }
}
