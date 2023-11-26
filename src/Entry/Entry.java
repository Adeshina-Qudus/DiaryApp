package Entry;

import java.time.LocalDateTime;

public class Entry {

    private int id;
    private String title;
    private String body;
    private LocalDateTime dateCreated;

    public Entry(int id,String title,String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }
    public int getId(){
        return id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String concat) {
        body = concat;
    }
}
