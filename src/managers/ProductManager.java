/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import Entity.Product;
import java.util.Scanner;

/**
 *
 * @author Nikita Butorov
 */
public class ProductManager {
    private Scanner scanner;
    
    public ProductManager(){
        this.scanner = new Scanner(System.in);
    }
    public Product createProduct(){
        Product product = new Product();
        System.out.println("Введите название продукта: ");
        product.setName(scanner.nextLine());
        System.out.println("Введите цену товара: ");
        product.setPrice(scanner.nextInt());
        scanner.nextLine();
        return product;
        
    }
}
