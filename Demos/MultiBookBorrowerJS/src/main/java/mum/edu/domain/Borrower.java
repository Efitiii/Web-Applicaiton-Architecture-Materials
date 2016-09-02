package mum.edu.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

 
public class Borrower implements Serializable {
    
    private static final long serialVersionUID = 1520961851058396786L;

    private Long id;
    
    private List<Book> books;
    private String name;
    
    public Borrower() {
    }
    
    public Borrower( Long id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<Book>();
    }

     public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
