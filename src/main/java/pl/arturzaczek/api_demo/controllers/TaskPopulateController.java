package pl.arturzaczek.api_demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.arturzaczek.api_demo.entities.TaskEntity;
import pl.arturzaczek.api_demo.repositories.TaskRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskPopulateController {

    Logger logger = LoggerFactory.getLogger(TaskPopulateController.class);

    TaskRepository taskRepository;


    @Autowired
    public TaskPopulateController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/populateTable")
    public Boolean populateTable() {
        ArrayList<TaskEntity> taskList = new ArrayList<>();
        taskList.add(new TaskEntity("Pierwszy task wygenerowany w klasie PopulateTask", "Pierwszy", Date.valueOf("2021-03-10")));
        taskList.add(new TaskEntity("drugi task wygenerowany w klasie PopulateTask", "dugi", Date.valueOf("2020-12-10")));
        taskList.add(new TaskEntity("3 task wygenerowany w klasie PopulateTask", "trzeci", Date.valueOf("2020-11-29")));
        taskList.add(new TaskEntity("4 task wygenerowany w klasie PopulateTask", "czwarty", Date.valueOf("2020-09-30")));
        taskList.add(new TaskEntity("Piąty task wygenerowany w klasie PopulateTask", "piaty", Date.valueOf("2020-10-01")));

        logger.info("taskPopulate() invoked");
        logger.warn(taskList.toString());
        taskRepository.saveAll(taskList);

        Boolean result = true;
        return result;
    }
}
