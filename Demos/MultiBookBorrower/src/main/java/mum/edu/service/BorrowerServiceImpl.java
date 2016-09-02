package mum.edu.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import mum.edu.domain.Borrower;

@Service
public class BorrowerServiceImpl implements BorrowerService {
    
    /*
     * this implementation is not thread-safe
     */
     private Map<Long,Borrower> borrowers;
    
    public BorrowerServiceImpl() {
        borrowers = new HashMap<Long,Borrower>();
        borrowers.put(1L,new Borrower(1L,"Reed Lotz",null));
        borrowers.put(2L,new Borrower(2L,"Glance Over",null));
     }

 
    @Override
    public Map<Long,Borrower> getAllBorrowers() {
        return borrowers;
    }

    @Override
    public Borrower save(Borrower borrower) {
         borrowers.put(borrower.getId(),borrower);
        return borrower;
    }
    
    @Override
    public Borrower update(Borrower borrower) {
               	borrowers.put(borrower.getId(), borrower);
                return borrower;
 
    }

  
    @Override
    public Borrower get(Long id) {
       return borrowers.get(id);
    }

  }
