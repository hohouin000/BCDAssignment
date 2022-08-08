/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataclasses;

import ds.DigitalSignature;
import ds.KeyPairAccess;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;
import pages.LoginPage;

/**
 *
 * @author rainy
 */
public class ProductRecord {

    private String productID, productName, productStatus, arivedTimeStamp, depature, depatureTimeStamp, destination;
    private final static String datapath = "datafolders/ProductRecord.txt";
    private final static String tranxpool = "datafolders/trnxpool.txt";

    @Override
    public String toString() {
        return productID + "|" + productName + "|" + productStatus + "|" + arivedTimeStamp + "|" + depature + "|" + depatureTimeStamp + "|" + destination;
    }

    public ProductRecord() {
    }

    public ProductRecord(String productID, String productName, String productStatus, String arivedTimeStamp, String depature, String depatureTimeStamp, String destination) {
        this.productID = productID;
        this.productName = productName;
        this.productStatus = productStatus;
        this.arivedTimeStamp = arivedTimeStamp;
        this.depature = depature;
        this.depatureTimeStamp = depatureTimeStamp;
        this.destination = destination;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getArivedTimeStamp() {
        return arivedTimeStamp;
    }

    public void setArivedTimeStamp(String arivedTimeStamp) {
        this.arivedTimeStamp = arivedTimeStamp;
    }

    public String getDepature() {
        return depature;
    }

    public void setDepature(String depature) {
        this.depature = depature;
    }

    public String getDepatureTimeStamp() {
        return depatureTimeStamp;
    }

    public void setDepatureTimeStamp(String depatureTimeStamp) {
        this.depatureTimeStamp = depatureTimeStamp;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public static List<String> getAll() {
        try {
            return Files.readAllLines(Paths.get(datapath));
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    public static boolean writeNewLineToFile(Pair<String, String> data) throws Exception {
        boolean status = true;
        DigitalSignature ds = new DigitalSignature();
        PublicKey pubKey = KeyPairAccess.getPublicKey(LoginPage.u.getKeyPairDirectory());
        if (ds.verify(data.getValue0(), data.getValue1(), pubKey)) {
            String stringdata = data.getValue0() + System.lineSeparator();
            try {
                Files.write(Paths.get(datapath),
                        stringdata.getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                Files.write(Paths.get(tranxpool),
                        stringdata.getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                status = false;
            }
        }else{
            status = false;
        }
        
        return status;
    }

    public static ArrayList<ProductRecord> getProductRecordByID(String queryString) {
        ArrayList<ProductRecord> temp = new ArrayList<>();
        List<String> data = getAll();

        for (String string : data) {
            String[] split = string.split("[|]");
            if (split[0].contains(queryString)) {
                String productID = split[0];
                String productName = split[1];
                String productStatus = split[2];
                String arivedTimeStamp = split[3];
                String depature = split[4];
                String depatureTimeStamp = split[5];
                String destination = split[6];

                temp.add(new ProductRecord(productID, productName, productStatus, arivedTimeStamp, depature, depatureTimeStamp, destination));
            }
        }

        return temp;

    }


}
