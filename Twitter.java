import java.util.ArrayList;
import java.util.Scanner;

public class Twitter{
    static Scanner leitor = new Scanner(System.in);

    public static Usuario criarUsuario(){  /* <-- Funcao para criar usuario */
        String x, nome ="null", login = "null", senha = "null", email = "null";
        do{
            System.out.println("Digite seu nome [Minimo 2 e no maximo 30 caracteres]: ");
            x = leitor.nextLine();
            if(validadorNome(x) != false){
                nome = x;
            }else{
                System.out.println("Erro siga a regra");
            }
        }while(nome != x);
        do{
            System.out.println("Digite seu login [Minimo 2 e no maximo 20 caracteres]: ");
            x = leitor.nextLine();
            if(validadorLogin(x) != false){
                login = x;
            }else{
                System.out.println("Erro siga a regra");
            }
        }while(login != x);
        do{
            System.out.println("Digite sua senha [Minimo 6 e no maximo 30 caracteres]: ");
            x = leitor.nextLine();
            if(validadorPsw(x) != false){
                senha = x;
            }else{
                System.out.println("Erro siga a regra");
            }
        }while(senha != x);
        do{
            System.out.println("Digite seu email [Minimo 6 e no maximo 15 caracteres]: ");
            x = leitor.nextLine();
            if(validadorEmail(x) != false){
                email = x;
            }else{
                System.out.println("Erro siga a regra");
            }
        }while(email != x);
        Usuario a = new Usuario(nome, senha, login, email);
        return a;
    }
    public static Feed criaFeed(String users, String tweet) {
        Feed f = new Feed(users, tweet);
        return f;
        
    }
    public static void main(String[] args) {
        int sc = -1;
        ArrayList<Usuario> user = new ArrayList<Usuario>();
        ArrayList<Feed> feed = new ArrayList<Feed>();
        do{    /* <-- Menu do para validar a resposta do Usuario */
            switch(sc){ /* <-- Utilizando switch case para as opcoes do menu */
                case'1': 
                    user.add(criarUsuario());
                    break;
                case'2':
                    for (int i = 0; i < user.size(); i++) {
                        System.out.println("=========================");
                        System.out.println(user.get(i).getLogin());
                        System.out.println("=========================");
                    }
                    break;
                case'3':
                    System.out.println("Login: ");
                    String x = leitor.next();
                    for (int i = 0; i < user.size(); i++) {
                        if(user.get(i).getLogin().equals(x)){
                            System.out.println("Senha: ");
                            user.get(i).logarUsuario(leitor.next());
                        }else{
                            System.out.println("Nao existe usuario");
                        }
                    }
                case'4':
                    System.out.println("Login: ");
                    String y = leitor.next();
                    for (int i = 0; i < user.size(); i++) {
                        if(user.get(i).getLogin().equals(y)){
                            System.out.println("Senha: ");
                            user.get(i).deslogarUsuario(leitor.next());
                        }else{
                            System.out.println("Nao existe usuario");
                        }
                    }
                case '5':
                    String tweet;
                    String users;
                    System.out.println("Login: ");
                    String z = leitor.next();
                    for (int i = 0; i < user.size(); i++) {
                        if(user.get(i).getLogin().equals(z)){
                            if(user.get(i).getStatus().equals("on")){
                                System.out.println("Tweet: ");
                                users = user.get(i).getLogin();
                                tweet = leitor.next();
                                feed.add(criaFeed(users, tweet));
                                user.get(i).adicionarTweet(tweet);
                            }else{
                                System.out.println("Status off");
                            }
                        }else{
                            System.out.println("Nao existe usuario");
                        }
                    }
                case '6':
                    System.out.println("Quantidade: ");
                    for (int i = 0; i < leitor.nextInt(); i++) {
                        feed.get(i);
                    }
                case '7':
                    System.out.println("Nome: ");
                    for (int i = 0; i < user.size(); i++) {

                        user.get(i).removeTweet();
                        


                    }
                case '8':
                    
                }
        }while (sc != 0);
    }
    /*=============================================================================================================== */
    /* Todos os validadores de nome, login, senha e email */

    public static boolean validadorNome(String nome){ /* <-- Valida o nome na funcao criar usuario */
        if(nome.length() < 2 || nome.length() > 30){
            return false;
        }else{
            return true;    
        }
    }
    public static boolean validadorLogin(String login){ /* <-- Valida o login na funcao criar usuario */
        if(login.length() < 2 || login.length() > 20){
            return false;
        }else{
            return true;    
        }
    }
    public static boolean validadorPsw(String senha){ /* <-- Valida a senha na funcao criar usuario */
        if(senha.length() < 6 || senha.length() > 30){
            return false;
        }else{
            return true;    
        }
    }
    public static boolean validadorEmail(String email){ /* <-- Valida o email na funcao criar usuario */
        if(email.length() < 6 || email.length() > 15){
            return false;
        }else{
            return true;    
        }
    }
    /* ============================================================================================================= */
    public static boolean validadorTweet(String tweet){ /* <-- Valida o tamanho do tweet */
        if(tweet.length() < 1 || tweet.length()> 140){
            return false;
        }else{
            return true;
        }
       
    }
}