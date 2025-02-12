package org.onboard.collections.cashboxqueue;

import lombok.Data;
import lombok.Setter;

import java.util.Deque;
import java.util.LinkedList;

@Data
public class CashBox {
    private Deque<Buyer> queue;
    @Setter
    private State state;


    public CashBox(State state) {
        this.state = state;
        this.queue = new LinkedList<>();
    }

    public Deque<Buyer> getQueue() {
        return new LinkedList<>(queue);
    }

    public Buyer serveBuyer() {
        if (queue.isEmpty()) return null;

        Buyer served = queue.pollFirst();
        if (state == State.IS_CLOSING && queue.isEmpty()) {
            state = State.DISABLED;
        }
        return served;
    }

    // Checks if the cashbox is in the specified state
    public boolean inState(State state) {
        return this.state == state;
    }

    // Checks if the cashbox is not in the specified state
    public boolean notInState(State state) {
        return this.state != state;
    }

    // Adds a buyer to the end of the queue
    public void addLast(Buyer buyer) {
        if (buyer == null) throw new NullPointerException("Buyer cannot be null");
        queue.addLast(buyer);
    }

    // Removes and returns a buyer from the end of the queue
    public Buyer removeLast() {
        if (queue.isEmpty()) return null;
        return queue.pollLast();
    }

    /*// Returns a string representation of the cashbox and its queue
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(state == State.ENABLED ? "+" : (state == State.IS_CLOSING ? "|" : "-")).append(" ");
        for (Buyer buyer : queue) {
            sb.append(buyer.getName());
        }
        return sb.toString();
    }*/

}
