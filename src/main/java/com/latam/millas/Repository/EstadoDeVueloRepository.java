package com.latam.millas.Repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.latam.millas.Model.EstadoDeVuelo;

@Repository
@Profile("jpa")
public interface EstadoDeVueloRepository extends JpaRepository<EstadoDeVuelo,Integer> {

}
