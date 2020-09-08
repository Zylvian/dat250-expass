package no.hvl.dat250.jpa.basicexample;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private int number;
    private int limit;
    private int balance;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Bank bank;

    @Embedded
    private Pincode pincode;

    public CreditCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }
}