package com.xm.controller;

import com.xm.pojo.Category;
import com.xm.pojo.PageResult;
import com.xm.pojo.Product;
import com.xm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @ResponseBody
    @GetMapping("/CategoryFindAll")
    public PageResult<List<Category>> CategoryFindAll() {
        List<Category> categories = categoryService.CategoryFindAll(null);
        PageResult<List<Category>> listPageResult = new PageResult<List<Category>>("", categories, 0, 0);
        return listPageResult;
    }

    @ResponseBody
    @GetMapping("/CategoryFindAll2")
    public List<Category> CategoryFindAll2() {
        List<Category> categories = categoryService.CategoryFindAll(null);
        return categories;
    }

    //查询一级分类下的分类
    @ResponseBody
    @PostMapping("/CategoryByID")
    public int CategoryByID(Integer id) {
        Category category = new Category();
        category.setParent_id(id);
        if (categoryService.CategoryFindAll(category).size() != 0) {
            return 1;
        }
        return 0;
    }


    //查询一级分类
    @ResponseBody
    @GetMapping("/CategoryParFindAll")
    public List<Category> CategoryParFindAll() {
        List<Category> categories = categoryService.CategoryParFindAll(0);
        return categories;
    }

    @ResponseBody
    @PostMapping("/AddCategory")
    public int AddCategory(Category category) {
        category.setCategory_id(null);
        boolean ro = categoryService.save(category);
        if (ro) {
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @PostMapping("/UpdateCategory")
    public int UpdateCategory(Category category) {
        int ro = categoryService.UpdateCategory(category);
        if (ro > 0) {
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @PostMapping("/DeleteCategory")
    public int DeleteCategory(Integer id) {
        int ro = categoryService.DeleteCategory(id);
        if (ro > 0) {
            return 1;
        }
        return 0;
    }
}
