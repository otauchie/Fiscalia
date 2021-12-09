package ar.edu.unnoba.poo2021.Fiscalia.repository;

import ar.edu.unnoba.poo2021.Fiscalia.model.MovimientoBancario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoBancarioRepository extends JpaRepository<MovimientoBancario,Long> {
    public MovimientoBancario findByCuenta(String cuenta);
}
