package com.project.supermarket.productos.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "productName", nullable = false)
        private String productName;

        @Column(name = "productPrice")
        private Float productPrice;

        @Column(name = "cantidadProducto")
        private Integer cantidadProducto;

        @Column(name = "proveedorProducto")
        private String proveedorProducto;

        // Relación muchos a muchos con tipo de producto
        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
        @JoinTable(name = "products_types", joinColumns = {
                        @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
                                        @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false, updatable = false)
                        })
        private Set<Type> types = new HashSet<>();

        public Product() {

        }

        public Product(String productName, Float productPrice, Integer cantidadProducto, String proveedorProducto) {
                this.productName = productName;
                this.productPrice = productPrice;
                this.cantidadProducto = cantidadProducto;
                this.proveedorProducto = proveedorProducto;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getProductName() {
                return productName;
        }

        public void setProductName(String productName) {
                this.productName = productName;
        }

        public Float getProductPrice() {
                return productPrice;
        }

        public void setProductPrice(Float productPrice) {
                this.productPrice = productPrice;
        }

        public Integer getCantidadProducto() {
                return cantidadProducto;
        }

        public void setCantidadProducto(Integer cantidadProducto) {
                this.cantidadProducto = cantidadProducto;
        }

        public String getProveedorProducto() {
                return proveedorProducto;
        }

        public void setProveedorProducto(String proveedorProducto) {
                this.proveedorProducto = proveedorProducto;
        }

        public Set<Type> getTypes() {
                return types;
        }

        public void setTypes(Set<Type> types) {
                this.types = types;
        }

        @Override
        public String toString() {
                return "Product{" + "productName =" + productName + ", productPrice=" + productPrice
                                + ", cantidadProducto=" + cantidadProducto + ", proveedorProducto=" + proveedorProducto
                                + '}';
        }

}
