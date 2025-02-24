package dev.alm.Challenge;


import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ShoeWarehouse {

    private List<Order> orders;

    private final ExecutorService fulfillmentService;

    public ShoeWarehouse() {
        this.orders = new ArrayList<>();
        fulfillmentService = Executors.newFixedThreadPool(3);
    }
    public void shutDown() {
        fulfillmentService.shutdown();
    }

    public synchronized void receiveOrder(Order item) {

        while (orders.size() > 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        orders.add(item);
        System.out.println(Thread.currentThread().getName() + " Incoming: " + item);
        fulfillmentService.submit(this::fulfillOrder);
        notifyAll();
    }

    public synchronized Order fulfillOrder() {

        while (orders.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Order item = orders.remove(0);
        System.out.println(Thread.currentThread().getName() + " Fulfilled: " + item);
        notifyAll();
        return item;
    }
}

enum ShoeType {
    DRESS_SHOE, WALKING_SHOE, REGULAR_SHOE
}
record Order(String id, ShoeType shoeType, int quantity ) {
    Order(String id, ShoeType shoeType, int quantity) {
        this.id = "00" + id;
        this.shoeType = shoeType;
        this.quantity = quantity;
    }
}



public class Main {
    private static final Random rand = new Random();
    public static void main(String[] args) {

        ShoeWarehouse shoeWarehouse = new ShoeWarehouse();

        //        Thread producerThread = new Thread(() -> {
//           for (int i = 0; i < 10; i++) {
//               shoeWarehouse.receiveOrder(new Order(
//                       String.valueOf(rand.nextInt(0, 100)),
//                       ShoeType.values()[rand.nextInt(0, 2)],
//                       rand.nextInt(0,5)));
//           }
//        });
//        producerThread.start();

        ExecutorService orderingService = Executors.newCachedThreadPool();

        Callable<Order> orderingTask = () -> {
            {
                Order newOrder = generateOrder();
                try {
                    Thread.sleep(rand.nextInt(500, 5000));
                    shoeWarehouse.receiveOrder(newOrder);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return newOrder;
            }
        };

        try {
            for (int j = 0; j < 15; j++) {
                Thread.sleep(rand.nextInt(500, 2000));
                orderingService.submit(() -> shoeWarehouse.receiveOrder(generateOrder()));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        orderingService.shutdown();
        try {
            orderingService.awaitTermination(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shoeWarehouse.shutDown();
    }
    private static Order generateOrder() {
        return new Order(
                       String.valueOf(rand.nextInt(0, 100)),
                       ShoeType.values()[rand.nextInt(0, 2)],
                       rand.nextInt(1,5)
        );
    }

}

