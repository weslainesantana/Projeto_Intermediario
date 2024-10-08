package com.weslaine.projeto_intermediario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weslaine.projeto_intermediario.models.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
