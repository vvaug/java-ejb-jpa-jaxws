/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.services;

import br.com.shopping.business.ItemBusiness;
import br.com.shopping.entities.Item;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebResult;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author Victor Augusto
 */
@WebService(serviceName = "ShoppingWS")
@Stateless()
public class ShoppingWS {

    @Inject
    ItemBusiness itemBusiness;
    
    @WebMethod(operationName = "newItem")
    @WebResult(name = "newestItem")
    public Item newItem(@WebParam(name = "item") Item item){
        return itemBusiness.insertItem(item);
    }
    
    @WebMethod(operationName = "getCart")
    @WebResult(name = "itens")
    @ResponseWrapper(localName = "cartItens")
    public List<Item> getAll(){
        return itemBusiness.getCart();
    }
    
    @WebMethod(operationName = "deleteItem")
    @WebResult(name = "deletedItem")
    public String deleteItem(@XmlElement(required = true)
                             @WebParam(name = "itemCod") String cod){
        return itemBusiness.deleteItem(cod);
    }
}
