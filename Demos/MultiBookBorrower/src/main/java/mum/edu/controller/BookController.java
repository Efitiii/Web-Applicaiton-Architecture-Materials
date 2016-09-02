package mum.edu.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.domain.Book;
import mum.edu.domain.Category;
import mum.edu.service.BookService;
import mum.edu.service.CategoryService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/bookList"})
    public String listBooks(Model model) {
 
        Map<Long,Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
 
        return "BookList";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String inputBook(@ModelAttribute("book") Book book, Model model) {
        Map<Long,Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
         return "BookAddForm";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book , RedirectAttributes redirectAttributes) {
        Category category = categoryService.getOne(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        
        redirectAttributes.addFlashAttribute(book);
        
        return "redirect:/bookDetails";
    }

    
    @RequestMapping("/bookDetails")
    public String bookDetails(SessionStatus status) {
    	
    	status.setComplete();
  
    	return "BookDetails";
    }


 }