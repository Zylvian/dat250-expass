package no.hvl.dat250.jpa.basicexample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "credit-card-model";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select p from Person p");
        List<Person> peopleList = q.getResultList();
        for (Person person : peopleList) {
            System.out.println(person);
        }
        System.out.println("Size: " + peopleList.size());

        // Example usage
        em.getTransaction().begin();

        // Make credit card
        CreditCard card = new CreditCard();
        card.setBalance(2020);
        card.setNumber(234);

        // Make card code
        Pincode code = new Pincode();
        code.setPincode("9999");
        code.setCount(111);

        // Link em
        card.setPincode(code);
        code.setCreditCard(card);

        // Make person
        Person onePerson = new Person();
        onePerson.setName("Spaghettiman");

        // Make address
        Address address = new Address();
        address.setStreet("MBG");
        address.setNumber(3);

        // Link em
        onePerson.addAddress(address);
        address.addPerson(onePerson);

        // Link person and card
        onePerson.addCreditCard(card);
        card.setPerson(onePerson);

        // Make bank (meg)
        Bank bankcity = new Bank();
        bankcity.setName("kodebanken");

        // Link bank and card
        bankcity.addCreditcard(card);
        card.setBank(bankcity);

        // Persist em all
        em.persist(onePerson);
        em.persist(address);
        em.persist(card);
        em.persist(bankcity);

        em.getTransaction().commit();

        em.close();
    }
}
