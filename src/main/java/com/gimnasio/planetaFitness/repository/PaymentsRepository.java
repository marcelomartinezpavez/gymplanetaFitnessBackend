package com.gimnasio.planetaFitness.repository;

import com.gimnasio.planetaFitness.dto.PaymentsDto;
import com.gimnasio.planetaFitness.dto.PlanDto;
import com.gimnasio.planetaFitness.response.PaymentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentsRepository extends JpaRepository<com.gimnasio.planetaFitness.dto.PaymentsDto, Long> {

    //@Query("select * from ordenTrabajo")
    //List<OrdenTrabajoDto> findAll();

    //@Query("{numeroOrden:'?0'}")

    Optional<PaymentsDto> findById(String id);

   // @Query(value = "select * from ORDEN_TRABAJO ot where ot.numero_orden = :numeroOrden", nativeQuery = true)
   // com.gimnasio.planetaFitness.dto.PaymentsDto findByNumeroOrden(String numeroOrden);

   // @Query(value = "select * from ORDEN_TRABAJO ot where ot.numero_orden = :numeroOrden and empresa_id = :idEmpresa", nativeQuery = true)
   // com.gimnasio.planetaFitness.dto.PaymentsDto findByNumeroOrdenAndEmpresa(String numeroOrden, long idEmpresa);

   // @Query(value = "select * from ORDEN_TRABAJO ot where ot.patente_vehiculo = :patente", nativeQuery = true)
   // List<com.gimnasio.planetaFitness.dto.PaymentsDto> findByPatenteVehiculo(String patente);

   // @Query(value = "select * from ORDEN_TRABAJO ot where ot.patente_vehiculo = :patente and empresa_id = :idEmpresa", nativeQuery = true)
   // List<com.gimnasio.planetaFitness.dto.PaymentsDto> findByPatenteVehiculoAndEmpresa(String patente, long idEmpresa);

    //@Query(value = "select * from ORDEN_TRABAJO ot where ot.rut_cliente = :rutCliente", nativeQuery = true)
    @Query(value = "select * from payments p where p.rut = :rutCliente",nativeQuery = true)
    List<PaymentsDto> findByRutCliente(String rutCliente);


   // @Query(value = "select * from ORDEN_TRABAJO ot where ot.rut_cliente = :rutCliente and empresa_id = :idEmpresa", nativeQuery = true)
   // List<com.gimnasio.planetaFitness.dto.PaymentsDto> findByRutClienteAndEmpresa(String rutCliente, long idEmpresa);

   // @Query(value = "select * from ORDEN_TRABAJO ot where ot.empresa_id = :idEmpresa", nativeQuery = true)
   // List<com.gimnasio.planetaFitness.dto.PaymentsDto> findByIdEmpresa(long idEmpresa);

    //@Query("{id:'?0'}")
    //OrdenTrabajoDto findById(String id);

    //@Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    //@Query(value = "select * from payments p join clients c on p.rut = c.rut", nativeQuery = true)
    @Query(value = "select * from payments", nativeQuery = true)
    List<PaymentsDto> findAll();

}
