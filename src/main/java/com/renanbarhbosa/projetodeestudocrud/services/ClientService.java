package com.renanbarhbosa.projetodeestudocrud.services;

import com.renanbarhbosa.projetodeestudocrud.dto.ClientDTO;
import com.renanbarhbosa.projetodeestudocrud.entities.Client;
import com.renanbarhbosa.projetodeestudocrud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
        Page<Client> list = repository.findAll(pageRequest);
        return list.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO findById(Long id) {
        Optional<Client> obj = repository.findById(id);
        Client entity = obj.orElseThrow(() -> new RuntimeException("Entity not found"));
        return new ClientDTO(entity);
    }
}