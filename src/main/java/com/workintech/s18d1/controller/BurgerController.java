package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/burger")
public class BurgerController {
    private BurgerDao burgerDao;
    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }
    @GetMapping
    public List<Burger> findAll(){
        return burgerDao.findAll();
    }
    @GetMapping("/{id}")
    public Burger findById(@PathVariable Long id){
       BurgerValidation.checkId(id);
       Burger burger = burgerDao.findById(id);
       return burger;
    }
    @PostMapping
    public Burger saveBurger(@RequestBody Burger burger){
        return burgerDao.save(burger);
    }
    @PutMapping
    public Burger updateBurger(@RequestBody Burger burger){
        return burgerDao.update(burger);
    }
    @DeleteMapping("/{id}")
    public Burger deleteBurger(@PathVariable Long id){
        BurgerValidation.checkId(id);
        return burgerDao.remove(id);
    }
    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable Double price){
        List<Burger> burgers = burgerDao.findByPrice(price);
        return burgers;
    }
    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBread(@PathVariable String breadType){
        BreadType bt = BreadType.valueOf(breadType);
        return burgerDao.findByBreadType(bt);
    }
    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content){
        List<Burger> burgers = burgerDao.findByContent(content);
        return burgers;
    }
}
