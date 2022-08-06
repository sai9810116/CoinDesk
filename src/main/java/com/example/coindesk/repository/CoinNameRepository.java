package com.example.coindesk.repository;

import com.example.coindesk.entity.CoinNameMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinNameRepository extends JpaRepository<CoinNameMappingEntity, String> { }
