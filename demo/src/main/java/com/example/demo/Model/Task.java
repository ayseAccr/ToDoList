package com.example.demo.Model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Getter
    // @Setter
    private Long id;

   
    
    private  String description;

    
    private  boolean completed;


    private  Instant createdDate;

   
    private  Instant modifiedDate; 

    public Task(){}
    public Task( String description) {
        
        this.description = description;
        this.completed = false;
        this.createdDate=Instant.now();
        this.modifiedDate = Instant.now();;
    }
    @Override
    public String toString(){
             return String.format("Tasks{id=%d, description=%s, completed=%s,important=%s,CreatedDate=%s,modifiedDate=%s}"+
            id, description, completed,createdDate, modifiedDate);
          }
        




    
}
