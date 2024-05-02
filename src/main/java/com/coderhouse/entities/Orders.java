package com.coderhouse.entities;
import com.coderhouse.repositories.OrdersRepository;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Orders")
public abstract class Orders implements OrdersRepository {
    @Id
    @SequenceGenerator(
            name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "ticket_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long orderId;
    @ManyToMany(
            cascade = CascadeType.ALL, //permite todas las operaciones
            fetch = FetchType.EAGER // permite traer todos los datos asociados
    )
    @JoinTable(
            name = "customers_map", // Nombre de la columna de clave externa en la tabla de ventas
            joinColumns = @JoinColumn(
                    name = "order_id",
                    referencedColumnName = "orderId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "customer_id",
                    referencedColumnName = "dni"
            )
    )
    private List<Customers> customersList;
    @ManyToMany(
            cascade = CascadeType.ALL, //permite todas las operaciones
            fetch = FetchType.EAGER // permite traer todos los datos asociados
    )
    @JoinTable(
            name = "products_map",
            joinColumns = @JoinColumn(
                    name = "order_id",
                    referencedColumnName = "orderId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "productId",
                    referencedColumnName = "SKU"
            )
    ) // Nombre de la columna de clave externa en la tabla de ventas
    private List<Products> productsList;
    private Date saleDate;
    private double totalAmount;

    // Constructor sin argumentos
    public Orders() {
    }

    // Getters y setters


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Customers> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customers> customersList) {
        this.customersList = customersList;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    @Override
    public Date getSaleDate() {
        return saleDate;
    }

    @Override
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
