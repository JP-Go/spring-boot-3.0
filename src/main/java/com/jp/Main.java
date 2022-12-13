package com.jp;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {

  private final CustomerRepository customerRepository;

  public Main(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @GetMapping
  public List<Customer> getCustomer() {
    return customerRepository.findAll();
  }

  record NewCustomerRequest(String name, String email, Integer age) {}

  @PostMapping
  public void addCustomer(@RequestBody NewCustomerRequest request) {
    Customer customer = new Customer();
    customer.setName(request.name());
    customer.setEmail(request.email());
    customer.setAge(request.age());

    customerRepository.save(customer);
  }

  @DeleteMapping("{customerId}")
  public void removeCustomer(@PathVariable("customerId") Integer customerId) {
    customerRepository.deleteById(customerId);
  }

  record UpdateCustomerRequest(String name, String email, Integer age) {}

  @PutMapping("{customerId}")
  public void updateCustomer(@PathVariable("customerId") Integer customerId,
                             @RequestBody UpdateCustomerRequest request) {
    Customer customer = customerRepository.findById(customerId)
                            .orElseThrow(RuntimeException::new);
    if (request.name() != null && request.name().length() > 0)
      customer.setName(request.name());
    if (request.email() != null && request.email().length() > 0)
      customer.setEmail(request.email());
    if (request.age() != null && request.age() > 0)
      customer.setAge(request.age());
  }
}
