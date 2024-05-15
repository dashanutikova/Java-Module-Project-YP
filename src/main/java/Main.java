import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Position> listOfOrders = new ArrayList();
        Calculator calculator = new Calculator();
        RubleFormatter formatter = new RubleFormatter();

        while (true) {
            System.out.println("На сколько человек будем делить счет?");
            try {
                int guestCount = scanner.nextInt();
                if (guestCount == 1)
                    System.out.println("Нет необходимости делить счет для одного гостя. Попробуйте еще раз.");
                else if (guestCount < 1)
                    System.out.println("Количество гостей должно быть больше 1. Попробуйте еще раз.");
                else {
                    System.out.println("Количество гостей получено");

                    while (true) {
                        System.out.println("Введите товар");
                        String positionName = scanner.next();
                        if (positionName.equalsIgnoreCase("Завершить")) {
                            double totalCost = 0.0;
                            ArrayList<String> totalName = new ArrayList<>();

                            for (Position position : listOfOrders) {
                                totalCost += position.cost;
                                totalName.add(position.name);
                            }

                            double payment = totalCost / guestCount;

                            System.out.println("Общая сумма в заказе: " + totalCost);
                            System.out.println("Добавленные товары: \n" + String.join(System.lineSeparator(), totalName));
                            System.out.println("Каждый человек должен заплатить по " + formatter.formatterPayment(payment) + " " + formatter.rubleFormatter(payment));
                            break;
                        }

                        calculator.addCostToTheOrder(scanner, listOfOrders, positionName);
                    }
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Нужно ввести число!");
                scanner.next();
            }
        }
    }
}