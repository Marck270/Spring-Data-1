package mx.unam.aragon.ico.is.computadoraapi.services.interfaces;

import mx.unam.aragon.ico.is.computadoraapi.entities.Computadora;

import java.util.List;
import java.util.Optional;

public interface ComputadoraService {
    public abstract Optional<Computadora> buscarPorId(Long id);
    public abstract Iterable<Computadora> listar();
    public abstract Computadora crear(Computadora computadora);
    public abstract Computadora actualizar(Long id, Computadora computadora);
    public abstract Computadora eliminar(Long id);




}
