package se.kth.iv1350.pos.model;

/**
 * LÄGG DENNA I UTIL?
 */
public class Amount {
    private double amount;
    public Amount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount other = (Amount) o;
        return amount == other.amount;
    }

}
