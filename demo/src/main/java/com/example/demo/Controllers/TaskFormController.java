package com.example.demo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.Task;
import com.example.demo.Repositories.TaskRepo;

@Controller
public class TaskFormController {
   
    private final Logger logger = LoggerFactory.getLogger(TaskFormController.class);

    @Autowired
    private TaskRepo taskRepo;
   
    @GetMapping("/create-task")
    public String showCreateForm(Task Task){
        return "add-task";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id")Long id,Model model){
        Task task =taskRepo
        .findById(id)
        .orElseThrow(()->new IllegalArgumentException("Task id:"+id+" not find"));
        model.addAttribute("task",task);
        return "update-task";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id")long id,Model model){
        Task task= taskRepo
        .findById(id)
        .orElseThrow(()->new IllegalArgumentException("Task id:"+id+" not find"));

        taskRepo.delete(task);
        return "redirect:/";
    }

    // PostMapping("/update")
    // public @ResponseBody Result updateItem(@RequestParam long id, @RequestParam String name,
    //         @RequestParam String category, @RequestParam boolean isComplete) {
    //     TodoItem item = new TodoItem(category, name);
    //     item.setId(id);
    //     item.setComplete(isComplete);
    //     TodoItem saved = repository.save(item);
    //     return new Result("Updated", saved); 
    //  }

    
}
