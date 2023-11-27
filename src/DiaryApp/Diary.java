package DiaryApp;

import Entry.Entry;
import Exception.IncorrectPasswordException;
import Exception.InvalidIdException;

import java.util.ArrayList;

public class Diary {

    private String userName;
    private String password;
    private boolean isLocked = true;
    private ArrayList<Entry> entries = new ArrayList<>();
    private int numberOfEntry;
    public Diary(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean isLocked() {
        return isLocked;
    }
    public void unLockDiary(String password) {
       validatePassword(password);
       isLocked = false;
    }

    public void validatePassword(String password){
        if (!password.equals(this.password)){
            throw new IncorrectPasswordException("incorrect password");
        }
    }

    public void createEntry(String title, String body) {
        numberOfEntry++;
        int id = generateId();
        Entry entry = new Entry(id,title,body);
        entries.add(entry);
    }
    private int generateId(){
        return numberOfEntry;
    }

    public void lockDiary() {
        isLocked = true;
    }

    public int numberEntry() {
        return numberOfEntry;
    }

    public Entry findEntryByID(int id) {
        validateID(id);
        for (Entry entry : entries){
            if (entry.getId() == id){
                return entry;
            }
        }
        return null;
    }
    public void validateID(int id){
        for (Entry entry : entries) {
            if (entry.getId() != id) {
                throw new InvalidIdException("ID doesn't exist ");
            }
        }
    }
    public void deleteEntry(int id) {
        Entry entry = findEntryByID(id);
        entries.remove(entry);
        numberOfEntry--;
    }

    public void updateEntry(int id, String title, String body){
      Entry entry = findEntryByID(id);
      entry.setTitle(title);
      String concat = entry.getBody()+" "+body;
      entry.setBody(concat);
    }

    public String getUsername() {
        return userName;
    }

}
