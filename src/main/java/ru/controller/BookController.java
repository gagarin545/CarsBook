package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.entity.Book;
import ru.service.Bookservice;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    Bookservice bookservice;

    @GetMapping("book")
    public ModelAndView carlist() {
        List<Book> books = bookservice.getAll();
        System.out.println("Выбрано -> " +books.size());
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
        }
        return "redirect:/book";
    }
}
