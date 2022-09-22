package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Task;
import com.example.demo.Repositories.TaskRepo;
@Component
public class TasksDataLoader implements CommandLineRunner {
    private final Logger logger =LoggerFactory.getLogger(TasksDataLoader.class);
    @Autowired
    TaskRepo taskRepo;
    
    @Override
    public void run (String... args) throws Exception{
        loadSeedData();
    }
    private void loadSeedData(){

        if(taskRepo.count()==0){
            Task task1=new Task("get the milk");
            Task task2=new Task("go to gym");
            taskRepo.save(task1);
            taskRepo.save(task2);

        }
        logger.info("Number of tasks: {}",taskRepo.count());
    }


}
