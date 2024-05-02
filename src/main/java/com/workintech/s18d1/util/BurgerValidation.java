package com.workintech.s18d1.util;

import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void checkId(Long id) {
        if (id == null || id < 0) {
            throw new BurgerException("An error occurred", HttpStatus.BAD_REQUEST);
        }
    }

}
