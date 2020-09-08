package no.hvl.dat250.jpa.basicexample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name;

    @OneToMany
    private List<CreditCard> creditCards;

    public Bank(){
        creditCards = new ArrayList<CreditCard>();
    }

    public void addCreditcard(CreditCard creditCard){
        creditCards.add(creditCard);
    }

    public List<CreditCard> getCreditCards(){
        return creditCards;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }
}
