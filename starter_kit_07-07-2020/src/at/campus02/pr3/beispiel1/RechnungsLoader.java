package at.campus02.pr3.beispiel1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RechnungsLoader {

    private static List<Rechnung>bills = null;
    private static List<RechnungsPosition>pos = null;

    public static List<Rechnung> LoadAll(String fileName) {
        //Warum wird hier ein String mit dem Filenamen übergeben statt einem File + path?
        bills = new ArrayList<>();

        try{
            FileReader fileReader = new FileReader(new File(fileName));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Rechnung rechnung = new Rechnung();
            String temp;

            while((temp = bufferedReader.readLine())!= null){
                String[] stringArray = temp.split(" ");
                if (temp.equals("Rechnung")){
                    Rechnung currentRechnung = new Rechnung();
                    currentRechnung.setRechnungsNr(stringArray[1]);
                    rechnung = currentRechnung;
                }
                while (temp.equals("Position")) {
                    RechnungsPosition currentPos = new RechnungsPosition();
                    currentPos.setBezeichnung(stringArray[2]);
                    currentPos.setPreis(Double.parseDouble(stringArray[3]));
                    pos.add(currentPos);
                }
                if (rechnung != null) {
                    rechnung.setPositionen(pos);
                    bills.add(rechnung);
                }
            }
        }
        catch (IOException e){
            try {
                throw new RechnungsLoaderException();
            } catch (RechnungsLoaderException rechnungsLoaderException) {
                rechnungsLoaderException.printStackTrace();
            }
            e.printStackTrace();
        }

        return bills;
    }
}
