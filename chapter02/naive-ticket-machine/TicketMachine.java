/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
class TicketMachine {
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine(int price) {
        this.price = price;
        balance = 0;
        total = 0;
    }

    public TicketMachine() {
        price = 1000;
        balance = 0;
        total = 0;
    }

    /**
     * Return the price of a ticket.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Return the total accumulated by the machine.
     */
    public int getTotal() {
        return total;
    }

    /**
     * Receive an amount of money from a customer.
     */
    public void insertMoney(int amount) {
        assert amount >= 0 : "No puede ingresar dinero negativo";
        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Use a positive amount rather than: " + amount);
        }
    }

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket() {
        if (balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the balance.
            total = total + balance;
            // Clear the balance.
            balance = balance - price;

        } else {
            System.out.println("You must insert at least: " + (price - balance) + " more cents.");
        }
    }

    /*
     * Ejercicio 2.37
     */

    public void prompt() {
        System.out.println("Please insert the correct amount of money.");
    }

    /*
     * Ejercicio 2.41
     */
    public void showPrice() {
        System.out.println("The price of a ticket is " + this.price + " cents.");
    }

    // Ejercicio 2.45
    public void empty() {
        this.total = 0;
    }
}
