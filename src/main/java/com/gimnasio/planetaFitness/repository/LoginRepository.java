package com.gimnasio.planetaFitness.repository;

import com.gimnasio.planetaFitness.dto.UsersDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<UsersDto, Long> {

    //@Query("select l from users l where l.users = ?0 and l.pass = ?1")
    Optional<UsersDto> findByUsersAndPass(String users, String pass);

    //@Query("select l from users l where l.users = ?0 and l.pass = ?1")
    //Optional<UsersDto> findByUsersAndPassAndEmpresa(String users, String pass,);

}
