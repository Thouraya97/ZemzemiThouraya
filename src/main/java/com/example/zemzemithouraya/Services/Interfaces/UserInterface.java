package com.example.zemzemithouraya.Services.Interfaces;

import com.example.zemzemithouraya.Entities.User;

public interface UserInterface {
    public User addUser(User user);
    public void assignProjectToUSer(int projectId, int userId);
    public void assignProjectToClient(int projectId, String firstName, String lastName);
}
