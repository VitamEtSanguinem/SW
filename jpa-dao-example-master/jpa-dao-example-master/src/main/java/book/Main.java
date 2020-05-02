package book;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new PersistenceModule("jpa-dao-sw"));
        BookDao bookDao = injector.getInstance(BookDao.class);
        BookGenerator generator = new BookGenerator();

        for(int i=0; i<30; i++){
            bookDao.persist(generator.gen());

        }
        bookDao.findAll().forEach(System.out::println);
    }
}
