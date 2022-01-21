package com.proiect.cofetarie.controller;

import com.proiect.cofetarie.dto.category.CreateCakeCategoryDto;
import com.proiect.cofetarie.dto.category.UpdateCakeCategoryDto;
import com.proiect.cofetarie.exception.general.InvalidUpdateRequestException;
import com.proiect.cofetarie.mapper.CakeCategoryMapper;
import com.proiect.cofetarie.model.CakeCategory;
import com.proiect.cofetarie.service.CakeCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cake-category")
public class CakeCategoryController {
    private CakeCategoryService categoryService;
    private CakeCategoryMapper categoryMapper;

    public CakeCategoryController(CakeCategoryService categoryService, CakeCategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<CakeCategory> saveClub(
            @RequestBody @Valid CreateCakeCategoryDto category) {
        CakeCategory cakeCategory = categoryMapper.create(category);
        return ResponseEntity.ok().body(categoryService.create(cakeCategory));
    }

    @GetMapping()
    public List<CakeCategory> get(@RequestParam(required = false) String name) {
        return categoryService.get(name);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CakeCategory> update(
            @PathVariable long id,
            @Valid
            @RequestBody UpdateCakeCategoryDto request
    ) {

        if (id != request.getCakeCategoryID()) {
            throw new InvalidUpdateRequestException();
        }

        return ResponseEntity.ok(categoryService.update(categoryMapper.update(request)));
    }

    @DeleteMapping("/removed/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return ResponseEntity.ok().body(categoryService.delete(id));
    }
}
