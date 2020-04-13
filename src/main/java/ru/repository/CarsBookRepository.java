package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.Book;

public interface CarsBookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b where b.carNum = :carNum")
    Book findByName(@Param("carNum") String carNum);
}
