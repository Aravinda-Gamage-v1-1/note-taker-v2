package lk.ijse.note_taker_v2.service;

import lk.ijse.note_taker_v2.customObj.UserResponse;
import lk.ijse.note_taker_v2.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(String userId);
    UserResponse getSelectedUser(String userId);
    List<UserDTO> getAllUsers();
}
