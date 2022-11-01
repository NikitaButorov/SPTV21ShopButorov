/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shop;

import Entity.Customer;
import Entity.Product;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import managers.CustomerManager;
import managers.ProductManager;

/**
 *
 * @author Nikita Butorov
 */
public class App {
     private Product[] products;
    private Customer[] customers;
    int history[];
    
   // private final ProductManager productManager;
    
public App(){
    //productManager = new ProductManager();
    this.products = new Product[0];
    this.customers = new Customer[0];
    this.history = new int[0];
}
    
    private boolean repeat;
    public void run(){
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
   
    do{
        System.out.println("Функции приложения");
        System.out.println("0.Выход из программы");
        System.out.println("1.Добавить продукт");
        System.out.println("2.Список продаваемых продуктов");
        System.out.println("3.Добавить покупателя");
        System.out.println("4.Список зарегистрированных покупателей");
        System.out.println("5.Покупка покупателем продукта");
        System.out.println("6.Доход магазина за все время работы");
        System.out.println("7.Добавить денег покупателю");
        System.out.println("Выберите номер задачи: ");
        int task = scanner.nextInt();
        scanner.nextLine();
         System.out.println("_____________________________"
                 + "___________________");
        switch(task){
            case 0:
                repeat = false;
                break;
            case 1:
                System.out.println("1.Добавить продукт");
                System.out.println("Добавить продукт");
                ProductManager productManager = new ProductManager();
                this.products = Arrays.copyOf(this.products, this.products.length+1);
                this.products[this.products.length-1] = productManager.createProduct();
                break;
            case 2:
                System.out.println("2.Список продаваемых продуктов");
                System.out.println("Список продаваемых продуктов");
                for (int i = 0; i<products.length;i++){
                    Product producti = products[i];
                    System.out.printf(i+1+"%s%n", producti.getName());
                    System.out.printf("%s%n", producti.getPrice());
                }
                break;
            case 3:
                System.out.println("3.Добавить покупателя");
                System.out.println("Добавить покупателя");
                CustomerManager customerManager = new CustomerManager();
                this.customers = Arrays.copyOf(this.customers, this.customers.length+1);
                this.customers[this.customers.length-1] = customerManager.createCustomer();
                break;
            case 4:
                System.out.println("4.Список зарегистрированных покупателей"); 
                System.out.println("Список зарегистрированных покупателей");
                for (int i = 0; i<customers.length;i++){
                    Customer customer = customers[i];
                    System.out.printf(i+1+"Firstname = %s%n", customer.getFirstname());
                    System.out.printf("Lastname = %s%n", customer.getLastname());
                    System.out.printf("money = %s%n", customer.getMoney());
                }
                break;
            case 5:
                System.out.println("5.Покупка покупателем продукта");
                System.out.println("Покупка покупателем продукта");
                for (int i = 0; i<products.length;i++){
                    Product producti = products[i];
                    System.out.printf(i+1+"name   = %s%n", producti.getName());
                    System.out.printf("price = %s%n", producti.getPrice());
                }
                for (int i = 0; i<customers.length;i++){
                    Customer customer = customers[i];
                    System.out.printf(i+1+"Firstname = %s%n", customer.getFirstname());
                    System.out.printf("Lastname = %s%n", customer.getLastname());
                    System.out.printf("money = %s%n", customer.getMoney());
                        System.out.println("Выберите покупателя: ");
                    int scan1 = scanner.nextInt();
                        System.out.println("Выберите продукт: ");
                    int scan2 = scanner.nextInt();
                    int pokup = customers[scan1-1].getMoney() - products[scan2-1].getPrice();
                    customers[scan2-1].setMoney(pokup);
                    this.history = Arrays.copyOf(this.history, this.history.length+1);
                    this.history[this.history.length-1] = products[scan2-1].getPrice();
                }
                break;
            case 6:
                System.out.println("6.Доход магазина за все время работы");
                int  sum = IntStream.of(history).sum();
                System.out.println("Доход магазина = "+ sum);
                
                break;
            case 7:
                System.out.println("7.Добавить денег покупателю");
                 for (int i = 0; i<customers.length;i++){
                    Customer customer = customers[i];
                    System.out.printf(i+1+"Firstname = %s%n", customer.getFirstname());
                    System.out.printf("Lastname = %s%n", customer.getLastname());
                    System.out.printf("money = %s%n", customer.getMoney());
                 }
                System.out.println("Выберите покупателя: ");
                int num1 = scanner.nextInt();
                System.out.println("Введите деньги");
                int num2 = scanner.nextInt();
                int moneyy = customers[num1-1].getMoney() + num2;
                        customers[num1-1].setMoney(moneyy);
                break;
        }
            System.out.println("================-----------------===============");
        }while(repeat);
        System.out.println("До свидания!");
    }
}
