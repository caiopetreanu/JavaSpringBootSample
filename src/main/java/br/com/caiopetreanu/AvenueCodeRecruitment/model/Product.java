package br.com.caiopetreanu.AvenueCodeRecruitment.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caio Catanzaro Petreanu on 03/07/2017.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "description", nullable = false, unique = false)
    private String description;

    @Column(name = "parent_product_id", nullable = true, unique = false)
    private Long parentProductId;

    @Transient
    private List<Product> parentProducts = new ArrayList<>();;

    @Transient
    private List<Image> images = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentProductId() {
        return parentProductId;
    }

    public void setParentProductId(Long parentProductId) {
        this.parentProductId = parentProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (!description.equals(product.description)) return false;
        if (!id.equals(product.id)) return false;
        if (!name.equals(product.name)) return false;
        if (!parentProductId.equals(product.parentProductId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + parentProductId.hashCode();
        return result;
    }

    public List<Product> getParentProducts() {
        return parentProducts;
    }

    public void addParentProduct(Product p) {
        parentProducts.add(p);
    }

    public List<Image> getImages() {
        return images;
    }

    public void addImages(Image i) {
        images.add(i);
    }
}
