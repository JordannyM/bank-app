package br.com.finalproject;

import java.io.File;
import java.util.Set;

public class Extract {

    public void generateExtracts() {
        File dir = new File("extracts");
        if (dir.exists()){
            dir.delete();
            dir.mkdir();
        } else {
            dir.mkdir();
        }
        Set<String> extract = transactions.keys();
        String[] extracts = new String[extract.size()];
        extract.toArray(extracts);
        for(int i=0; i<extracts.length; i++){
            generateExtracts(extracts[i]);
        }
    }
}
