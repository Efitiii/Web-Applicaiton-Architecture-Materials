package mum.edu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.domain.Book;
import mum.edu.domain.Borrower;
import mum.edu.service.BookService;
import mum.edu.service.BorrowerService;

@Controller
@SessionAttributes(value={"books", "borrowerBooks" })
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = {"/","/borrowerList"}, method = RequestMethod.GET)
    public String listBorrowers(Model model) {
 
        Map<Long,Borrower> borrowers = borrowerService.getAllBorrowers();
        model.addAttribute("borrowers", borrowers);
 
        Map<Long,Book> books = bookService.getAllBooks();
        List<Book> bookList = new ArrayList<Book>(books.values());
        model.addAttribute("books", bookList);

        return "BorrowerList";
    }


     @RequestMapping(value = "/borrowBooks", method = RequestMethod.GET)
    public String borrowBooks(@ModelAttribute("borrower") Borrower borrower , @RequestParam("borrower") long id,Model model) {

    	 Borrower borrowerData = borrowerService.get(id);
         model.addAttribute("borrower",borrowerData);
 
         model.addAttribute("borrowerBooks",borrowerData.getBooks());
               
         return "BorrowBookForm";
    }

    @RequestMapping(value = "/borrowBooks", method = RequestMethod.POST)
    public String updateBorrower(@ModelAttribute("borrower") Borrower borrower ,RedirectAttributes redirectAttributes) {
    	// Books have been "fetched" in the formatter
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