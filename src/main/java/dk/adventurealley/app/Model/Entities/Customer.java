package dk.adventurealley.app.Model.Entities;

public class Customer {

  private String companyName;
  private String CustomerName;
  private String phone;

  public Customer(String customerName, String phone) {
    CustomerName = customerName;
    this.phone = phone;
  }

  public Customer(String companyName, String customerName, String phone) {
    this.companyName = companyName;
    CustomerName = customerName;
    this.phone = phone;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getCustomerName() {
    return CustomerName;
  }

  public void setCustomerName(String customerName) {
    CustomerName = customerName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
