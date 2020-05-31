package se.kth.iv1350.pos.model;

/**
 * This class handles different amounts.
 */
public class Amount {
    private double amount;
    public Amount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    /**
     * This method adds this object with another specified objects amounts.
     * @param other The other object to add with.
     */
    public void add(Amount other) {
        this.amount += other.amount;
    }

    /**
     * This method multiplies the amounts of this object with another specified object.
     * @param other The other object to multiply with.
     * @return Returns the product.
     */
    public Amount multiply(Amount other) {
        return new Amount(this.amount * other.amount);
    }

    /**
     * This method subtracts the amounts of this object with another specified object.
     * @param other The other object to subtract with
     * @return Returns the subtraction.
     */
    public Amount minus(Amount other) {
        return new Amount(this.amount - other.amount);
    }

    public boolean greaterThan(Amount other) {
        return this.amount > other.amount;
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
