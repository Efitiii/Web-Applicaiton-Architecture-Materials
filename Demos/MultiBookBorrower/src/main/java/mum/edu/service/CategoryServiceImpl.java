package mum.edu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import mum.edu.domain.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    /*
     * this implementation is not thread-safe
     */
    private Map<Long,Category> categories;
     
    public CategoryServiceImpl() {
        categories = new HashMap<Long,Category>();
        Category computingCategory = new Category(1L, "Computing");
        Category travelCategory = new Category(2L, "Travel");
        Category healthCategory = new Category(3L, "Health");
        categories.put(1L,computingCategory);
        categories.put(2L,travelCategory);
        categories.put(3L,healthCategory);
      
     }

    @Override
    public Map<Long,Category> getAll() {
        return categories;
    }
    
    @Override
    public Category getOne(Long id) {
                 return categories.get(id);

    }

  }
