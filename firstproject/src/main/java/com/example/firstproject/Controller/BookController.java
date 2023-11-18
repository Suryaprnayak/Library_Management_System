package com.example.firstproject.Controller;

import com.example.firstproject.Modules.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("Book")
public class BookController {
    public final HashMap<Integer, Book> bookMap = new HashMap<>();
    @PostMapping("/add_book")
    public String addBook(@RequestBody Book book){
        bookMap.put(book.getId(),book);
        return "Book added successfully";
    }
    @GetMapping("/get_book_by_id")
    public Book getBook(@RequestParam int id){
        return bookMap.get(id);
    }
    @GetMapping("/list_of_book")
    public List<Book> getListOfBooks(){
        return new ArrayList<>(bookMap.values());
    }
    @GetMapping("/get_book_by_name")
    public Book getBookByName(@RequestParam String name){
        for (int key : bookMap.keySet()){
            if (bookMap.get(key).getName().equals(name)){
               return bookMap.get(key);
            }
        }
        return null;
    }
    @DeleteMapping("/remove_book")
    public String removeBook(Book book){
        for (int key:bookMap.keySet()){
            bookMap.remove(key);
        }
        return "remove all book successfully";
    }
    @DeleteMapping("/remove_book_by_id")
    public String removeBookById(@RequestParam int id){
        if (bookMap.containsKey(id)) {
            bookMap.remove(id);
            return "book remove successfully";
        }
        else {
            return "book not found";
        }
    }
    @PutMapping("/update_book_name")
    public String updateBookName(@RequestParam int id,@RequestParam String name){
        Book book=bookMap.get(id);
        book.setName(name);
        bookMap.put(id,book);
        return "Book updated successfully";
    }
    @PutMapping("/update_author_name")
    public String updateAuthorName(@RequestParam int id,@RequestParam String author){
        Book book=bookMap.get(id);
        book.setAuthor(author);
        bookMap.put(id,book);
        return "Author name updated successfully";
    }
}
