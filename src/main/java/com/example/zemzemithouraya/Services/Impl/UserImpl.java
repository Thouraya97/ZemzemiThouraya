package com.example.zemzemithouraya.Services.Impl;

import com.example.zemzemithouraya.Entities.Project;
import com.example.zemzemithouraya.Entities.User;
import com.example.zemzemithouraya.Enums.Role;
import com.example.zemzemithouraya.Repositories.ProjectRepo;
import com.example.zemzemithouraya.Repositories.UserRepo;
import com.example.zemzemithouraya.Services.Interfaces.UserInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserInterface {

    final
    UserRepo userRepo ;
    final
    ProjectRepo projectRepo ;

    public UserImpl(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }


    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void assignProjectToUSer(int projectId, int userId) {
        Project project = projectRepo.findById(projectId).orElse(null);
        User user = userRepo.findById(userId).orElse(null);
        List<Project> projets = user.getProjets();

        if(project!=null&&user!=null)
            projets.add(project);
       userRepo.save(user);
    }

    @Override
    public void assignProjectToClient(int projectId, String firstName, String lastName) {
        Project project = projectRepo.findById(projectId).orElse(null);
        List<User> users= userRepo.findUsersByRoleIs(Role.Client);
        for(User user: users){
            if(user.getFName().equals(firstName)&&user.getLName().equals(lastName))
            {
                if(user.getProjects().size()==0){
                    user.getProjects().add(project);
                }
            }
        }

    }
}
