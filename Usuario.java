import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String nome, senha, status, login, email;
    private int nTweets, idTweet;

    ArrayList<String> tweet = new ArrayList<String>();

   
    static Scanner sc = new Scanner(System.in);

    /* Setters and Getters */

    public int getIdTweet() {
        return idTweet;
    }
    public void setIdTweet(int idTweet) {
        this.idTweet = idTweet;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    private void setSenha(String senha) {
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
    /* Metodo Contrutor */
    public Usuario(String nome, String senha, String login, String email) {
        this.nome = nome;
        this.senha = senha;
        this.status = "off";
        this.login = login;
        this.email = email;
        this.nTweets = 0;
    }
    

    public void logarUsuario(String senha){ /* <-- Loga o usuario mudando o status para "on" */
        String sen = senha;
        if (validadorSenha(sen) == true){
            status = "on";
            System.out.println("Status: ONLINE");
        }else{
            System.out.println("Erro, senha errada");
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
    public boolean validadorSenha(String sen){ /* <-- Funcao para validar a senha do usuario */
        if (senha.equals(sen)){
            return true;
        }else{
            return false;
        }
    }
    public void adicionarTweet(String txt){ /* <-- Faz a adicao do tweet e de um id no obj  */
            idTweet = idTweet + 1;
            String str = String.valueOf(idTweet);
            tweet.add(str + " : " + txt);
            nTweets++;
    }
    public String mostraTweets(){ /* <- Retorna o id do tweet em uma funcao que mostra os mesmos */
        for (int index = 0; index < tweet.size(); index++) {
            System.out.println(" ");
            System.out.println(tweet.get(index));
            System.out.println(" ");
        }
        System.out.println("Qual id remover: ");
        String id = sc.next();
        return id;
    }
    public void removerFeed(String id){ /* <-- Recebe o id do mostraTweets() e remove o memso do Array */
        for (int i = 0; i < tweet.size(); i++) {
            if(tweet.get(i).startsWith(id)){
                tweet.remove(i);
                nTweets--;
                System.out.println("Tweet removido com sucesso");
            }
        }
    }
    public void trocaSenha(String sen){ /* <-- Muda a senha do usuario */
        if(validadorSenha(sen) == true){
            System.out.println("Nova Senha: ");
            setSenha(sc.next());
        }else{
            System.out.println("Erro, senha errada");
        }
    }
}
