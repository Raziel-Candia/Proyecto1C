package mx.edu.utez.Proyecto1C.controller;

import jakarta.validation.Valid;
import mx.edu.utez.Proyecto1C.controller.dto.RequestBodyDTO;
import mx.edu.utez.Proyecto1C.controller.dto.RequestCalculadoraDTO;
import mx.edu.utez.Proyecto1C.service.MyService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin({"*"}) // todos los origenes
@RestController
@RequestMapping("/my-services")
public class MyController {

    private final MyService service;

    //
    public MyController(MyService service) {
        this.service = service;
    }


    @GetMapping
    public String miPrimerServicio(){
        return "Hello word";
    }

    @GetMapping("/servicio2")
    public String servicio2() {
        return "segundo servicio";
    }

    @PostMapping
    public String servicio3(){
        return "Este es el servicio 3";
    }

    @GetMapping("/path/{id}")
    public String pathvariable(@PathVariable String id){
        return "El path variable es: "+ id;
    }

    @PostMapping("/body")
    public String body(@RequestBody RequestBodyDTO payload){

        System.out.println(payload.getNombre());
        System.out.println(payload.getEdad());

        return "holiii";
    }

    @PostMapping("/calculadora")
    public double calculadora(@RequestBody @Valid RequestCalculadoraDTO payload){
        return service.calculadora(payload);

    }

}