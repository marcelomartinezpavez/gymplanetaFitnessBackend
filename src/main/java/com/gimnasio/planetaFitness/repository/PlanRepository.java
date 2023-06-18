package com.gimnasio.planetaFitness.repository;

import com.gimnasio.planetaFitness.dto.PlanDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanRepository extends JpaRepository<PlanDto, Long> {

    //@Query("select * from proveedores")
    //List<ProveedorDto> findAll();

    @Query(value = "select * from plan p", nativeQuery = true)
    List<PlanDto> findAll();

    @Query(value = "select * from plan p where enabled = true", nativeQuery = true)
    List<PlanDto> findAllHabilitado();

    //@Query(value = "select * from plan p where p.rut = :rut", nativeQuery = true)
    //Optional<PlanDto> findByRutAndHabilitado(String rut);

    @Query(value = "select * from plan p where p.name = :name", nativeQuery = true)
    Optional<PlanDto> findByNameAndHabilitado(String name);


    //@Query(value = "select * from plan p where p.empresa_id = :idEmpresa ", nativeQuery = true)
    //List<PlanDto> findByEmpresaId(long idEmpresa);


    //@Query("{rut:'?0'}")
    Optional<PlanDto> findById(String id);

    //@Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    //List<ClienteDto> findAll(String category);

}
