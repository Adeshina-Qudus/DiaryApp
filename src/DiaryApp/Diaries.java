package DiaryApp;

import java.util.ArrayList;

import Exception.InvalidUserName;
public class Diaries {

    private ArrayList<Diary> diaries = new ArrayList<>();

    private int diariesNumber ;

    public void add(String username, String password) {
        diariesNumber++;
        Diary diary = new Diary(username,password);
        diaries.add(diary);
    }

    public int numberOfDiaries() {
        return diariesNumber;
    }

    public Diary findByUsername(String userName) {
        for (Diary diary : diaries){
            if (diary.getUsername().equals(userName)){
                return diary;
            }else
                throw new InvalidUserName("username does not exist ");
        }
        return null;
    }

    public void delete(String username, String password){
        Diary diary = findByUsername(username);
        diary.validatePassword(password);
        for (Diary diary1 : diaries){
            if (diary.equals(diary1)){
                diaries.remove(diary);
                diariesNumber--;
            }
        }
    }

}
