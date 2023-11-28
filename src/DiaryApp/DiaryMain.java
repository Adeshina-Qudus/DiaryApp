package DiaryApp;

import java.util.Scanner;

public class DiaryMain {

    private static Diary diary;
    public static void main(String[] args) {
      mainMenu();
    }

    public static void displayMenu(){
        System.out.println("""
           ===============================
           +++++++++++++++++++++++++++++++
           1. Create Diary
           2. Lock Diary
           3. UnLock Diary
           4. Add Entry
           5. find Entry By ID
           6. Delete Entry
           7. Update Entry
           +++++++++++++++++++++++++++++++
           ===============================
                """);
    }
    public static void mainMenu(){
        displayMenu();
        String userInput = input("Enter Number");
        switch (userInput){
            case "1" :
                createDiary();
            case "2" :
                lockDiary();
            case "3" :
                unLockDiary();
            case "4" :
                addEntry();
            case "5":
                 findEntryByID();
            case "6":
                 deleteEntry();
            case "7":
                 updateEntry();
            default:
                System.exit(0);
        }
    }
    public static void createDiary(){
        String userName = input("Enter Username");
        String password = input("Enter Password ");
        diary = new Diary(userName,password);
        print("Diary Created Successfully ");
        mainMenu();
    }
    public static void lockDiary(){
        diary.lockDiary();
        print("Locked");
        mainMenu();
    }
    public static void unLockDiary(){
        boolean unlockSuccessful = false;
        while (!unlockSuccessful) {
            try {
                String password = input("Enter Password to Unlock Diary");
                diary.unLockDiary(password);
                unlockSuccessful = true;
                print("Diary Unlocked");
                mainMenu();
            } catch (Exception exception) {
                print(exception.getMessage());
            }
        }
    }
    public static void addEntry(){
        String title = input("Enter Title");
        String body = input("Enter Body ");
        diary.createEntry(title,body);
        print("Added successfully");
        mainMenu();
    }
    public static void findEntryByID(){
        try {
            int id = Integer.parseInt(input("Enter Id"));
            print(diary.findEntryByID(id).toString());
            mainMenu();
        } catch (NumberFormatException e) {
            print(e.getMessage());
        }
    }
    public static void deleteEntry(){
        int id = Integer.parseInt(input("Enter Id"));
        diary.deleteEntry(id);
        print(id+" deleted");
        mainMenu();
    }
    public static void updateEntry(){
        int id = Integer.parseInt(input("Enter Id"));
        String title = input("Enter New Title");
        String body = input("Enter Body ");
        diary.updateEntry(id,title,body);
        mainMenu();
    }
    private static void print(String message) {
        System.out.println(message);
    }

    private static String input(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        return input.nextLine();
    }
}
