public class Feed {
    int id = 0;
    String text, user;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public Feed(String text, String user) {
        this.id = id++;
        this.text = text;
        this.user = user;
    }
}