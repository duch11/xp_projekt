package dk.adventurealley.app.Model.Entities;

public class Customer {

  private Integer id;
  private String companyName;
  private String CustomerName;
  private String phone;

  public Customer() {
  }

  public Customer(Integer id, String customerName, String phone) {
    this.id = id;
    CustomerName = customerName;
    this.phone = phone;
  }

  public Customer(Integer id, String companyName, String customerName, String phone) {
    this.id = id;
    this.companyName = companyName;
    CustomerName = customerName;
    this.phone = phone;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", companyName='" + companyName + '\'' +
            ", CustomerName='" + CustomerName + '\'' +
            ", phone='" + phone + '\'' +
            '}';
  }
}
