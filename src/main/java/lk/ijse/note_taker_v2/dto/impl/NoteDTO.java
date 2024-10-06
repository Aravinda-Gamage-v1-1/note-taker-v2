package lk.ijse.note_taker_v2.dto.impl;

import lk.ijse.note_taker_v2.customObj.NoteResponse;
import lk.ijse.note_taker_v2.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements SuperDTO, NoteResponse {
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String priorityLevel;
    private String createDate;
    private String userId;
}
