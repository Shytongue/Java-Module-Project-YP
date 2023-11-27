import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String errorMessage = "Значение введено некорректно, пожалуйста, повторите ввод";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = inputPeopleCount(scanner);
        Calculator calculator = new Calculator(peopleCount);
        inputProducts(scanner, calculator);
        calculator.showProductsList();
        calculator.calculateDividedSum();
        calculator.showDividedSum();
    }
    public static int inputPeopleCount(Scanner scanner) {
        int peopleCount;
        System.out.println("Введите количество человек, на которое хотите разделить сумму: ");
        while(true) {
            try {
                peopleCount = scanner.nextInt();
                if (peopleCount <= 1) {
                    System.out.println(errorMessage);
                } else break;
            }
            catch(InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return peopleCount;
    }
    public static void inputProducts(Scanner scanner, Calculator calculator) {
        String productName;
        double productPrice;
        while(true) {
            System.out.println("Введите название товара: ");
            productName = scanner.nextLine();
            if (productName.equalsIgnoreCase("завершить")) break;
            try {
                System.out.println("Введите стоимость товара: ");
                productPrice = scanner.nextDouble();
                if (productPrice <= 0) {
                    System.out.println(errorMessage);
                    scanner.nextLine();
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            calculator.addProduct(new Product(productName, productPrice));
            System.out.println("Хотите добавить ещё один товар? Если нет, введите \"завершить\"");
        }
    }
}
