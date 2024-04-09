package lab6.task2;

import java.util.HashMap;
import java.util.Map;

public class Topic {
    private String nume;
    private Map<String, User> abonati = new HashMap<>();

    public Topic(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return this.nume;
    }
    public void aboneaza(User user) {
        user.aboneazaLaTopic(this);
        abonati.put(user.getNume(), user);
    }

    public void primesteMesaj(Mesaj mesaj) {
        for (User user : abonati.values()) {
            if (!user.getNume().equals(mesaj.getExpeditor())) {
                mesaj.setDetinatar(user.getNume());
                System.out.println(mesaj.toString());
            }
        }
    }
}
