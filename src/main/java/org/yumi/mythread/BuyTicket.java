package org.yumi.mythread;

import java.util.concurrent.atomic.AtomicReference;

public class BuyTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        AtomicReference<Integer> ticketBoughtTotal = new AtomicReference<>(0);
        new Thread(() -> {
            while (ticket.ticketNum > 0) {
                ticket.ticketNum--;
                ticketBoughtTotal.getAndSet(ticketBoughtTotal.get() + 1);
                System.out.println("The thread 1 has bought the ticket, the ticket number is " + ticket.ticketNum);
            }
        }).start();
        new Thread(() -> {
            while (ticket.ticketNum > 0) {
                ticket.ticketNum--;
                System.out.println("The thread 2 has bought the ticket, the ticket number is " + ticket.ticketNum);
            }
        }).start();

        new Thread(() -> {
            while (ticket.ticketNum > 0) {
                ticket.ticketNum--;
                System.out.println("The thread 3 has bought the ticket, the ticket number is " + ticket.ticketNum);
            }
        }).start();
        System.out.println("Hello World in main");
        System.out.println("The total number of tickets bought is " + ticketBoughtTotal.get());
    }
}
