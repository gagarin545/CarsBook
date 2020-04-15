package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.entity.Book;
import ru.service.Bookservice;

import java.util.*;

@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    Bookservice bookservice;
    List<Book> books;

    @GetMapping("book")
    public ModelAndView carlist() {
        books = bookservice.getAll();
        System.out.println("Выбрано -> " +books.size());
      //  sortList(books);
        return new ModelAndView("CarList", "cars", books);
    }
    @GetMapping("book/carNum")
    public ModelAndView carNumSort() {
        if(books != null && books.size() > 1 ) {
            System.out.println("Выбрано -> " + books.size());
            Collections.sort(books, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getCarNum().compareTo(o2.getCarNum());
                }
            });
        }
        return new ModelAndView("CarList", "cars", books);
    }
    @GetMapping("book/carColor")
    public ModelAndView carColorSort() {
        if(books != null && books.size() > 1 ) {
            System.out.println("Выбрано -> " + books.size());
            Collections.sort(books, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getCarColor().compareTo(o2.getCarColor());
                }
            });
        }
        return new ModelAndView("CarList", "cars", books);
    }
    @GetMapping("book/carYear")
    public ModelAndView carYearSort() {
        if(books != null && books.size() > 1 ) {
            System.out.println("Выбрано -> " + books.size());
            Collections.sort(books, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getCarYear().compareTo(o2.getCarYear());
                }
            });
        }
        return new ModelAndView("CarList", "cars", books);
    }
    @GetMapping("book/carModel")
    public ModelAndView carModelSort() {
        if(books != null && books.size() > 1 ) {
            System.out.println("Выбрано -> " + books.size());
            Collections.sort(books, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getCarModel().compareTo(o2.getCarModel());
                }
            });
        }
        return new ModelAndView("CarList", "cars", books);
    }
    @GetMapping("CarForm")
    public ModelAndView view() {
        Book book = new Book();
        System.out.println("carForm -> " );
        return new ModelAndView("CarForm", "car", book);
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        bookservice.deleteCar( id);
        return "redirect:/book";
    }

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
       return "redirect:/CarForm";
    }

    private void sortList(List<Book> list) {
        Collections.sort(list, Collections.reverseOrder());
        list.forEach(x-> System.out.println(x.getCarNum()));
    }
}
