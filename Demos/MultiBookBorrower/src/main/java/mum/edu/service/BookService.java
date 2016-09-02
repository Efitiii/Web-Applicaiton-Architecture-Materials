package mum.edu.service;

import java.util.Map;

import mum.edu.domain.Book;

public interface BookService {
    
    public Map<Long,Book> getAllBooks();
    Book save(Book book);
    Book update(Book book);
    Book get(Long id);
 
}
