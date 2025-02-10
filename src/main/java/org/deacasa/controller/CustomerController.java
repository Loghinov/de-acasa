package org.deacasa.controller;

import lombok.RequiredArgsConstructor;
import org.deacasa.entity.Customer;
import org.deacasa.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    // Получение всех клиентов
    @GetMapping("/get-all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Получение клиента по ID
    @GetMapping("/get/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    // Создание нового клиента
    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // Обновление данных клиента
    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    // Удаление клиента
    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
