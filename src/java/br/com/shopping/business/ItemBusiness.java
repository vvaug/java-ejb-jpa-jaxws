/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.business;

import br.com.shopping.dao.ItemDAO;
import br.com.shopping.entities.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Victor Augusto
 */
@Stateless()
public class ItemBusiness {

    @Inject
    ItemDAO dao;
    
    public ItemBusiness(){
        
    }
    
    public Item insertItem(Item item){
        return dao.inserir(item);
    }
    
    public List<Item> getCart(){
        return dao.getAllItems();
    }
    
    public String deleteItem(String cod){
        return dao.deleteItem(cod);
    }
}

