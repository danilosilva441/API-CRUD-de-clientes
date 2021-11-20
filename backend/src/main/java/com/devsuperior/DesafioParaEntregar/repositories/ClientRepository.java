package com.devsuperior.DesafioParaEntregar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.DesafioParaEntregar.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
