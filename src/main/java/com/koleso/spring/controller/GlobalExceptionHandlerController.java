package com.koleso.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    // Обработчик 404 Not Found
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNotFound404(HttpServletRequest request, NoHandlerFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("error/404"); // путь к кастомной странице
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        modelAndView.addObject("message", "Куда-то не туда: " + request.getRequestURI());
        return modelAndView;
    }

    // Обработчик 403 Forbidden (доступ запрещён)
    @ExceptionHandler(SecurityException.class)
    public ModelAndView handleAccessDenied403(HttpServletRequest request, SecurityException ex) {
        ModelAndView modelAndView = new ModelAndView("error/403");
        modelAndView.setStatus(HttpStatus.FORBIDDEN);
        modelAndView.addObject("message", "Тебе сюды нельзиа: " + request.getRequestURI());
        return modelAndView;
    }

    //Универсальный обработчик
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGlobalError(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error/otherError");
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        modelAndView.addObject("message", "Универсальная ошибка: " + ex.getMessage());
        return modelAndView;
    }

//    // Обработчик
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handle(HttpServletRequest request, Exception ex) {
//        ModelAndView modelAndView = new ModelAndView("error/otherError"); // путь к кастомной странице
//        modelAndView.setStatus(HttpStatus.NOT_FOUND);
//        modelAndView.addObject("message", "что-то пошло не так!!!!!!!: " + request.getRequestURI());
//        return modelAndView;
//    }

}
