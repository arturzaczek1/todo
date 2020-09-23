package pl.arturzaczek.api_demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturzaczek.api_demo.entities.TaskEntity;
import pl.arturzaczek.api_demo.repositories.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    TaskRepository taskRepository;
    @Autowired
    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    Logger logger = LoggerFactory.getLogger(TaskController.class);


    @GetMapping("/all")
    public List<TaskEntity> getTaskList(){
//        System.out.println("getTaskList ()");
        logger.error("getTaskList ()", "test-error");
        List<TaskEntity> taskList = taskRepository.findAll();
        return taskList;
    }
    @GetMapping("/add")
    public void addTask(){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setContent("dudpa");
        taskEntity.setInsertDate(LocalDateTime.now());
        taskEntity.setTitle("first");
        logger.info("addTask() invoked ", taskEntity);
//        System.out.println("addTask() " + taskEntity);
        taskRepository.save(taskEntity);
    }

}
