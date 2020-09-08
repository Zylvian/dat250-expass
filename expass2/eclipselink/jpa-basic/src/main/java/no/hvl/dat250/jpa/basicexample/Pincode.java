package no.hvl.dat250.jpa.basicexample;

import javax.persistence.*;

// Embeddable to avoid persisting
@Embeddable
public class Pincode {

    private String pincode;
    private int count;

    @OneToOne
    private CreditCard creditCard;

    public Pincode(){

    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}
