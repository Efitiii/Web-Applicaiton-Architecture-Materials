package mum.edu.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import mum.edu.domain.Book;
import mum.edu.domain.Category;

@Service
public class BookServiceImpl implements BookService {
    
    /*
     * this implementation is not thread-safe
     */
    private Map<Long,Category> categories;
    private Map<Long,Book> books;
    private Long nextId = 1L;
    
    public BookServiceImpl() {
         Category travelCategory = new Category(2L, "Travel");
        Category healthCategory = new Category(3L, "Health");
         
        books = new HashMap<Long,Book>();
        books.put(nextId,new Book(nextId++, "9780980839623", 
                "Growing Fruit", 
                healthCategory, "Harry Baker"));
        books.put(nextId,new Book(nextId++, "9780980839631", 
                "See Exotic Batavia", 
                travelCategory, "Will Gough"));
         books.put(nextId,new Book(nextId++, "9780980839632", 
                "Downtown Albia", 
                travelCategory, "Ben Thair"));
        books.put(nextId,new Book(nextId++, "9780980839630",
                "A walk in the Woods",
                travelCategory, "Bill Bryson"));
    }

 
    @Override
    public Map<Long,Book> getAllBooks() {
        return books;
    }

    @Override
    public Book save(Book book) {
        book.setId(nextId++);
        books.put(book.getId(),book);
        return book;
    }

    @Override
    public Book get(Long id) {
  
        return books.get(id);
    }
    
    @Override
    public Book update(Book book) {
                 books.put(book.getId(), book);
                return book;
    }
    
 }
