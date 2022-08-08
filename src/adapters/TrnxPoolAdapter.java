/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapters;

import hashing.Hasher;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import transaction.Transaction;

/**
 *
 * @author rainy
 */
public class TrnxPoolAdapter {
   private final static Path tranxpoolPath = Paths.get("datafolders/trnxpool.txt");
    
    public static void main(String[] args) {
        //empty();
        List<String> trnxLst = TrnxPoolAdapter.getTransactionsHashes();
        System.out.println( trnxLst );
    }
    
    public static List<String> getTransactions(){
        try {
            return Files.readAllLines(tranxpoolPath);
       } catch (IOException ex) {
           Logger.getLogger(TrnxPoolAdapter.class.getName()).log(Level.SEVERE, null, ex);
       }
        return null;
    }
    
    public static List<String> getTransactionsHashes(){
        List<String> trnxPool = TrnxPoolAdapter.getTransactions();
        //generate hash value of each data in Transaction
            //collect using javatuple
       
        return trnxPool.stream().map(x->Hasher.sha256(x)).collect( Collectors.toList() );
    }
    
    public static void empty(){
        try {
            FileChannel.open(tranxpoolPath, StandardOpenOption.WRITE).truncate(0).close();
        } catch (IOException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
