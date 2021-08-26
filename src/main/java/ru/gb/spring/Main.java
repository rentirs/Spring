package ru.gb.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(appConfiguration.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);
        Scanner scanner = new Scanner(System.in);
        int id;

        while (true) {
            System.out.println("--------------------------------\nВведите команду: 1 - добавить продукт 2 - удалить продукт 3 - репозиторий продуктов 0 - выход");
            int cmnd = scanner.nextInt();
            switch (cmnd) {
                case 0:
                    return;
                case 1:
                    System.out.println("Введите id добавляемого продукта:");
                    id = scanner.nextInt();
                    cart.add(id);
                    break;
                case 2:
                    System.out.println("Введите id удаляемого продукта:");
                    id = scanner.nextInt();
                    cart.remove(id);
                    break;
                case 3:
                    System.out.println("--------------------------------\nСписок продуктов в репозитории:");
                    productRepository.findAll().forEach(product -> System.out.println("ID:" + product.getId() + "\t" + product.getName() + "\tЦена: " +product.getPrice()));
            }
        }
    }
}
