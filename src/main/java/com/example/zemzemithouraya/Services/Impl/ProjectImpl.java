package com.example.zemzemithouraya.Services.Impl;

import com.example.zemzemithouraya.Entities.Project;
import com.example.zemzemithouraya.Entities.Sprint;
import com.example.zemzemithouraya.Entities.User;
import com.example.zemzemithouraya.Enums.Role;
import com.example.zemzemithouraya.Repositories.ProjectRepo;
import com.example.zemzemithouraya.Repositories.SprintRepo;
import com.example.zemzemithouraya.Repositories.UserRepo;
import com.example.zemzemithouraya.Services.Interfaces.ProjectInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class ProjectImpl implements ProjectInterface {
    @Autowired
    ProjectRepo projectRepo ;
    @Autowired
    UserRepo userRepo;

    @Autowired
    SprintRepo sprintRepo;

    @Override
    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public List<Project> getAllCurrentProject() {
        List<Project> projects = projectRepo.findAllBySprintsIsAfter(Date.from(Instant.now()));
        return projects;
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        List<Project> projects = null;
        List<User> users = userRepo.findUsersByRoleIs(Role.Scrum_Master) ;
        for(User user: users){
            if(user.getFName().equals(fName)&&user.getLName().equals(lName))
            {
             projects = user.getProjects();
            }
        }
        return projects;
    }

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project projet = projectRepo.findById(idProject).orElse(null);
        if(projet!=null){
            sprintRepo.save(sprint);
            sprint.setProject(projet);
        }
    }

    @Scheduled(cron ="0 0 13 * * *" )
    public List<Project>getNbrSprintByCurrentProject(){
        int nbr=0 ;
        List<Project> projects= projectRepo.findAll();
        for(Project project: projects){
            nbr=project.getSprints().size();
            System.out.println(nbr);
        }
        return projects;

    }

}
