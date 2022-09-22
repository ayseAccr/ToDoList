package com.example.demo.Controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Task;
import com.example.demo.Repositories.TaskRepo;

import java.time.Instant;

import java.util.Optional;

import javax.validation.Valid;



@Controller
//@RequestMapping(path = "/todo")
public class TasksController {
    private final Logger logger =LoggerFactory.getLogger(TasksController.class);
    @Autowired
    private TaskRepo taskRepo;
    
    @GetMapping("/")
    public ModelAndView index(){
        logger.debug("request to get index");
        ModelAndView modelAndView =new ModelAndView("index");
        modelAndView.addObject("AllTasks", taskRepo.findAll());
        return modelAndView;
    }
    @PostMapping("/taskss")
    public String createTask(@Valid Task task,BindingResult result,Model model){
        if(result.hasErrors()){
            
            return "task";
        }
        task.setCreatedDate(Instant.now());
        task.setModifiedDate(Instant.now());
        taskRepo.save(task);
        return "redirect:/";
    }
    @PostMapping("task/{id}")
    public String updateTask(@PathVariable("id")Long id,@Valid Task task,BindingResult result,Model model){
        if(result.hasErrors()){
            task.setId(id);
            return "update-task";
        }
        task.setModifiedDate(Instant.now());
        taskRepo.save(task);
        return "redirect:/";
    }


    //searchBar

}
