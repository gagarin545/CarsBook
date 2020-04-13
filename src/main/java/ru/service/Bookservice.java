package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.Book;
import ru.repository.CarsBookRepository;

import java.util.List;
@Service
public class Bookservice {
    @Autowired
    CarsBookRepository carsBookRepository;
    public List<Book> getAll() { return carsBookRepository.findAll();}
    public void saveCar(Book book) { carsBookRepository.saveAndFlush(book); }
    public Book getCar(String carNum) { return carsBookRepository.findByName( carNum); }
    public void deleteCar(Integer id) {  carsBookRepository.deleteById(Long.valueOf(id)); }
}
