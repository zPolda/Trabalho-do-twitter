public class Feed {
    private String text, user, id;

    /* Getters and Setters */
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
    /* Metodo Construtor */
    public Feed(String text, String user, String id) {
        this.id = id;
        this.text = text;
        this.user = user;
    }
    public void mostarFeed(){ /* <-- Mostra o feeed printado todos os text */
        System.out.println(" ");
        System.out.println(text);
        System.out.println(" ");
    }
}