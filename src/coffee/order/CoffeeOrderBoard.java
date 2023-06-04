package coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    private final LinkedList<Order> orders;

    public CoffeeOrderBoard() {
        orders = new LinkedList<>();
    }

    //3. Реалізувати метод add у класі CoffeeOrderBoard. Даний метод додає нове замовлення
//та надає замовленню номер (натуральний порядок).
//Натуральний порядок (natural ordering) означає, що й у останнього замовлення номер 86,
//то наступний буде 87.
//Не може бути такої ситуації, що номер повторюється у межах одного об'єкта типу CoffeeOrderBoard.
    public boolean add(String name) {
        Order order = new Order(name);
        return orders.add(order);
    }

    //4. Реалізувати метод deliver у класі CoffeeOrderBoard. Цей метод видає найближче у
//черзі замовлення. Видача супроводжується видаленням замовлення зі списку.
    public boolean deliver() {
        if (orders.isEmpty()) {
            System.out.println("\nСписок замовлень пустий, нікого обслуговувати.");
            return false;
        } else {
            System.out.println("\nОбслуговується перший в черзі, замовлення: " + "№ " +
                    orders.getFirst().getId() + " | " + orders.getFirst().getName() +
                    "\nЗамовлення виконано.");
            return orders.remove(orders.getFirst());
        }
    }

    //5. Реалізувати метод deliver у класі CoffeeOrderBoard. Даний метод видає замовлення
//з певним номером. Видача супроводжується видаленням замовлення зі списку.
//Даний метод обробляє ситуацію, коли замовлення, що надійшло пізніше, готове раніше.
    public boolean deliver(int idOrder) {
        for (Order ord : orders) {
            if (ord.getId() == idOrder) {
                System.out.println("\nОбслуговується замовлення: № " + ord.getId() + " на ім'я " +
                        ord.getName() + "\nЗамовлення виконано.");
                return orders.remove(ord);
            }
        }
        System.out.println("\nЗамовлення № " + idOrder + " не існує.\n");
        return false;
    }

    //6. Реалізувати метод draw у класі CoffeeOrderBoard. Цей метод виводить у консоль інформацію
//про поточний стан черги у порядку найближчого до видачі замовлення.
    public void draw() {
        System.out.println("Порядок видачі замовлень");
        System.out.printf("%s", "_________________________\n");
        System.out.printf("%-12s %s %-5s", "№ замовлення", "|", "Ім'я");
        System.out.printf("\n%s", "_________________________\n");
        for (Order order : orders) {
            System.out.printf("%-12d %s %5s", order.getId(), "|", order.getName() + "\n");
        }
        System.out.printf("%s", "_________________________\n");
    }

    @Override
    public String toString() {
        return "CoffeeOrderBoard{" +
                "orders=" + orders +
                '}';
    }
}
