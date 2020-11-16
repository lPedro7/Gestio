package Model;

public class Nota {
    int id;
    String title;
    String text;
    int ownerId;
    String creationDate;
    String lastUpdate;

    public Nota(int id, String title, String text, int ownerId, String creationDate){
        this.id = id;
        this.title = title;
        this.text = text;
        this.ownerId = ownerId;
        this.creationDate = creationDate;
    }

    public Nota(String title, String text, int ownerId, String creationDate){
        this.title = title;
        this.text = text;
        this.ownerId = ownerId;
        this.creationDate = creationDate;
    }


}
