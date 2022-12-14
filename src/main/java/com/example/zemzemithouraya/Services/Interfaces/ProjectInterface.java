package com.example.zemzemithouraya.Services.Interfaces;

import com.example.zemzemithouraya.Entities.Project;
import com.example.zemzemithouraya.Entities.Sprint;

import java.util.List;

public interface ProjectInterface {
    public Project addProject(Project project) ;
    public List<Project> getAllCurrentProject();
    public List<Project> getProjectsByScrumMaster(String fName, String lName);
    public void addSprintAndAssignToProject(Sprint sprint,int idProject) ;
}
