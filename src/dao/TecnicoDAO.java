package dao;

import bean.LoginBean;
import bean.TecnicoBean;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tadeu Diniz e Lucas William
 */
public class TecnicoDAO {

    public static void AdicionaTecnico() {
        int opcao = 0;
        while (opcao != 2) {
            //arraylist para os professores
            ArrayList<TecnicoBean> listaTecnico = new ArrayList<>();
            //arraylist para o login
            ArrayList<LoginBean> login = new ArrayList<>();

            Scanner leitor = new Scanner(System.in);
            int siape = (int) Math.round(Math.random() * 201800) + 99999;

            //Verifica se o arquivo existe, se sim, continua
            File file = new File("..\\sigaa\\src\\binarios\\tecnico.ser");
            if (file.exists()) {
                //gravar no arquivo dos professores
                try {
                    FileInputStream fi = new FileInputStream("src\\binarios\\tecnico.ser");
                    System.out.println();
                    try (ObjectInputStream oi = new ObjectInputStream(fi)) {
                        listaTecnico = (ArrayList) oi.readObject();
                    }
                } catch (IOException | ClassNotFoundException e) {
                }

                //gravar no arquivo do login
                try {
                    FileInputStream log = new FileInputStream("src\\binarios\\login.ser");
                    System.out.println();
                    try (ObjectInputStream ei = new ObjectInputStream(log)) {
                        login = (ArrayList) ei.readObject();
                    }
                } catch (IOException | ClassNotFoundException e) {
                }

                //Objeto professore
                TecnicoBean novoTecnico = new TecnicoBean();

                //Objeto Login
                LoginBean novoLogin = new LoginBean();

                //Dados do professore para inserir
                novoTecnico.setSiape(siape);
                novoTecnico.setNivel(1);
                System.err.println("SIAPE = " + siape);
                System.out.print("Nome: ");
                novoTecnico.setNome(leitor.nextLine());
                System.out.print("Endereço: ");
                novoTecnico.setEndereco(leitor.nextLine());
                System.out.print("CPF: ");
                novoTecnico.setCpf(leitor.nextLine());
                System.out.print("Telefone: ");
                novoTecnico.setTelefone(leitor.nextLine());
                System.out.println("...........");
                System.out.print("Login: ");
                String entradalogin = leitor.nextLine();
                novoTecnico.setLogin(entradalogin);
                System.out.print("Senha: ");
                String entradasenha = leitor.nextLine();
                novoTecnico.setSenha(entradasenha);
                System.out.println("...........");
                
                //Dados do login do professor para inserir
                novoLogin.setLogin(entradalogin);
                novoLogin.setSenha(entradasenha);
                novoLogin.setNivel(1);
                login.add(novoLogin);
                
                listaTecnico.add(novoTecnico);

                //serializa o objeto professor
                try {
                    FileOutputStream fo = new FileOutputStream("src\\binarios\\tecnico.ser");
                    try (ObjectOutputStream oo = new ObjectOutputStream(fo)) {
                        oo.writeObject(listaTecnico); // serializo objeto cat
                    } // serializo objeto cat
                } catch (IOException e) {
                }

                //serializa o objeto login
                try {
                    FileOutputStream logi = new FileOutputStream("src\\binarios\\login.ser");
                    try (ObjectOutputStream oo = new ObjectOutputStream(logi)) {
                        oo.writeObject(login); // serializo objeto cat
                    } // serializo objeto cat
                } catch (IOException e) {
                }
            }
            System.out.print("Deseja inserir outro técnico: 1 Sim  |  2 Não - ");
            opcao = leitor.nextInt();
        }
    }
    
    public static TecnicoBean ListarTecnico() {
        Scanner leitor = new Scanner(System.in);
        int siape = 0;
        File file = new File("..\\sigaa\\src\\binarios\\tecnico.ser");
        if (file.exists()) {
            ArrayList<TecnicoBean> listaTecnico = new ArrayList<>();
            try {
                FileInputStream fi = new FileInputStream("src\\binarios\\tecnico.ser");
                try (ObjectInputStream oi = new ObjectInputStream(fi)) {
                    listaTecnico = (ArrayList) oi.readObject();
                }
                for (TecnicoBean tecnico : listaTecnico) {
                    String tecnicoInfo = "SIAPE: " + tecnico.getSiape()+ "\nNome: " + tecnico.getNome();
                    System.out.println(tecnicoInfo);
                    System.out.println(".................................................");
                }
                
                System.out.print("Qual aluno(a) deseja ver (SIAPE)? ");
                siape = leitor.nextInt();
                for (TecnicoBean tecnico : listaTecnico) {
                    TecnicoBean tecnicoTemp = (TecnicoBean) tecnico;
                    if (tecnicoTemp.getSiape()== siape) {
                        System.out.println("............................");
                        System.err.println("SIAPE: " + tecnicoTemp.getSiape());
                        System.out.println("Nome: " + tecnicoTemp.getNome());
                        System.out.println("CPF: " + tecnicoTemp.getCpf());
                        System.out.println("Endereço: " + tecnicoTemp.getEndereco());
                        System.out.println("Telefone: " + tecnicoTemp.getTelefone());
                        System.out.println("-------");
                        System.out.println("Login: " + tecnicoTemp.getLogin());
                        System.out.println("Senha: " + tecnicoTemp.getSenha());
                    }
                }
                
            } catch (IOException | ClassNotFoundException e) {
            }
        } else {
            System.out.println("Lista de alunos vazia... insira um novo aluno!");
        }
        return null;
    }
}