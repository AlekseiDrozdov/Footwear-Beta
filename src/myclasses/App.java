package myclasses;

import entity.Customer;
import entity.Product;
import entity.History;
import interfaces.Keeping;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import keeper.FileKeeper;

/**
 *
 * @seller pupil
 */
public class App {
    Scanner scanner = new Scanner(System.in);
    List<Product> products = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();
    List<History> histories = new ArrayList<>();
    Keeping keeper = new FileKeeper(); 
    double totalPrice = 0;
    public App() {
        products = keeper.loadProducts(); 
        histories = keeper.loadHistories();
        customers = keeper.loadCustomers();
       
    }
    public void run(){
        String repeat = "y";
        do{
            System.out.println("Выберите задачу");
            System.out.println("0: Закончить программу");
            System.out.println("1: Добавить модель");
            System.out.println("2: Вывести список продаваемых моделей");
            System.out.println("3: Добавить покупателя");
            System.out.println("4: Список зарегестрированных покупателей");
            System.out.println("5: Продать товар");
            System.out.println("6: Доход магазина за все время работы");
            System.out.println("7: Пополнить счет покупателю");

            
            int task = scanner.nextInt();
            scanner.nextLine();
            switch(task){
                case 0: 
                    repeat ="q"; 
                    System.out.println("Программа закончена");
                    break;
               
                case 1: 
                    System.out.println("Добавить модель");
                    products.add(addProduct());
                    keeper.saveProducts(products);
                    break;
                case 2:
               
                    System.out.println("Вывести список продаваемых моделей:");
                    for (int i = 0; i < products.size(); i++) {
                        if (products.get(i)!=null){
                           System.out.println((i+1)+ " " + products.get(i).toString()); 
                        }
                    }
                    break;
                
                case 3:
                    System.out.println("Добавить покупателя");
                    customers.add(addCustomer());
                    keeper.saveCustomers(customers);
                    break;
                    
                case 4:
                    System.out.println("Список зарегестрированных покупателей");
                    for (int i = 0; i < customers.size(); i++) {
                        if (customers.get(i)!=null){
                           System.out.println(customers.get(i).toString()); 
                        }
                    }
                    break;
                    
                case 5:
                    System.out.println("Продать товар");
                    histories.add(addHistory());
                    keeper.saveHistories(histories);
                    break;
                    
                case 6:
                    System.out.println("Доход магазина за все время работы");
                    break;
                    
                case 7:
                    System.out.println("Пополнить счет покупателю");
                    System.out.print("Введите номер покупателя ");
                    for (int i = 0; i < customers.size(); i++) {
                        if (customers.get(i)!=null){
                           System.out.println(customers.get(i).toString()); 
                        }
                    }
 
                    int customerNumber = scanner.nextInt(); scanner.nextLine();

                    System.out.println("Введите сумму денег, которую хотите добавить: ");
                    double moneyAdd = scanner.nextDouble(); scanner.nextLine();
                    customers.get(customerNumber-1).setMoney(customers.get(customerNumber-1).getMoney()+ moneyAdd);
                    keeper.saveCustomers(customers);;
                                break;    

            }
        }while("y".equals(repeat));
    }
    
   
    
    private History addHistory(){
        History history = new History();
       
        
        System.out.println("Список товаров:");
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i)!=null){
                System.out.printf("%d. %s%n", (i+1), products.get(i).toString()); 
            }
        }
        System.out.print("Номер товара: ");
        int productNumber = scanner.nextInt(); scanner.nextLine();
        history.setProduct(products.get(productNumber-1));
        
        System.out.println("Список покупателей");
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i)!=null){
                System.out.printf("%d. %s%n", (i+1), customers.get(i).toString()); 
            }
        }
        System.out.print("Номер покупателя: ");
        int customerNumber = scanner.nextInt(); scanner.nextLine();
        history.setCustomer(customers.get(customerNumber-1));
        
   
      
        
        
        double moneyAdd = scanner.nextDobule(); scanner.nextLine();
                    customers.get(customerNumber-1).setMoney(customers.get(customerNumber-1).getMoney()+ moneyAdd);
                    keeper.saveCustomers(customers);;
                                break;    
        return history;
    }
        

    
    private Product addProduct(){
        Product product = new Product();
        System.out.print("Название товара: ");
        product.setProductName(scanner.nextLine());
        System.out.print("Цена товара: ");
        product.setPrice(scanner.nextInt());
        scanner.nextLine();
        return product; 

    }
            
    private Customer addCustomer(){
    
        Customer customer = new Customer();
        System.out.print("Имя покупателя: ");
        customer.setFname(scanner.nextLine());
        System.out.println("Фамилия покупателя: ");
        customer.setLname(scanner.nextLine());
        System.out.println("Количество денег на счету: ");
        customer.setMoney(scanner.nextDouble());
        return customer;
    }
    

    
    
}