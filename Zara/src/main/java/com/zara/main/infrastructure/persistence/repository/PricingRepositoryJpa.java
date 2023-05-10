package com.zara.main.infrastructure.persistence.repository;

import com.zara.main.infrastructure.persistence.entity.Price;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PricingRepositoryJpa extends JpaRepository<Price,Long> {

    @Query("SELECT p FROM Price p WHERE p.productId = :productId AND p.brandId = :brandId AND :startDate BETWEEN p.startDate AND p.endDate")
    List<Price> getByParams(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("startDate") LocalDateTime startDate);

}
