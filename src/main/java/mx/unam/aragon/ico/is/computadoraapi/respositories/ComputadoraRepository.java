package mx.unam.aragon.ico.is.computadoraapi.respositories;

import mx.unam.aragon.ico.is.computadoraapi.entities.Computadora;
import org.springframework.data.repository.CrudRepository;

public interface ComputadoraRepository extends CrudRepository<Computadora, Long> {
    public Computadora findComputadoraByClave(Long clave);
}
