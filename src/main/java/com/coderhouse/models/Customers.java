package com.coderhouse.models;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
@Schema(description = "Customers Model")
@Entity
@Table(name="Customers")
public class Customers {
    @Schema(description = "Customer Id/ dni", requiredMode = Schema.RequiredMode.REQUIRED, example = "28777888")
    @Id
    @Column(name="dni")
    private Integer dni;
    @Schema(description = "Customer name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Francisco")
    @Column(name="name")
    private String name;
    @Schema(description = "Customer surname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Gonzalez")
    @Column(name="surname")
    private String surname;
    @Schema(description = "Customer address", requiredMode = Schema.RequiredMode.REQUIRED, example = "Las Rosas 333, Don Torcuato")
    @Column(name="address")
    private String address;
    @Schema(description = "Customer phone", requiredMode = Schema.RequiredMode.REQUIRED, example = "1154122848")
    @Column(name="phone")
    private Integer phone;
    @Schema(description = "Customer email", requiredMode = Schema.RequiredMode.REQUIRED, example = "fmgarg@gmail.com")
    @Column(name="email")
    private String email;
    @Schema(description = "Customer bornday", requiredMode = Schema.RequiredMode.REQUIRED, example = "07-07-1977")
    @Column(name="bornday")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    private Date bornday;

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
