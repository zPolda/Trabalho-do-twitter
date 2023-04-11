import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Aplicacao{
    static Scanner leitor = new Scanner(System.in);

    public static Usuario criarUsuario(){  /* <-- Funcao para criar usuario */
        Usuario a = new Usuario();
        return a;
    }
    public static void main(String[] args) {
        int sc = -1;
        ArrayList<Usuario> user = new ArrayList<Usuario>();
        ArrayList<String> feed = new ArrayList<String>();
        do{    /* <-- Menu do para validar a resposta do Usuario */
            switch(sc){ /* <-- Utilizando switch case para as opcoes do menu */
                case'1': 
                    user.add(criarUsuario());
                    break;
                case'2':
                    for (int i = 0; i < user.size(); i++) {
                        System.out.println("=========================");
                        System.out.println(user.get(i).getNome());
                        System.out.println("=========================");
                    }
                    break;
                case'3':
                    System.out.println("Username: ");
                    for (int i = 0; i < user.size(); i++) {
                        if(user.get(i).getNome().equals(leitor.next())){
                            System.out.println("Senha: ");
                            user.get(i).logarUsuario(leitor.next());
                        }
                    }
                case'4':
                    System.out.println("Username: ");
                    for (int i = 0; i < user.size(); i++) {
                        if(user.get(i).getNome().equals(leitor.next())){
                            System.out.println("Senha: ");
                            user.get(i).deslogarUsuario(leitor.next());
                        }
                    }
                case '5':
                    System.out.println("Username: ");
                    String twt;
                    for (int i = 0; i < user.size(); i++) {
                        if(user.get(i).getStatus().equals("on")){
                            twt = leitor.nextLine();
                            feed.add(user.get(i).getNome() + twt);
                            user.get(i).adicionarTweet(twt);
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
}