package ru;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.entity.Book;
import ru.service.Bookservice;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarTest {
    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;
    @Resource
    private Bookservice bookservice;
    @Before
    public void setUp() throws Exception {        em = emf.createEntityManager();    }

    @Test
    public void  test() {
        Book book = new Book();
        book.setCarNum("Т002ОУ");
        book.setCarYear(2013);
        book.setCarModel("BMW-M1");
        book.setCarColor("белый");
        bookservice.saveCar(book);
        List<Book> carList = bookservice.getAll();
        carList.forEach(x-> System.out.println(x.getCarNum()));
    }
}
