package org.example.repository;

import lombok.NoArgsConstructor;
import org.example.exception.UserAlreadyExistException;
import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class UserRepository {
    Map<Integer, User> usersMap = new HashMap<Integer, User>();
    Integer counter=0;

    public int addUser(String name, String departmentName) {
        for (Map.Entry<Integer, User> p : usersMap.entrySet()) {
            if (p.getValue().getName().equals(name) && p.getValue().getDepartmentName().equals(departmentName)) {
                throw new UserAlreadyExistException();
            }
        }
        counter++;
        usersMap.put(counter, new User(counter, name, departmentName));
        return counter;
    }

    public User getUserById(int userId) {
        return usersMap.getOrDefault(userId, null);
    }
}
