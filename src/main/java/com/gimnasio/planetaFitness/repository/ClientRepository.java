package com.gimnasio.planetaFitness.repository;

import com.gimnasio.planetaFitness.dto.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientDto, Long> {

    //@Override
    Optional<ClientDto> findByRut(String aLong);

    @Query(value = "select nextval('client_id_seq')", nativeQuery = true)
    long findNextVal();

    @Query(value = "select * from clients c where c.rut = :rut", nativeQuery = true)
    Optional<ClientDto> findByRutAndHabilitado(String rut);

    @Query(value = "select * from clients c where c.number_client = :numberClient", nativeQuery = true)
    Optional<ClientDto> findByNumberAndHabilitado(long numberClient);

    @Query(value = "select * from clients where name like :name%", nativeQuery = true)
    Optional<ClientDto> getClientByName(String name);

    @Query(value = "select * from clients where rut like :rut%", nativeQuery = true)
    Optional<ClientDto> getClienteByLikeRut(String rut);
    @Query(value = "select * from clients c where c.empresa_id = :idEmpresa", nativeQuery = true)
    List<ClientDto> findByEmpresaId(long idEmpresa);

    @Query(value = "select * from clients c where c.enabled = true", nativeQuery = true)
    List<ClientDto> findAllHabilitado();

    @Query(value = "select * from clients c where c.rut = :rut and c.empresa_id = :empresa_id", nativeQuery = true)
    Optional<ClientDto> findByRutAndHabilitadoAndEmpresa(String rut, long empresa_id);


}
