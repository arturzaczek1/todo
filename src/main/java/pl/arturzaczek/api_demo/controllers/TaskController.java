package pl.arturzaczek.api_demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.arturzaczek.api_demo.entities.TaskEntity;
import pl.arturzaczek.api_demo.repositories.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {

    TaskRepository taskRepository;
    Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @GetMapping("/all")
    public List<TaskEntity> getTaskList(){
        logger.info("invoked: getTaskList()");
        List<TaskEntity> taskList = taskRepository.findAll();
        return taskList;
    }

    @PostMapping("/add")
    public String addTask(@RequestBody TaskEntity taskEntity){
        taskEntity.setCreationTime(LocalDateTime.now());
        logger.debug("invoked: addTask()", taskEntity);
        logger.debug(taskEntity.toString());
        taskRepository.save(taskEntity);
        String result = "true";
        return result;
    }
    @GetMapping("/task")
    public TaskEntity getOneById(@RequestParam String idFromRequest){
        if(idFromRequest != null && !idFromRequest.isEmpty()){
            Long id = Long.parseLong(idFromRequest);
            TaskEntity taskEntity = taskRepository.getOne(id);
            logger.debug("invoked: getOneById()", idFromRequest);
            return taskEntity;
        }else
        logger.warn("ID was empty or null", idFromRequest);
        return null;
    }

    @DeleteMapping("/delete")
    public String deleteAll(){
        taskRepository.deleteAll();
        String result = "true";
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOne(@RequestParam Long id){
        taskRepository.deleteById(id);
        String result = "true";
        return result;
    }

    @PutMapping("/edit")
    public TaskEntity editTask(@RequestBody TaskEntity taskEntity){ return taskRepository.save(taskEntity);
    }

    //TODO cosider extracting variable to "result" to some class atribute, "response" which will represent jason or warning string

}
