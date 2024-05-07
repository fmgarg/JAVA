package com.coderhouse.controllers;
import com.coderhouse.models.OrderProduct;
import com.coderhouse.models.Orders;
import com.coderhouse.models.Products;
import com.coderhouse.services.OrdersService;
import com.coderhouse.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ProductsService productsService;

    private final RestTemplate restTemplate = new RestTemplate();
    @GetMapping(value= "/", produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<Orders>> getAllOrders() {
        try {
            List<Orders> ordersList = ordersService.ordersGetAll();
            return new ResponseEntity<>(ordersList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value= "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Orders> getOrderById(@PathVariable int id) {
        try{
            Orders orders = ordersService.ordersGetById(id);
            if(orders != null) {
                return new ResponseEntity<>(orders, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> saveOrder(@RequestBody Orders order) {
        if (order.getCustomer() == null) { //customer not found
            System.out.println("Customer not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Orders newOrder = new Orders();
        newOrder.setCustomer(order.getCustomer());
        //newOrder.setSaleDate(order.getSaleDate());
        String url = "http://worldtimeapi.org/api/timezone/America/Argentina/Buenos_Aires";
        Date saleDate = null;
        try {
            String response = restTemplate.getForObject(url, String.class);
            LocalDateTime localDateTime = LocalDateTime.parse(response, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            saleDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            saleDate = new Date();
        }
        newOrder.setSaleDate(saleDate);

        List<OrderProduct> orderProducts = order.getOrderItems();
        List<OrderProduct> newOrderProducts = new ArrayList<>();
        //System.out.println(orderProducts.toString());
        if (orderProducts.isEmpty()) {
            System.out.println("Product not found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (orderProducts != null && !orderProducts.isEmpty()) {
            for (OrderProduct originalOrderProduct : orderProducts) {
                System.out.println("for");
                Products product = productsService.productsFindById(originalOrderProduct.getProduct().getSKU());
                if (product.getStock() < originalOrderProduct.getQuantity()) {
                    System.out.println("Not enough stock for product");
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
                OrderProduct orderProduct = new OrderProduct();
                orderProduct.setProduct(product);
                orderProduct.setQuantity(originalOrderProduct.getQuantity());
                //orderProduct.setOrder(newOrder);
                newOrderProducts.add(orderProduct);
                product.setStock(product.getStock() - orderProduct.getQuantity());
                productsService.updateProductStock(product, orderProduct.getQuantity());

            }
            newOrder.setOrderItems(newOrderProducts);
        }

        double totalAmount = orderProducts.stream()
                .mapToDouble(orderProduct -> orderProduct.getProduct().getPrice() * orderProduct.getQuantity())
                .sum();
        newOrder.setTotalAmount(totalAmount);

        ordersService.ordersSave(newOrder);

        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }
}
