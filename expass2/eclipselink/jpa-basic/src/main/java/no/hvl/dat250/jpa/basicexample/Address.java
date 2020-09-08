package no.hvl.dat250.jpa.basicexample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private static String street;
    private static int number;

    @ManyToMany
    private List<Person> persons;

    public Address() {
        persons = new ArrayList<Person>();
    }

    public void addPerson(Person person){
        persons.add(person);
    }

    public List<Person> getPersons(){
        return persons;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

}
