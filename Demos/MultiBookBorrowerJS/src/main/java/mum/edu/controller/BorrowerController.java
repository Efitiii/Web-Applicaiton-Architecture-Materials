package mum.edu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

 import mum.edu.domain.Book;
import mum.edu.domain.Borrower;
import mum.edu.service.BookService;
import mum.edu.service.BorrowerService;

@Controller
@SessionAttributes(value={"books" })
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @Autowired
    private BookService bookService;

 
    @RequestMapping(value = {"/","/borrowerList"})
    public String listBorrowersPop(Model model) {
 
        Map<Long,Borrower> borrowers = borrowerService.getAllBorrowers();
        model.addAttribute("borrowers", borrowers);
 
        Map<Long,Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);

        return "BorrowerList";
    }




    @RequestMapping(value = "/borrowBooks", method = RequestMethod.GET)
   public String borrowBooksPop(@ModelAttribute("borrower") Borrower borrower , @RequestParam("borrower") long id,Model model) {
        Borrower borrowerData = borrowerService.get(id);
        model.addAttribute("borrowerData",borrowerData);
 
   	Map<Long,Book> books = (Map<Long,Book>) model.asMap().get("books");
    	
   	Map<Long,Book> notBorrowedBooks = new HashMap<Long,Book>();
   	notBorrowedBooks.putAll(books);
   			if (borrowerData.getBooks() != null)
	        for (Book book : borrowerData.getBooks() ) {
	        	if (notBorrowedBooks.get(book.getId()) != null)
	        		notBorrowedBooks.remove(book.getId());
	        }
	       
        model.addAttribute("notBorrowedBooks", notBorrowedBooks);

        return "BorrowBookForm";
   }
    
    @RequestMapping(value = "/borrowBooks", method = RequestMethod.POST)
    public String updateBorrower(@ModelAttribute("borrower") Borrower borrower , Map map,RedirectAttributes redirectAttributes) {
         
 /* NEED To implement the following to get ENTIRE Book as we only save ID & Title...
  * 
  *   	List<Book> books = (List<Book> )map.get("books");
    	List<Book> booksBorrowed = new ArrayList<Book>();
    	
    	for (Book bookBorrowed : borrower.getBooks()){
    		for (Book fullBook : books) {
    			
    		}
    	}
    	borrower.setBooks(booksBorrowed);
 */   	
    	borrowerService.update(borrower);
        
        redirectAttributes.addFlashAttribute(borrower);
        
        return "redirect:/borrowerDetails";
    }

  
    @RequestMapping("/borrowerDetails")
    public String borrowerDetails(SessionStatus status) {
    	
    	status.setComplete();
  
    	return "BorrowerDetails";
    }

 
    }