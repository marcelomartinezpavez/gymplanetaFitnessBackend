package com.gimnasio.planetaFitness.repository;

import com.gimnasio.planetaFitness.dto.EmpresaDto;
//import org.bson.types.ObjectId;
import com.gimnasio.planetaFitness.dto.PlanDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaDto, Long> {

    //@Query("{id:'?0'}")
    //Optional<EmpresaDto> findById(ObjectId id);

    //@Query(value = "select e from empresa e where e.rut = :rut", nativeQuery = true)
    //EmpresaDto buscarPorRut(String rut);

    Optional<EmpresaDto> findByRut(String rut);
    Optional<EmpresaDto> findById(String id);


}
