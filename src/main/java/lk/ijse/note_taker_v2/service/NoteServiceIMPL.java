package lk.ijse.note_taker_v2.service;

import lk.ijse.note_taker_v2.customObj.NoteErrorResponse;
import lk.ijse.note_taker_v2.customObj.NoteResponse;
import lk.ijse.note_taker_v2.dao.NoteDao;
import lk.ijse.note_taker_v2.dto.impl.NoteDTO;
import lk.ijse.note_taker_v2.entity.NoteEntity;
import lk.ijse.note_taker_v2.exception.DataPersistFailedException;
import lk.ijse.note_taker_v2.exception.NoteNotFound;
import lk.ijse.note_taker_v2.util.AppUtil;
import lk.ijse.note_taker_v2.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public  class NoteServiceIMPL implements NoteService {
    @Autowired
    private NoteDao noteDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteId());
        var noteEntity = mapping.convertToEntity(noteDTO);
        var savedNoted = noteDao.save(noteEntity);
        if(savedNoted == null){
            throw new DataPersistFailedException("Cannot save note");
        }
    }

    @Override
    public void updateNote(String noteId, NoteDTO incomeNoteDTO) {
        Optional<NoteEntity> tmpNoteEntity= noteDao.findById(noteId);
        if(!tmpNoteEntity.isPresent()){
            throw new NoteNotFound("Note not found");
        }else {
            tmpNoteEntity.get().setNoteDesc(incomeNoteDTO.getNoteDesc());
            tmpNoteEntity.get().setNoteTitle(incomeNoteDTO.getNoteTitle());
            tmpNoteEntity.get().setCreateDate(incomeNoteDTO.getCreateDate());
            tmpNoteEntity.get().setPriorityLevel(incomeNoteDTO.getPriorityLevel());
        }
    }

    @Override
    public void deleteNote(String noteId) {
//        noteDao.deleteById(noteId);
        Optional<NoteEntity> findId = noteDao.findById(noteId);
        if (!findId.isPresent()){
            throw new NoteNotFound("Note not found");
        }else {
            noteDao.deleteById(noteId);
        }
    }

    @Override
    public NoteResponse getSelectedNote(String noteId) {
        if(noteDao.existsById(noteId)){
            return mapping.convertToDTO(noteDao.getReferenceById(noteId));
        }else {
            return new NoteErrorResponse(0,"Note not found");
        }
    }
    @Override
    public List<NoteDTO> getAllNotes() {
//        List<NoteEntity> getAllNotes = noteDao.findAll();
//        List<NoteDTO> noteDTOS = mapping.convertToDTO(getAllNotes);
//        return noteDTOS;
        return mapping.convertToDTO(noteDao.findAll());

    }
}