package org.onboard.collections.cashboxqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<CashBox> cashboxes;

    public Shop(int numCashboxes) {
        cashboxes = new ArrayList<>(numCashboxes);
        for (int i = 0; i < numCashboxes; i++) {
            cashboxes.add(new CashBox(State.DISABLED));
        }
    }

    public void print() {
        for (int i = 0; i < cashboxes.size(); i++) {
            System.out.println("#" + i + cashboxes.get(i));
        }
    }

    // Adds a buyer to the cashbox with the smallest queue
    public void addBuyer(Buyer buyer) {
        CashBox minQueueCashBox = cashboxes.stream()
                .filter(c -> c.inState(State.ENABLED))
                .min(Comparator.comparingInt(c -> c.getQueue().size()))
                .orElseThrow(() -> new IllegalStateException("No enabled cashboxes"));

        minQueueCashBox.addLast(buyer);
    }

    // Returns a cashbox by its number
    public CashBox getCashBox(int cboxNumber) {
        return cashboxes.get(cboxNumber);
    }

    // Sets a new state for a cashbox by its number
    public void setCashBoxState(int cboxNumber, State state) {
        CashBox cashBox = cashboxes.get(cboxNumber);
        cashBox.setState(state);
    }

    // Performs one tact, serving buyers and redistributing buyers
    public void tact() {
        List<Buyer> defectorBuyers = new ArrayList<>();

        // Serve buyers from each queue and collect defectors
        for (CashBox cashBox : cashboxes) {
            if (!cashBox.getQueue().isEmpty()) {
                // Serve one buyer if the queue is not empty
                cashBox.serveBuyer();
                if (cashBox.getState() == State.IS_CLOSING && cashBox.getQueue().isEmpty()) {
                    cashBox.setState(State.DISABLED);
                }
            }
        }

        // Balance the queues by redistributing defectors
        balance(defectorBuyers);
    }

    // Redistribute defectors and balance queues
    private void balance(List<Buyer> defectorBuyers) {
        // Calculate the minimum and maximum queue sizes
        int totalBuyers = 0;
        int numEnabledCashBoxes = 0;

        for (CashBox cashBox : cashboxes) {
            if (cashBox.inState(State.ENABLED)) {
                totalBuyers += cashBox.getQueue().size();
                numEnabledCashBoxes++;
            }
        }

        int minQueueSize = totalBuyers / numEnabledCashBoxes;
        int maxQueueSize = minQueueSize + (totalBuyers % numEnabledCashBoxes);

        // Fill each queue to the balanced size
        for (CashBox cashBox : cashboxes) {
            if (cashBox.inState(State.ENABLED)) {
                int currentSize = cashBox.getQueue().size();
                int diff = currentSize - minQueueSize;
                if (diff > 0) {
                    for (int i = 0; i < diff; i++) {
                        defectorBuyers.add(cashBox.removeLast());
                    }
                }
            }
        }

        // Add buyers from defectors
        for (CashBox cashBox : cashboxes) {
            if (cashBox.inState(State.ENABLED)) {
                int currentSize = cashBox.getQueue().size();
                int targetSize = (currentSize < maxQueueSize) ? maxQueueSize : minQueueSize;

                while (cashBox.getQueue().size() < targetSize && !defectorBuyers.isEmpty()) {
                    cashBox.addLast(defectorBuyers.remove(0));
                }
            }
        }
    }
}
