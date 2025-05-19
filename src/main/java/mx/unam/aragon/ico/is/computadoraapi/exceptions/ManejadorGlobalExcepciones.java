package mx.unam.aragon.ico.is.computadoraapi.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;

@RestControllerAdvice
public class ManejadorGlobalExcepciones {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> manejoDeRest(ConstraintViolationException ex){
        HashMap<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", ex.getLocalizedMessage());
        respuesta.put("timestam", LocalDateTime.now().toString());
        return new ResponseEntity<>("erro", HttpStatus.BAD_REQUEST);
    }

}
