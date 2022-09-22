package com.example.demo.Repositories;



import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Task;

public interface TaskRepo extends CrudRepository<Task,Long>{
   
}

