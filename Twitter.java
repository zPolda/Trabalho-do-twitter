import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Twitter{
    static Scanner leitor = new Scanner(System.in);
    /*=============================================================================================================== */
    /* Todos os cases em funçao */

    /* Caso 10 */
    public static void exibeInformacao(ArrayList<Usuario> user, ArrayList<Feed> feed){

        System.out.println("Número total de usuários cadastrados: " + user.size()); // Numero de usuarios cadastrados

        Integer usuariosAtivosAgora = 0;
        for (Usuario usuario : user){
            if( usuario.status.equals("on") ){
                usuariosAtivosAgora++;
            }
        }
        System.out.println("Número de usuários logados neste momento: " + usuariosAtivosAgora); // Numero de usuarios ativos agora

        System.out.println("Número de tweets no total: " + feed.size()); // Numero de tweets no total

        // Aproveitando o For para capturar os valores do usuario com maior n de tweets
        Integer qtdTweetsUsuario = 0;
        String usuarioMaisTweets = "";
        System.out.println("Número de tweets por usuário:");
        
        if (feed.size() > 0){
            for (Usuario usuario : user) {
                System.out.println("Login: " + usuario.getLogin() + " | " + usuario.getnTweets() + " tweets\n");

                if (usuario.getnTweets() > qtdTweetsUsuario) {
                    qtdTweetsUsuario = usuario.getnTweets();
                    usuarioMaisTweets = usuario.getLogin();
                }
            }

            System.out.println("Login do usuário que mais tweetou e quantidade de tweets: " + usuarioMaisTweets + " | " + qtdTweetsUsuario + " tweets");
            String usuarioUltimoTweet = feed.get(feed.size() - 1).user;
            String ultimoTweet = feed.get(feed.size() - 1).text;

            System.out.println("Login do usuário que tweetou por último e tweet: " + usuarioUltimoTweet + " | " + ultimoTweet); 
        }else{
            System.out.println("Nenhum tweet no momento");
        }
    }
    /* Caso 9 */
    public static void excluiUser(ArrayList<Usuario> user){ /* <-- Remove o usuario escolhido pelo adm do Array user, utilizando um iterator */
        System.out.println("Login: ");
        String y = leitor.next();
        for (int i = 0; i < user.size(); i++) {
            if(user.get(i).getLogin().equals(y)){
                System.out.println("Senha: ");
                if(user.get(i).validadorSenha(leitor.next()) == true){
                    Iterator<Usuario> iter = user.iterator();
                        while(iter.hasNext()){
                        Usuario item = iter.next();
                            if(item.getLogin().equals(y)){
                            iter.remove();
                            }
                        }
                    return;
                }else{
                    System.out.println("Erro senha errada");
                    return;
                }
            }
        }

        System.out.println("Usuario inexistente");
    }
    /* Caso 8 */
    public static void trocaPsw(ArrayList<Usuario> user) { /*<-- Troca a senha do user com a funcao trocaSenha() */
        System.out.println("Login: ");
        String y = leitor.next();
        for (int i = 0; i < user.size(); i++) {
            if(user.get(i).getLogin().equals(y)){
                System.out.println("Senha: ");
                user.get(i).trocaSenha(leitor.next());
            }
        }
    }
    /* Caso 7 */
    public static void removeTweet(ArrayList<Usuario> user, ArrayList<Feed> feed){ /* Remove os tweets dos Arrays feed e user */
        System.out.println("Login: ");
        String w = leitor.next();
        String id = "";

        for (int i = 0; i < user.size(); i++) {
            if(user.get(i).getLogin().equals(w)){
                id = user.get(i).mostraTweets();
                user.get(i).removerFeed(id);

                for (int j = 0; j < feed.size(); j++) {
                    if(feed.get(j).getUser().equals(w) && feed.get(j).getId().equals(id)){
                        feed.remove(j);
                        System.out.println("Twt removido do feed com sucesso");
                        break;
                    }
                }
                return;
            }
        }

        System.out.println("Nao existe usuario");
    }
    /* Caso 6 */
    public static void mostraFeed(ArrayList<Feed> feed){ /* <-- Motra N tweets do Array feed  */
        System.out.println("Quantidade: ");
        int qtd = leitor.nextInt();
        for (int i = 0; i < qtd; i++) {
            feed.get(i).mostarFeed();
        }
    }
    /* Caso 5 */
    public static void adicionaTweet(ArrayList<Usuario> user, ArrayList<Feed> feed){ /* <-- Adiciona o texto do tweet dentro dos 2 arrays feed e user */
        String tweet;
        String users;
        int id;
        System.out.println("Login: ");
        String z = leitor.next();
        for (int i = 0; i < user.size(); i++) {
            if(user.get(i).getLogin().equals(z)){
                if(user.get(i).getStatus().equals("on")){
                    System.out.println("Tweet: ");
                    users = user.get(i).getLogin();
                    leitor.nextLine();
                    tweet = leitor.nextLine();
                    user.get(i).adicionarTweet(tweet);
                    id = user.get(i).getIdTweet();

                    feed.add(criaFeed(tweet, users, String.valueOf(id)));
                    return;
                }else{
                    System.out.println("Status off");
                    return;
                }
            }
        }
        
        System.out.println("Usuario inexistente");
    }
    /* Caso 4 */
    public static void deslogaUser(ArrayList<Usuario> user) { /* <-- Desloga o Usuario muda o atibuto status do obj para "off"  */
        System.out.println("Login: ");
        String y = leitor.next();
        for (int i = 0; i < user.size(); i++) {
            if(user.get(i).getLogin().equals(y)){
                System.out.println("Senha: ");
                user.get(i).deslogarUsuario(leitor.next());
                return;
            }
        }

        System.out.println("Nao existe usuario");
    }
    /* Caso 3 */
    public static void logaUser(ArrayList<Usuario> user) { /* <-- Loga o Usuario muda o atibuto status do obj para "on"  */
        System.out.println("Login: ");
        String x = leitor.next();
        for (int i = 0; i < user.size(); i++) {
            if(user.get(i).getLogin().equals(x)){
                System.out.println("Senha: ");
                user.get(i).logarUsuario(leitor.next());
                return;
            }
        }

        System.out.println("Usuario inexistente");
    }
    /* Caso 2 */
    public static void listarUsers(ArrayList<Usuario> user) { /* <-- Lista todos os usuarios criados pega a posicao no Array e o Login no Objeto */
        for (int i = 0; i < user.size(); i++) {
            System.out.println("=========================");
            System.out.println(user.get(i).getLogin());
            System.out.println("=========================");
        }
    }
    /* Caso 1 */
    public static void cadastrarUser(ArrayList<Usuario> user) { /* <-- Utiliza a Funcao criarUsuario() para adicionar um usuario ai Array */
        user.add(criarUsuario());
    }
    /*=============================================================================================================== */
    public static Usuario criarUsuario(){  /* <-- Funcao para criar usuario */
        String x, nome ="null", login = "null", senha = "null", email = "null";
        do{
            System.out.println("Digite seu nome [Minimo 2 e no maximo 30 caracteres]: ");
            x = leitor.next();
            if(validadorNome(x) != false){
                nome = x;
            }else{
                System.out.println("Erro. Nome com formato invalido");
                return null;
            }
        }while(nome != x);
        do{
            System.out.println("Digite seu login [Minimo 2 e no maximo 20 caracteres]: ");
            x = leitor.next();
            if(validadorLogin(x) != false){
                login = x;
            }else{
                System.out.println("Erro. Login com formato invalido");
                return null;
            }
        }while(login != x);
        do{
            System.out.println("Digite sua senha [Minimo 6 e no maximo 30 caracteres]: ");
            x = leitor.next();
            if(validadorPsw(x) != false){
                senha = x;
            }else{
                System.out.println("Erro. Senha com formato invalido");
                return null;
            }
        }while(senha != x);
        do{
            System.out.println("Digite seu email [Minimo 6 e no maximo 15 caracteres]: ");
            x = leitor.next();
            if(validadorEmail(x) != false){
                email = x;
            }else{
                System.out.println("Erro. E-mail invalido");
                return null;
            }
        }while(email != x);
        Usuario a = new Usuario(nome, senha, login, email);
        return a;
    }
    public static Feed criaFeed(String tweet, String users, String id) {
        Feed f = new Feed(tweet, users, id);
        return f;
        
    }
    public static void main(String[] args) {
        int sc = -1;
        ArrayList<Usuario> user = new ArrayList<Usuario>();
        ArrayList<Feed> feed = new ArrayList<Feed>();

        Usuario a1 = new Usuario("polda", "123", "polda", "polda123");
        Usuario a2 = new Usuario("ellen", "123", "akemi", "akemi123");
        user.add(a1);
        user.add(a2);

        do{    /* <-- Menu do para validar a resposta do Usuario */
            System.out.println("[1]Cadastrar usuario");
            System.out.println("[2]Lista de usuarios");
            System.out.println("[3]Logar usuario");
            System.out.println("[4]Deslogar usuario");
            System.out.println("[5]Tweetar");
            System.out.println("[6]Mostrar ultimos N tweets do feed");
            System.out.println("[7]Remover tweet de um usuario");
            System.out.println("[8]Alterar senha de um usuario");
            System.out.println("[9]Remover um usuario");
            System.out.println("[10]Imprimir estatisticas");
            System.out.println("[0]Finalizar programa");

            sc = leitor.nextInt();

            switch(sc){ /* <-- Utilizando switch case para as opcoes do menu */
                case 1: 
                    cadastrarUser(user);
                    break;
                case 2:
                    listarUsers(user);
                    break;
                case 3:
                    logaUser(user);
                    break;
                case 4:
                    deslogaUser(user);
                    break;
                case 5:
                    adicionaTweet(user, feed);
                    break;
                case 6:
                    mostraFeed(feed);
                    break;
                case 7:
                    removeTweet(user, feed);
                    break;
                case 8:
                    trocaPsw(user);
                    break;
                case 9:
                    excluiUser(user);
                    break;
                case 10:
                    exibeInformacao(user, feed);
                    break;
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
    /* Validador de tamanho de tweet */
    public static boolean validadorTweet(String tweet){ /* <-- Valida o tamanho do tweet */
        if(tweet.length() < 1 || tweet.length()> 140){
            return false;
        }else{
            return true;
        }
       
    }
}