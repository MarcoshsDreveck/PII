/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pii.servlet;

import br.com.pii.dao.EmpresaDAO;
import br.com.pii.entity.Empresas;
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
@WebServlet(name = "CadastroEmpresa", urlPatterns = {"/CadastroEmpresa"})
public class EmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Empresas empresas = new Empresas();
        EmpresaDAO empresaDao = new EmpresaDAO();

        String cnpj = request.getParameter("cnpj");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String redesocial = request.getParameter("redesocial");
        String site = request.getParameter("site");
        String razaosocial = request.getParameter("razaosocial");

        request.setAttribute("cnpj", cnpj);
        request.setAttribute("endereco", endereco);
        request.setAttribute("telefone", telefone);
        request.setAttribute("email", email);
        request.setAttribute("senha", senha);
        request.setAttribute("nome", nome);
        request.setAttribute("redesocial", redesocial);
        request.setAttribute("site", site);
        request.setAttribute("razaosocial", razaosocial);

        empresas.setCnpj(cnpj);
        empresas.setEndereco(endereco);
        empresas.setTelefone(telefone);
        empresas.setEmail(email);
        empresas.setSenha(senha);
        empresas.setNome(nome);
        empresas.setRedesocial(redesocial);
        empresas.setSite(site);
        empresas.setRazaosocial(razaosocial);
        try {
            empresaDao.insertCad(empresas);
            request.getRequestDispatcher("consulta.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar empresa: " + e.getMessage());
        }
    }
}
