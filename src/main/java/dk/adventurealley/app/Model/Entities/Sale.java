package dk.adventurealley.app.Model.Entities;

import java.time.LocalDate;

public class Sale {
    private int id;
    private LocalDate date;
    private int totalPrice;

    // Constructors
    public Sale(){
    }
    public Sale(int id, LocalDate date, int totalPrice) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    // Methods
    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
