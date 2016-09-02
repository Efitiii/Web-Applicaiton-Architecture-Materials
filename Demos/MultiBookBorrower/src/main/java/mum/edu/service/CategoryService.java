package mum.edu.service;

import java.util.List;
import java.util.Map;

import mum.edu.domain.Book;
import mum.edu.domain.Category;

public interface CategoryService {
    
    Map<Long,Category> getAll();
    Category getOne(Long id);
 }
