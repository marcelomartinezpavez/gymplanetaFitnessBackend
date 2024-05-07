package com.gimnasio.planetaFitness.repository;

import com.gimnasio.planetaFitness.dto.ClaseDto;
import com.gimnasio.planetaFitness.dto.ClientDto;
import com.gimnasio.planetaFitness.dto.ReservaDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository  extends CrudRepository<ReservaDto, Long> {

    @Query(value = "select * from reserva r inner join clients_reserva cr where r.rut = cr.rut and r.rut = :rut" , nativeQuery = true)
    List<ReservaDto> findByClient(String rut);

}
