package Model.Domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note {
    private int id;
    private String title;
    private String body;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;
    public Note(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        createdDateTime = LocalDateTime.now();
        modifiedDateTime = createdDateTime;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        modifiedDateTime = LocalDateTime.now();
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        modifiedDateTime = LocalDateTime.now();
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        modifiedDateTime = LocalDateTime.now();
        this.body = body;
    }
    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }
    public LocalDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "ID: " + id + "\nЗаголовок: " + title + "\nСодержание: " + body + "\nДата создания: " + createdDateTime.format(formatter)
                + "\nДата изменения: " + modifiedDateTime.format(formatter) + "";
    }
    
}
