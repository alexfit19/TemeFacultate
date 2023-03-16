/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isp.lab9.exercise1;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import lombok.Getter;
import lombok.Setter;

public class Portofolio extends AbstractTableModel {
    private final String[] columns = new String[] {"Symbol", "Quantity"};
    @Getter @Setter
    private Map<String, Integer> stocks = new HashMap<String, Integer>();
    @Getter @Setter
    private BigDecimal funds;
    
    //@Getter @Setter
    //private StockMarketQueryService smq = new StockMarketQueryService();

    
    public Portofolio(BigDecimal funds) {
        this.funds = funds;
    }
    
    public void buy(String symbol, int quantity){
        if(stocks.containsKey(symbol)){
            stocks.put(symbol, stocks.get(symbol) + quantity);
        }else{
            stocks.put(symbol, quantity);
        }
    }

    public void sell(String symbol, int quantity){
        
    }
    
    public void requestData() throws IOException{
         stocks = this.stocks;
         this.fireTableDataChanged();
    }
    
    public Object[] getSymbols(){
        Object[] symbols = this.stocks.keySet().toArray();
        return symbols;
    }
    
    public Object[] getQuantity(String symbol){
        int n = stocks.get(symbol);
        Object[] availableQuantity = new String[n];
        for(int i = 1; i <= n; i++){
            availableQuantity[i] = i+"";
        }
        return availableQuantity;
    }
    
    @Override
    public int getRowCount() {
        return stocks.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] symbols = this.stocks.keySet().toArray();
        Collection<Integer> price = this.stocks.values();
        switch(columnIndex){
            case 0:return symbols[rowIndex];
            case 1:return (price.toArray())[rowIndex];
        }
        return "N/A";
    }
    
    @Override
    public String getColumnName(int index) {
        return columns[index];
    }
    
}
