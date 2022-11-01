/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import Entity.Customer;
import java.util.Scanner;

/**
 *
 * @author Nikita Butorov
 */
public class CustomerManager {
    private Scanner scanner;
    
    public CustomerManager(){
        this.scanner = new Scanner(System.in);
    }
    public Customer createCustomer(){
        Customer customer = new Customer();
        System.out.println("Введите имя: ");
        customer.setFirstname(scanner.nextLine());
        System.out.println("Введите фамилию: ");
        customer.setLastname(scanner.nextLine());
        System.out.println("Введите деньги: ");
        customer.setMoney(scanner.nextInt());
        scanner.nextLine();
        return customer;
    }
}
