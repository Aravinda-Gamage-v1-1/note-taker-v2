package lk.ijse.note_taker_v2.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserErrorResponse implements UserResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}