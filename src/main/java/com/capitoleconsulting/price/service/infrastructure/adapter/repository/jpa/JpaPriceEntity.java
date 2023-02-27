package com.capitoleconsulting.price.service.infrastructure.adapter.repository.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
public class JpaPriceEntity {
    @EmbeddedId
    protected JpaPriceEntityPk pk;
    @Column(name = "START_DATE")
    @NotNull
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    @NotNull
    private LocalDateTime endDate;

    @Column(name = "PRIORITY")
    @NotNull
    private Integer priority;

    @Column(name = "PRICE")
    @NotNull
    private BigDecimal price;

    @Column(name = "CURRENCY")
    @NotNull
    private String currency;

    @Column(name = "UPDATED_AT")
    @NotNull
    private LocalDateTime updatedAt;

    public JpaPriceEntity() {
    }

    public JpaPriceEntity(Long brandId,
                          LocalDateTime startDate,
                          LocalDateTime endDate,
                          Long priceList,
                          Long productId,
                          Integer priority,
                          BigDecimal price,
                          String currency,
                          LocalDateTime updatedAt
    ) {
        this.pk = new JpaPriceEntityPk(brandId,priceList,productId);
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
        this.updatedAt = updatedAt;
    }

    public JpaPriceEntityPk getPk() {
        return pk;
    }

    public void setPk(JpaPriceEntityPk pk) {
        this.pk = pk;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getBrandId(){
        return pk.getBrandId();
    }

    public Long getPriceList(){
        return pk.getPriceList();
    }

    public Long getProductId(){
        return pk.getProductId();
    }

}
