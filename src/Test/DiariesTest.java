package Test;

import DiaryApp.Diaries;
import DiaryApp.Diary;
import org.junit.jupiter.api.Test;
import Exception.InvalidUserName;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class DiariesTest {


    @Test
    public void newDiaryAdded(){
        Diaries diaries = new Diaries();
        diaries.add("username","password");
        assertEquals(1,diaries.numberOfDiaries());
    }
    @Test
    public void findByUserNameTest(){
        Diaries diaries = new Diaries();
        diaries.add("username","password");
        Diary diary = diaries.findByUsername("username");
        assertEquals("username",diary.getUsername());
    }
    @Test
    public void findByWrongUserNameTest(){
        Diaries diaries = new Diaries();
        diaries.add("username","password");
        assertThrows(InvalidUserName.class, ()-> diaries.findByUsername("name"));
    }

    @Test
    public void deleteDiaryTest(){
        Diaries diaries = new Diaries();
        diaries.add("username","password");
        diaries.add("aishat","alimot");
        diaries.delete("username","password");
        assertEquals(1, diaries.numberOfDiaries());
    }

}