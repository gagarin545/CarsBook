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

    @PostMapping("CarForm")
    public String add(@RequestParam Map<String, String> map) {
        if( bookservice.getCar( map.get("carNum")) == null) {
            Book book = new Book();
            book.setCarNum( map.get("carNum"));
            book.setCarColor(map.get("carColor"));
            book.setCarYear(Integer.valueOf(map.get("carYear")));
            book.setCarModel(map.get("carModel"));
            bookservice.saveCar(book);
            return "redirect:/book";
        }
        return "This number already is";
    }
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
                    Collections.sort(books, new Comparator<Book>() {
                        @Override
                        public int compare(Book o1, Book o2) {
                            return o1.getCarNum().compareTo(o2.getCarNum());
                        }
                    });
                    break;
                case "2":
                    Collections.sort(books, new Comparator<Book>() {
                        @Override
                        public int compare(Book o1, Book o2) {
                            return o1.getCarModel().compareTo(o2.getCarModel());
                        }
                    });
                    break;
                case "3":
                    Collections.sort(books, new Comparator<Book>() {
                        @Override
                        public int compare(Book o1, Book o2) {
                            return o1.getCarColor().compareTo(o2.getCarColor());
                        }
                    });
                    break;
                case "4":
                    Collections.sort(books, new Comparator<Book>() {
                        @Override
                        public int compare(Book o1, Book o2) {
                            return o1.getCarYear().compareTo(o2.getCarYear());
                        }
                    });
            }
        }
        return books;
    }
}
