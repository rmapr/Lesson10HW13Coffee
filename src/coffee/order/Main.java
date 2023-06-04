package coffee.order;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        int clients = 15;
        List<String> listName = RandomList.getList(RandomList.CLIENTS_LIST, clients);
        for (int i = 0; i < clients; i++){
            coffeeOrderBoard.add(RandomList.client(listName));
        }
        coffeeOrderBoard.draw();
        System.out.println("Обслуговуються всі непарні");
        for (int i = 0; i <= clients; i++){
            if (i % 2 != 0) coffeeOrderBoard.deliver(i);
        }
        int numOrder = 5;
        coffeeOrderBoard.deliver(numOrder);
        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();
    }
}
