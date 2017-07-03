package br.com.caiopetreanu.AvenueCodeRecruitment.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Caio Catanzaro Petreanu on 03/07/2017.
 */
@Entity
@Table(name = "image")
public class Image  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = true, unique = true)
    private Long id;

    @Column(name = "type", nullable = true, unique = false)
    private String type;

    @Column(name = "product_id", nullable = true, unique = false)
    private Long productId;

    @Transient
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;

        Image image = (Image) o;

        if (!id.equals(image.id)) return false;
        if (!productId.equals(image.productId)) return false;
        if (!type.equals(image.type)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + productId.hashCode();
        return result;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
