package Exception;

public class InvalidUserName  extends  RuntimeException{
    public InvalidUserName(String string){
        super(string);
    }
}
