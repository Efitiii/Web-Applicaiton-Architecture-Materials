package mum.edu.service;

import java.util.Map;

import mum.edu.domain.Borrower;

public interface BorrowerService {
    
    Map<Long,Borrower> getAllBorrowers();
    Borrower save(Borrower borrower);
    Borrower get(Long id);
    Borrower update(Borrower borrower);

}
