/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import JPA.Alunos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jader
 */
public class AlunosDAO {
    EntityManager criarConexao = null;
    private EntityManager conexao(){
        EntityManagerFactory factory = null;
        
        try{
            factory = Persistence.createEntityManagerFactory("BasicProjectPU");
            criarConexao = factory.createEntityManager();
            //System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX"+criarConexao);
            return criarConexao;
            //System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX"+criarConexao);
        }catch(Exception e){
            System.err.println(e);
        }finally{
            //factory.close();
        }
     return criarConexao;   
    }
    public String salvar (Alunos alunos){
        EntityManager conectar = conexao();
        Alunos resultado;
        try{
            conectar.getTransaction().begin();
            resultado = conectar.find(Alunos.class, alunos.getMatricula());
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX"+resultado);
            if(resultado == null){
                conectar.persist(alunos);
                conectar.getTransaction().commit();
                return ("NOVO");
            } else if (resultado != null){
                conectar.merge(alunos);
                conectar.getTransaction().commit();
                return("UPDATE");
            }
           /* boolean validar = new Alunos().equals(alunos);
            if(validar == true){*/
                conectar.persist(alunos);
                
            //}
           /* else{
                conectar.merge(alunos);
                 return true;
            }*/
        }catch(Exception e){
            System.err.println(e);
        }finally{
            conectar.close();
        }
        return ("ERRO");
    }
}
