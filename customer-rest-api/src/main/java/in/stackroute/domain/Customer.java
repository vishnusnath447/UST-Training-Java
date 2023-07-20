package in.stackroute.domain;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private int customerId;
    private String customerName;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street",column = @Column(name = "home_street")),
            @AttributeOverride(name = "city",column = @Column(name = "home_city")),
            @AttributeOverride(name = "state",column = @Column(name = "home_state")),
            @AttributeOverride(name = "country",column = @Column(name = "home_country"))
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street",column = @Column(name = "work_street")),
            @AttributeOverride(name = "city",column = @Column(name = "work_city")),
            @AttributeOverride(name = "state",column = @Column(name = "work_state")),
            @AttributeOverride(name = "country",column = @Column(name = "work_country"))
    })
    private  Address workAddress;

    public Customer(){}

    public Customer(int customerId, String customerName, Address homeAddress, Address workAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }
}
