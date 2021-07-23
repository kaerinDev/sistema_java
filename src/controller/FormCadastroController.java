/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.CadastroView;

/**
 *
 * @author renato
 */
public class FormCadastroController {
    
    private CadastroView view;

    public FormCadastroController(CadastroView view) {
        this.view = view;
    }
    
    public void salvaUsuario(){
        
    
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Usuario usuarioRenato = new Usuario(usuario, senha);
        
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.insert(usuarioRenato);
            
            JOptionPane.showMessageDialog(null, "Usuario Salvo Com Sucesso!");
            
                    } catch (SQLException ex) {
            Logger.getLogger(CadastroView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
