package com.example.zemzemithouraya.Controllers;

import com.example.zemzemithouraya.Entities.User;
import com.example.zemzemithouraya.Services.Interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserInterface userInterface ;

    @PostMapping("/addUser")
    public ResponseEntity<User> ajouterUser(@RequestBody User user){

        User addedUser= userInterface.addUser(user);

        return ResponseEntity.ok(addedUser);
    }


    @PostMapping("/assignProjectToUser/{idUser}/{idProject}")
    public ResponseEntity<String> assignProjectToUser(@PathVariable int idUser, @PathVariable int idProject)
    {
        userInterface.assignProjectToUSer(idUser,idProject);
        return ResponseEntity.ok("assigned");
    }

    @PostMapping("/assignProjectToClient/{projectId}/{fName}/{lName}")
    public ResponseEntity<String> assignProjectToClient(@PathVariable int projectId, @PathVariable String fName, @PathVariable String lName){
        userInterface.assignProjectToClient(projectId,fName,lName);
        return ResponseEntity.ok("assigned");
    }



}
