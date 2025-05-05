package mx.unam.aragon.ico.is.computadoraapi;

import mx.unam.aragon.ico.is.computadoraapi.entities.Computadora;
import mx.unam.aragon.ico.is.computadoraapi.respositories.ComputadoraRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComputadoraapiApplicationTests {
    @Autowired
    private ComputadoraRepository computadoraRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    void insetarComputadora(){
//        Computadora computadora = new Computadora(0,"HP", "Pavillion 3000", null, 13000.0f);
//        computadoraRepository.save(computadora);
//    }

    @Test
    void leerComputadora(){
        Long claveTmp = 2L;
        Computadora tmp = computadoraRepository.findComputadoraByClave(claveTmp);
        System.out.println(tmp);
    }

    @Test
    void eliminarComputadora(){
        Long claveTmp = 2L;
        computadoraRepository.deleteById(claveTmp);
    }

    @Test
    void actualizarComputadora(){
        Long claveTmp = 1L;
        Computadora tmp = computadoraRepository.findComputadoraByClave(claveTmp);
        tmp.setModelo("Patito 2000");
        computadoraRepository.save(tmp);
    }
}
