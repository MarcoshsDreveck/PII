/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pii.servlet;


import br.com.pii.dao.FotografoDAO;
import br.com.pii.entity.Fotografos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juliana
 */
@WebServlet(name = "CadastroDadosPessoais", urlPatterns = {"/CadastroDadosPessoais"})
public class FotografoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Fotografos fotografos = new Fotografos();
        FotografoDAO fotografoDAO = new FotografoDAO();

        String nome = request.getParameter("nome");      
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nascimento = request.getParameter("nascimento");
        
        
        request.setAttribute("nome", nome);           
        request.setAttribute("celular", celular);
        request.setAttribute("email", email);
        request.setAttribute("senha", senha);
         request.setAttribute("nascimento", nascimento);
     
        fotografos.setNome(nome);        
       fotografos.setCelular(celular);
       fotografos.setEmail(email);
        fotografos.setSenha(senha);
        fotografos.setNascimento(nascimento);
        
        try {
            fotografoDAO.insertCad(fotografos);
            request.getRequestDispatcher("DadosFotografo.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar dados pessoais: " + e.getMessage());
        }

      
    }

}
