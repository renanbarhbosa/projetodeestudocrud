package com.renanbarhbosa.projetodeestudocrud.repositories;

import com.renanbarhbosa.projetodeestudocrud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}