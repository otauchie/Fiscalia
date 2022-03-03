package ar.edu.unnoba.poo2021.Fiscalia.repository;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CausaRepository extends JpaRepository<Causa,Long> {
    public Causa findByNumero(String numero);

    @Query(value = "SELECT * FROM causas " +
            "ORDER BY fecha DESC ",nativeQuery = true)
    List<Causa> ordenarCausas();

    @Query(value =
            "SELECT * FROM causas c WHERE lower(c.numero) LIKE lower(CONCAT('%', ?1, '%'))" +
                    "OR lower(c.victima) LIKE lower(CONCAT('%', ?1, '%'))" +
                    "OR lower(c.victimario) LIKE lower(CONCAT('%', ?1, '%'))"+
                    "ORDER BY c.fecha DESC", nativeQuery = true)
    List<Causa> buscarCausas(String keyword);


}
