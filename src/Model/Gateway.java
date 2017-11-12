/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 31686559
 */
public class Gateway {
   private static Gateway instance  = null; 
   
   private Gateway(){
   
   }
   
   public static Gateway getInstance(){
       if (instance == null){
           instance = new Gateway();
       }
       return instance; 
   }
  
   
   public static void delega(){
   
   }
}


