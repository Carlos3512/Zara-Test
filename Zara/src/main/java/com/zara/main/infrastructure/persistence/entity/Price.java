package com.zara.main.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "PRICE")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "BRAND_ID")
    private Long brandId;
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    private LocalDateTime endDate;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "PRIORITY")
    private Boolean priority;
    @Column(name = "PRICE_LIST")
    private Long priceList;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "CURR")
    private String curr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Price price = (Price) o;
        return id != null && Objects.equals(id, price.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
