package com.example.zemzemithouraya.Controllers;

import com.example.zemzemithouraya.Entities.Project;
import com.example.zemzemithouraya.Entities.Sprint;
import com.example.zemzemithouraya.Entities.User;
import com.example.zemzemithouraya.Services.Interfaces.ProjectInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectInterface projectInterface ;

    @PostMapping("/addProject")
    public ResponseEntity<Project> addUser(@RequestBody Project project){

        Project addedProject= projectInterface.addProject(project);

        return ResponseEntity.ok(addedProject);
    }

    @GetMapping("/getAllCurrentProjects")
    public ResponseEntity<List<Project>> getAllCurrentProjects(){
        return ResponseEntity.ok(projectInterface.getAllCurrentProject());
    }

    @GetMapping("/getAllByScrumMaster/{fName}/{lName}")
    public ResponseEntity<List<Project>> getAllByScrumMaster(@PathVariable String fName, @PathVariable String lName){
        return ResponseEntity.ok(projectInterface.getProjectsByScrumMaster(fName,lName));
    }


    @PostMapping("/addSprinttoProject/{idProject}")
    public ResponseEntity<String> addAndAssignSprintToProject(@RequestBody Sprint sprint, @PathVariable int idProject)
    {
        projectInterface.addSprintAndAssignToProject(sprint,idProject);
        return ResponseEntity.ok("assigned");
    }


}
