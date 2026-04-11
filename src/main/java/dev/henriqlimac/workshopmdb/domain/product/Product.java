package dev.henriqlimac.workshopmdb.domain.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private Double averageRange;
    private Double tolerance;
    private Double lowerTolerance;
    private Double higherTolerance;

    public Product() {
    }

    public Product(String id, String name, Double averageRange, Double tolerance) {
        this.id = id;
        this.name = name;
        this.averageRange = averageRange;
        this.tolerance = tolerance;
        updateTolerances();
    }

    public Double calculateLowerTolerance() {
        if (averageRange == null || tolerance == null) return null;
        return averageRange - (averageRange * (tolerance / 100.0));
    }

    public Double calculateHigherTolerance() {
        if (averageRange == null || tolerance == null) return null;
        return averageRange + (averageRange * (tolerance / 100.0));
    }

    private void updateTolerances() {
        this.lowerTolerance = calculateLowerTolerance();
        this.higherTolerance = calculateHigherTolerance();
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
        updateTolerances();
    }

    public Double getTolerance() {
        return tolerance;
    }

    public void setTolerance(Double tolerance) {
        this.tolerance = tolerance;
        updateTolerances();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
