package smartdoodle.pad;
import net.gjerull.etherpad.client.EPLiteClient;

import java.util.List;
import java.util.Map;


public class Pad {
    EPLiteClient client;
    String padId;

    public Pad(String url, String apikey, String padId) {
        client = new EPLiteClient(url, apikey);
        this.padId = padId;
        checkPad();
    }

    public static void main(String[] args) {
        Pad pad = new Pad("http://localhost:9001", "key", "testPad2");
        pad.addUser("Anne");
    }

    public void addUser(String user) {
        String str = client.getText(padId).get("text").toString();
        final String substring = "Liste des participants:\n";
        int index = str.indexOf(substring);
        if (index == -1) {
            str = substring;
            index = 0;
        }
        index += substring.length();
        String begin = str.substring(0, index);
        String end = str.substring(index);
        str = begin + user + "\n" + end;
        client.setText(padId, str);
    }

    public void setTitle(String title) {
        //TODO
    }

    private void checkPad() {
        Map result = client.listAllPads();
        List padIds = (List) result.get("padIDs");
        boolean exist = padIds.contains(padId);
        if(!exist) {
            client.createPad(padId);
        }

    }

}
