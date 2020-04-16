package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.entity.Book;
import ru.service.Bookservice;

import java.util.*;

@RestController
@RequestMapping("/")
public class BookRestController {
    @Autowired
    Bookservice bookservice;

    @GetMapping("stat")
    public List<Book> carStat() {
        List<Book> books = new ArrayList<>();
        books.add( bookservice.minRecord());
        books.add( bookservice.maxRecord());
        return books;
    }
    @GetMapping("sort/{id}")
    public List<Book> carSort(@PathVariable String id) {
        List<Book> books = bookservice.getAll();
        if( books != null && books.size() > 1 ) {
            switch (id){
                case "1":
                    books.sort(Comparator.comparing(Book::getCarNum));
                    break;
                case "2":
                    books.sort(Comparator.comparing(Book::getCarModel));
                    break;
                case "3":
                    books.sort(Comparator.comparing(Book::getCarColor));
                    break;
                case "4":
                    books.sort(Comparator.comparing(Book::getCarYear));
            }
        }
        return books;
    }
}
