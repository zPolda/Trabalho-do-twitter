public class Feed {
    String text, user, id;

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    public Feed(String text, String user, String id) {
        this.id = id;
        this.text = text;
        this.user = user;
    }
    public void mostarFeed(){
        System.out.println(" ");
        System.out.println(text);
        System.out.println(" ");
    }
}