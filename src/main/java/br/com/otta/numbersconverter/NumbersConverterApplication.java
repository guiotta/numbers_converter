package br.com.otta.numbersconverter;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.service.ConverterService;

@SpringBootApplication
public class NumbersConverterApplication implements CommandLineRunner {
    private static final int EXIT_VALUE = 3;
    
    private final ConverterService service;

    public NumbersConverterApplication(ConverterService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(NumbersConverterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try(Scanner scanner = new Scanner(System.in)) {
            this.printMenu();
            int option = scanner.nextInt();
            while(option != EXIT_VALUE) {
                System.out.println("Escolha uma das opções: ");
                scanner.nextLine();
                String userInput = scanner.nextLine();

                ItemType selectedItem = ItemType.get(option);
                String convertedValue = service.executeConverter(selectedItem, userInput);
                System.out.println(convertedValue);

                this.printMenu();
                option = scanner.nextInt();
            }
            System.out.println("Encerrando aplicação.");
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Escolha uma das opções: ");
        System.out.println("1. Converter número romano para arábico.");
        System.out.println("2. Converter número arábico para romano. ");
        System.out.println("3. Sair");
    }

}
