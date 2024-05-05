package com.coderhouse;

import com.coderhouse.models.Customers;
import com.coderhouse.models.Products;
import com.coderhouse.repositories.CustomersRepository;
import com.coderhouse.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

@SpringBootApplication
public class FacturacionEntregaProyectoFinalGonzalezApplication {
/*	@Autowired
	private CustomersRepository customersRepository;*/

/*	@Autowired
	private ProductsRepository productsRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(FacturacionEntregaProyectoFinalGonzalezApplication.class, args);
	}

/*	public void customersListAll() {
		List<Customers> listCustomers = customersRepository.findAll();
		if (listCustomers.isEmpty()) {
			System.out.println("No customers found");
		}else {
			for (Customers customer : listCustomers) {
				System.out.println(
						"Customer DNI: "
						+ customer.getDni()
						+ "name " + customer.getName() + " "
						+ "surname " + customer.getSurname()
						//+ " and purchase "
						//+ customer.getProduct()
				);
			}
		}
	}*/

	/*public void customerAddNew() {
		List<Products> listProducts = productsRepository.findAll();
		if(listProducts.isEmpty()) {
			System.out.println("No products found");
		}
		Scanner scanner = new Scanner(System.in);
		Customers customer;
		customer = new Customers() {
			@Override
			public void flush() {

			}

			@Override
			public <S extends Customers> S saveAndFlush(S entity) {
				return null;
			}

			@Override
			public <S extends Customers> List<S> saveAllAndFlush(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public void deleteAllInBatch(Iterable<Customers> entities) {

			}

			@Override
			public void deleteAllByIdInBatch(Iterable<Integer> integers) {

			}

			@Override
			public void deleteAllInBatch() {

			}

			@Override
			public Customers getOne(Integer integer) {
				return null;
			}

			@Override
			public Customers getById(Integer integer) {
				return null;
			}

			@Override
			public Customers getReferenceById(Integer integer) {
				return null;
			}

			@Override
			public <S extends Customers> List<S> findAll(Example<S> example) {
				return List.of();
			}

			@Override
			public <S extends Customers> List<S> findAll(Example<S> example, Sort sort) {
				return List.of();
			}

			@Override
			public <S extends Customers> List<S> saveAll(Iterable<S> entities) {
				return List.of();
			}

			@Override
			public List<Customers> findAll() {
				return List.of();
			}

			@Override
			public List<Customers> findAllById(Iterable<Integer> integers) {
				return List.of();
			}

			@Override
			public <S extends Customers> S save(S entity) {
				return null;
			}

			@Override
			public Optional<Customers> findById(Integer integer) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(Integer integer) {
				return false;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(Integer integer) {

			}

			@Override
			public void delete(Customers entity) {

			}

			@Override
			public void deleteAllById(Iterable<? extends Integer> integers) {

			}

			@Override
			public void deleteAll(Iterable<? extends Customers> entities) {

			}

			@Override
			public void deleteAll() {

			}

			@Override
			public List<Customers> findAll(Sort sort) {
				return List.of();
			}

			@Override
			public Page<Customers> findAll(Pageable pageable) {
				return null;
			}

			@Override
			public <S extends Customers> Optional<S> findOne(Example<S> example) {
				return Optional.empty();
			}

			@Override
			public <S extends Customers> Page<S> findAll(Example<S> example, Pageable pageable) {
				return null;
			}

			@Override
			public <S extends Customers> long count(Example<S> example) {
				return 0;
			}

			@Override
			public <S extends Customers> boolean exists(Example<S> example) {
				return false;
			}

			@Override
			public <S extends Customers, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
				return null;
			}
		};

		System.out.print("Enter customer DNI: ");
		customer.setDni(scanner.nextInt());
		System.out.print("Enter customer name: ");
		customer.setName(scanner.next());
		System.out.print("Enter customer surname: ");
		customer.setSurname(scanner.next());
		System.out.print("Enter customer address: ");
		customer.setAddress(scanner.next());
		System.out.print("Enter customer phone number: ");
		customer.setPhone(scanner.nextInt());
		System.out.print("Enter customer email: ");
		customer.setEmail(scanner.next());

	}*/
}
