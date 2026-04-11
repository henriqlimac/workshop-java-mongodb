package dev.henriqlimac.workshopmdb.dto.product;

import dev.henriqlimac.workshopmdb.domain.product.Product;

public class ProductDTO {

    private String id;
    private String name;
    private Double averageRange;
    private Double tolerance;
    private Double lowerTolerance;
    private Double higherTolerance;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.averageRange = product.getAverageRange();
        this.tolerance = product.getTolerance();
        this.lowerTolerance = product.getLowerTolerance();
        this.higherTolerance = product.getHigherTolerance();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAverageRange() {
        return averageRange;
    }

    public void setAverageRange(Double averageRange) {
        this.averageRange = averageRange;
    }

    public Double getTolerance() {
        return tolerance;
    }

    public void setTolerance(Double tolerance) {
        this.tolerance = tolerance;
    }

    public Double getLowerTolerance() {
        return lowerTolerance;
    }

    public void setLowerTolerance(Double lowerTolerance) {
        this.lowerTolerance = lowerTolerance;
    }

    public Double getHigherTolerance() {
        return higherTolerance;
    }

    public void setHigherTolerance(Double higherTolerance) {
        this.higherTolerance = higherTolerance;
    }
}
