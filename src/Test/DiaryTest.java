package Test;

import DiaryApp.Diary;
import Entry.Entry;
import org.junit.jupiter.api.Test;
import Exception.IncorrectPasswordException;

import Exception.InvalidIdException;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {

    @Test
    public void diaryIsLockedTest(){
        Diary diary = new Diary("jumoke ","pin");
        assertTrue(diary.isLocked());
    }
    @Test
    public void diaryIsLocked_andUnlockDiary_withCorrectPasswordTest(){
        Diary diary = new Diary("jumoke ","pin");
        assertTrue(diary.isLocked());
        diary.unLockDiary("pin");
        assertFalse(diary.isLocked());
    }
    @Test
    public void diaryIsLocked_andUnlockDiary_withIncorrectPasswordTest(){
        Diary diary = new Diary("jumoke ","pin");
        assertTrue(diary.isLocked());
        assertThrows(IncorrectPasswordException.class, ()-> diary.unLockDiary("qudus"));
        assertTrue(diary.isLocked());
    }
    @Test
    public void diaryIsUnLocked_withCorrectPassword_andLockDiaryTest(){
        Diary diary = new Diary("jumoke ","pin");
        assertTrue(diary.isLocked());
        diary.unLockDiary("pin");
        diary.lockDiary();
        assertTrue(diary.isLocked());

    }
    @Test
    public void createDiaryEntryTest(){
        Diary diary = new Diary("jumoke ","pin");
        assertTrue(diary.isLocked());
        diary.unLockDiary("pin");
        assertFalse(diary.isLocked());
        diary.createEntry("love","body");
        assertEquals(1,diary.numberEntry());
    }
    @Test
    public void findDiaryEntryByIDTest(){
        Diary diary = new Diary("jumoke ","pin");
        diary.createEntry("my_guy","body");
        diary.createEntry("title","body");
        Entry entry = diary.findEntryByID(1);
        Entry entry2 = diary.findEntryByID(2);
        assertEquals(entry, diary.findEntryByID(1));
        assertEquals(entry2, diary.findEntryByID(2));
    }
    @Test
    public void findDiaryEntryWithWrongIDTest(){
        Diary diary = new Diary("jumoke ","pin");
        diary.createEntry("my_guy","body");
        diary.createEntry("title","body");
        assertThrows(InvalidIdException.class, () -> diary.findEntryByID(3));
    }
    @Test
    public void deleteEntryTest(){
        Diary diary = new Diary("jumoke ","pin");
        diary.createEntry("my_guy","body");
        diary.createEntry("my_guys","bodys");
        diary.createEntry("my","bdd");
        diary.deleteEntry(1);
        assertEquals(2,diary.numberEntry());
    }

    @Test
    public void updateEntryTest(){
        Diary diary = new Diary("jumoke ","pin");
        diary.createEntry("my_guy","body");
        diary.updateEntry(1, "title","body");
        Entry entry = diary.findEntryByID(1);
        assertEquals("body body", entry.getBody());
    }



}