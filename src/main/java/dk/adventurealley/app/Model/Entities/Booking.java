package dk.adventurealley.app.Model.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


public class Booking {

  private Integer id;
  private Activity activity;
  private Customer customer;

  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private LocalDateTime date;
  private String Description;
  private int numOfParticipants;

  public Booking(Integer id, Activity activity,
      Customer customer, LocalDateTime date, String description, int numOfParticipants) {
    this.id = id;
    this.activity = activity;
    this.customer = customer;
    this.date = date;
    Description = description;
    this.numOfParticipants = numOfParticipants;
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

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getDescription() {
    return Description;
  }

  public void setDescription(String description) {
    Description = description;
  }

  public int getNumOfParticipants() {
    return numOfParticipants;
  }

  public void setNumOfParticipants(int numOfParticipants) {
    this.numOfParticipants = numOfParticipants;
  }
}
