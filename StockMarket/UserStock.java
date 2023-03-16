/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isp.lab9.exercise1;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
public class UserStock {
    @Getter @Setter
    private Map<String, Double> stocks = new HashMap<String, Double>();
    
    public void addQuantity(String symbol, double quantity){
        if(stocks.containsKey(symbol)){
            stocks.putIfAbsent(symbol, stocks.get(symbol) + quantity);
        }else{
            stocks.put(symbol, quantity);
        }
    }
}
