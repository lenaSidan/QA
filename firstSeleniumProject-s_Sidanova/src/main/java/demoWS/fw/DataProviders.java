package demoWS.fw;

import demoWS.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DataProviders {

    @DataProvider
    public Iterator<Object[]> createNewUser() {

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Peter", "Klaus", "klaus76@web.de", "peter@11","peter@11"});
        list.add(new Object[]{"Anna", "Maj", "anna_maj@web.de", "anna@66","anna@66"});
        list.add(new Object[]{"Natalia", "Bollen", "bolen77@web.de", "bollen876","bollen876"});

        return list.iterator();
    }

    @DataProvider
    public  Iterator<Object[]> createExistedUserFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/contact.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact()
                    .setFirstName(split[0])
                    .setLastName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])
                    .setConfirmPassword(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
