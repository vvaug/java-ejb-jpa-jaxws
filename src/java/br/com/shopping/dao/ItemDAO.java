/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.dao;

import br.com.shopping.entities.Item;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Victor Augusto
 */
@Stateless
public class ItemDAO {
    
    @PersistenceContext
    EntityManager em;
    
    public ItemDAO(){
        
    }
    
    public Item inserir(Item item){
        try{
            em.persist(item);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return item;
    }
    
    public List<Item> getAllItems(){
        Query query = em.createQuery("SELECT a FROM Item a", Item.class);
        List<Item> itens = new ArrayList<Item>();
        
        try {
            itens = query.getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return itens;
    }
    
    public String deleteItem(String cod){
        Query query = em.createQuery("DELETE FROM Item a WHERE a.id = :id")
                        .setParameter("id", Long.valueOf(cod));
        Integer rows = query.executeUpdate();
        return "deleted: " + rows.toString();
    }
}
