package br.com.otta.numbersconverter;

import java.io.Console;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.otta.numbersconverter.model.Numbers;
import br.com.otta.numbersconverter.service.ConverterService;

@SpringBootApplication
public class NumbersConverterApplication implements CommandLineRunner {
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
            System.out.println("Entre com o valor arábico para ser convertido: ");
            String value = scanner.nextLine();
            //Integer arabic = Integer.valueOf(value);

            //String result = service.convertToRoman(arabic);
            int result = service.convertToArabic(value);
            /*StringBuilder resultBuilder = new StringBuilder();
            List<Numbers> reversedNumbers = Numbers.reverse();
            int index = 0;
            while((reversedNumbers.size() > index) && (arabic > 0)) {
                Numbers selectedNumber = reversedNumbers.get(index);

                if (selectedNumber.getArabicValue() <= arabic) {
                    resultBuilder.append(selectedNumber.getRomanValue());
                    arabic -= selectedNumber.getArabicValue();
                } else {
                    index++;
                }
            }*/

            System.out.println(result);
        }
    }

}
