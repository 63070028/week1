package com.example.week1;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class CustomerController {
    private List<Customer> customers = new ArrayList<Customer>();


    public CustomerController() {
        customers.add(new Customer("1010", "John", "Male", 25));
        customers.add(new Customer("1018", "Peter", "Male", 24));
        customers.add(new Customer("1019", "Sara", "Female", 23));
        customers.add(new Customer("1110", "Rose", "Female", 23));
        customers.add(new Customer("1001", "Emma", "Female", 30));
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(){

        return  customers;
    }

    @RequestMapping(value = "/customerbyid/{ID}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("ID") String ID){
        Optional<Customer> matchingObject = customers.stream().filter(p -> p.getID().equals(ID)).findFirst();
        Customer c = matchingObject.get();
        return  c;
    }
    @RequestMapping(value = "/customerbyname/{n}", method = RequestMethod.GET)
    public Customer getCustomerName(@PathVariable("n") String n){
        Optional<Customer> matchingObject = customers.stream().filter(p -> p.getName().equals(n)).findFirst();
        Customer c = matchingObject.get();
        return  c;
    }
    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.GET)
    public boolean delCustomerByID(@PathVariable("id") String ID){
        customers.removeIf(c -> c.getID().equals(ID));
        return true;
    }

    @RequestMapping(value = "/customerDelByname/{n}", method = RequestMethod.GET)
    public boolean delCustomerByName(@PathVariable("n") String n){
        customers.removeIf(c -> c.getName().equals(n));
        return true;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
//    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public  boolean addCustomer(@RequestParam("ID") String ID, @RequestParam("name") String name,
                                @RequestParam("sex") String sex, @RequestParam("age") int age){
        customers.add(new Customer(ID, name, sex, age));
        return  true;
    }
}
