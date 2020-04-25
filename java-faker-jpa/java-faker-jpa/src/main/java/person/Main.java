package person;

import com.github.javafaker.Faker;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.ZoneId;
import java.util.Locale;

public class Main {
    private static Faker faker = new Faker(new Locale("en"));

    public static Person randomPerson() {
        Person person = Person.builder()
                .name(faker.name().name())
                .gender(faker.options().option(Person.Gender.class))
                .dob(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .profession(faker.company().profession())
                .email(faker.internet().emailAddress())
                .address(Address.builder()
                            .country(faker.address().country())
                            .state(faker.address().state())
                            .zip(faker.address().zipCode())
                            .city(faker.address().cityName())
                            .streetAddress(faker.address().streetAddress())
                            .build()).build();
        return person;

    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager em = emf.createEntityManager();



        em.getTransaction().begin();
        for (int i = 0; i < 1000; i++)
            em.persist(randomPerson());
            em.getTransaction().commit();

        System.out.println(em.find(Person.class, Long.valueOf(500)));


        em.close();
        emf.close();
    }
}
