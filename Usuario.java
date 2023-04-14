import java.util.ArrayList;

public class Usuario {
    String nome, senha, status, login, email;
    int nTweets;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getnTweets() {
        return nTweets;
    }
    public void setnTweets(int nTweets) {
        this.nTweets = nTweets;
    }
    public Usuario(String nome, String senha, String login, String email) {
        this.nome = nome;
        this.senha = senha;
        this.status = "off";
        this.login = login;
        this.email = email;
        this.nTweets = 0;
    }
    ArrayList<String> tweet = new ArrayList<String>();

    public void logarUsuario(String senha){ /* <-- Loga o usuario mudando o status para "on" */
        String sen = senha;
        if (validadorSenha(sen) == true){
            status = "on";
            System.out.println("Status: ONLINE");
        }else{
            System.out.println("Erro senha errada");
        }
    }
    public void deslogarUsuario(String senha){ /* <-- Desloga o usuario mudando o status para "off" */
        String sen = senha;
        if(validadorSenha(sen) == true){
            status = "off";
            System.out.println("Status: OFFLINE");
        }else{
            System.out.println("Erro senha errada");
        }
    }
    private boolean validadorSenha(String sen){ /* <-- Funcao para validar a senha do usuario */
        if (senha ==  sen ){
            return true;
        }else{
            return false;
        }
    }
    public void adicionarTweet(String txt){
        tweet.add(txt);
    }
    public void mostrarFeed(){
        for (int i = 0; i < tweet.size(); i++) {
            System.out.println(" ");
            tweet.get(i);
            System.out.println(" ");
        }
    }
    public void removeTweet(){
        for (int i = 0; i < tweet.size(); i++) {
            tweet.remove(i);  
        }
    }
}
