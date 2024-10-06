package lk.ijse.note_taker_v2.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {

    public static String createNoteId(){
        return "NOTE-"+UUID.randomUUID();
    }
    public static String createUserId(){
        return "USER-"+UUID.randomUUID();
    }
    public static String toBase64ProfilePic(MultipartFile profilePic){
        String profilePicBased64 = null;
        try {
            byte [] imageByteCollection = profilePic.getBytes();
            profilePicBased64 = Base64.getEncoder().encodeToString(imageByteCollection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return profilePicBased64;
    }
}
