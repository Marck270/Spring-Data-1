package mx.unam.aragon.ico.is.computadoraapi.controllers;

import mx.unam.aragon.ico.is.computadoraapi.entities.Computadora;
import mx.unam.aragon.ico.is.computadoraapi.services.ComputadoraServiceImpl;
import mx.unam.aragon.ico.is.computadoraapi.services.interfaces.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/computadoras")
public class ComputadoraRestController {

    @Autowired
    private ComputadoraService computadoraService;
    @Autowired
    private ComputadoraServiceImpl computadoraServiceImpl;

    @GetMapping("/")
    public ResponseEntity<Iterable<Computadora>> getComputadora(){
//        return computadoraService.listar();
        return new ResponseEntity<>(computadoraService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{clave}")
    public ResponseEntity<Computadora> getComputadoraPorClave(@PathVariable Long clave){
//        return computadoraService.buscarPorId(clave).orElse(null);
//        return new ResponseEntity<>(computadoraService.buscarPorId(clave).orElse(null), HttpStatus.OK);
        Optional<Computadora> tmp = computadoraService.buscarPorId(clave);
        if (tmp.isPresent()){
            return new ResponseEntity<>(tmp.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(tmp.get(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Computadora> createComputadora(@RequestBody Computadora computadora){
        return new ResponseEntity<>(computadoraService.crear(computadora), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> noExiste() {
        return new ResponseEntity<>("End Point no soportado", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{clave}")
    public ResponseEntity<Computadora> actualizarParcial(@PathVariable Long clave, @RequestBody Computadora computadora){
        Computadora tmp = computadoraService.buscarPorId(clave).orElse(null);
        if (tmp != null){
            if (computadora.getMarca() != null) tmp.setMarca(computadora.getMarca());
            if (computadora.getModelo() != null) tmp.setModelo(computadora.getModelo());
            if (computadora.getPrecio() != null) tmp.setPrecio(computadora.getPrecio());
            if (computadora.getFoto() != null) tmp.setFoto(computadora.getFoto());
            return new ResponseEntity<>(computadoraService.actualizar(clave,tmp), HttpStatus.OK);
            //if else
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{clave}")
    public ResponseEntity<Computadora> editar(@PathVariable long clave, @RequestBody Computadora computadora){
        Optional tmp = computadoraService.buscarPorId(clave);
        if(tmp.isPresent()){
            return new ResponseEntity<>(computadoraService.actualizar(clave, computadora), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{clave}")
    public ResponseEntity<Computadora> eliminar (@PathVariable Long clave){
        Computadora tmp = computadoraService.buscarPorId(clave).orElse(null);
        if (tmp != null){
            return new ResponseEntity<>(computadoraService.eliminar(clave), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

 }
