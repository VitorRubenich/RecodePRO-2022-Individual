package br.com.vitorrubenich.gotravel.aplicacao;

import br.com.vitorrubenich.gotravel.dao.UserDAO;
import br.com.vitorrubenich.gotravel.model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        loop();

        /*
        List<Usuario> users = new ArrayList<Usuario>();

        UserDAO usuarios = new UserDAO();
        for (Usuario u: usuarios.getUsuarios()) {
            System.out.println("ID: " + u.getId());
            System.out.println("Nome:" + u.getNome());
            System.out.println("Data de cadastro: " + u.getDataCadastro());
            System.out.println();
        }
        */

    }

    private static void loop(){
        Scanner entrada = new Scanner(System.in);
        boolean sair = false;
        while(!sair){
            while(true){
                int opcao = 0;
                menuOpcoes();
                String linha = entrada.nextLine();
                boolean eInteiro = false;
                try{
                    int inteiro = Integer.parseInt(linha);
                    eInteiro = true;
                }catch(Exception e){
                    System.out.printf("Você não digitou uma opção válida!\n");
                }
                if(eInteiro){
                    opcao = Integer.parseInt(linha);
                    if(eInteiro && opcao != 9){
                        opcaoEscolhida(opcao);
                    }else{
                        sair = true;

                    }
                }
            }
        }

    }

    private static void opcaoEscolhida(int opcao) {
        switch (opcao){
            case 1:
                cadastrarNovoUsuario();
                break;
            case 2:
                consultarUsuarios();
                break;
            case 3:
                alterarUsuarioExistente();
                break;
            case 4:
                deletarUsuario();
                break;
            case 5:
                consultaUsuario();
                break;
            default:
                System.out.println("Opcao não é valida.");
        }
    }

    private static void consultaUsuario() {
        UserDAO userDAO = new UserDAO();
        Usuario us = new Usuario();
        us = userDAO.getUsuario(1);
        System.out.println(us.getId());
        System.out.println(us.getNome());
    }

    private static void deletarUsuario() {
        System.out.println("deletarUsuario");
    }

    private static void consultarUsuarios() {
        System.out.println("consultarUsuarios");
    }

    private static void alterarUsuarioExistente() {
        Usuario us = new Usuario();
        us.setSenha("Senhamockada");
        us.setId(2);
        UserDAO userDAO = new UserDAO();
        userDAO.alterarSenhaUsuario(us);
    }

    private static void cadastrarNovoUsuario() {
        UserDAO novoUsuario = new UserDAO();
        Usuario user = new Usuario();
        user.setNome("Vitor");
        user.setDataCadastro(new Date());
        user.setSenha("Somesenha");
        novoUsuario.createUsuario(user);

    }

    private static void menuOpcoes(){
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Consultar");
        System.out.println("3 - Alterar");
        System.out.println("4 - Deletar");
        System.out.println("9 - Sair");
        System.out.println("Digite sua opcao: ");
    }

}
