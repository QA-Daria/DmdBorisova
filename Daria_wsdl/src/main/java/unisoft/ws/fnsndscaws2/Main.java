package unisoft.ws.fnsndscaws2;

import unisoft.ws.FNSNDSCAWS2;
import unisoft.ws.fnsndscaws2.request.NdsRequest2;
import unisoft.ws.fnsndscaws2.response.NdsResponse2;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) throws IOException {
        FNSNDSCAWS2 fnsndscaws2 = new FNSNDSCAWS2();

        NdsRequest2 ndsRequest2 = new NdsRequest2();

        NdsRequest2.NP np = new NdsRequest2.NP();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите ИНН");
        String parInn = reader.readLine();


        LocalDate today = LocalDate.now();
        String actualDate =  today.format(DateTimeFormatter.ISO_DATE);


        np.setDT(actualDate);
        np.setINN(parInn);
        np.setKPP("");



        ndsRequest2.getNP().add(np);


        NdsResponse2 response = fnsndscaws2.getFNSNDSCAWS2Port().ndsRequest2(ndsRequest2);

        System.out.println("Признак состояния: " + response.getNP().get(0).getState());

    }
}
