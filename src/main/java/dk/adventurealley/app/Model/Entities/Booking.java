package dk.adventurealley.app.Model.Entities;

import java.time.LocalDate;


public class Booking {

  private Integer id;
  private Activity activity;
  private Customer customer;
  private LocalDate date;
  private String description;
  private int numOfParticipants;

  public Booking(Integer id, Activity activity,
      Customer customer, LocalDate date, String description, int numOfParticipants) {
    this.id = id;
    this.activity = activity;
    this.customer = customer;
    this.date = date;
    this.description = description;
    this.numOfParticipants = numOfParticipants;
  }

  public Booking() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getNumOfParticipants() {
    return numOfParticipants;
  }

  public void setNumOfParticipants(int numOfParticipants) {
    this.numOfParticipants = numOfParticipants;
  }
}
