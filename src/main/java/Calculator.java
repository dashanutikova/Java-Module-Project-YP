import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);

    public void addCostToTheOrder(ArrayList<Position> listOfOrder, String positionName) {
        System.out.println("Укажите стоимость товара");

        while (true) {
            try {
                double cost = scanner.nextDouble();

                if (cost < 0) {
                    System.out.println("Цена не может быть отрицательной! Попробуйте еще раз");
                    continue;
                }
                listOfOrder.add(new Position(cost, positionName));
                System.out.println("Товар " + positionName + " стоимостью " + cost + " добавлен в калькулятор. Нужно ли добавить еще? Если нет, введите Завершить");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Стоимость должна быть в формате рубли.копейки, например 10.45 или 11.40. Попробуйте еще");
                scanner.next();
            }
        }
    }
}

