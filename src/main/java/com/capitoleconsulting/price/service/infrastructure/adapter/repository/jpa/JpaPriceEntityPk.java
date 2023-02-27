package com.capitoleconsulting.price.service.infrastructure.adapter.repository.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.StringJoiner;

@Embeddable
public class JpaPriceEntityPk implements Serializable {

    private static final long serialVersionUID = -1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "BRAND_ID")
    private Long brandId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE_LIST")
    private Long priceList;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCT_ID")
    private Long productId;

    public JpaPriceEntityPk() {
    }

    public JpaPriceEntityPk(Long brandId, Long priceList, Long productId) {
        this.brandId = brandId;
        this.priceList = priceList;
        this.productId = productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getPriceList() {
        return priceList;
    }

    public void setPriceList(Long priceList) {
        this.priceList = priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JpaPriceEntityPk.class.getSimpleName() + "[", "]")
                .add("brandId=" + brandId)
                .add("priceList=" + priceList)
                .add("productId=" + productId)
                .toString();
    }
}
