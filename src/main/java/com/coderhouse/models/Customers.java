package com.coderhouse.models;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
@Table(name="Customers")
public class Customers {
    @Id
    @Column(name="dni")
    private Integer dni;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="address")
    private String address;
    @Column(name="phone")
    private Integer phone;
    @Column(name="email")
    private String email;
    @Column(name="bornday")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    private Date bornday;

//	@ManyToOne
//	@JoinColumn(name="SKU")
//	private Producto product;
//	private Integer idProduct;

/*    @ManyToMany
    @JoinTable(name="Sales"
            ,joinColumns = @JoinColumn(name="user_id")
            ,inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private Set<Products> product;

    public Set<Products> getProduct() {
        return product;
    }

    public void setProduct(Set<Products> product) {
        this.product = product;
    }*/

    public Customers() {
        super();
    }

    public Integer getDni() {
        return dni;
    }
    public void setDni(Integer dni) {
        this.dni = dni;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getPhone() {
        return phone;
    }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customers other = (Customers) obj;
        return Objects.equals(email, other.email);
    }
}
