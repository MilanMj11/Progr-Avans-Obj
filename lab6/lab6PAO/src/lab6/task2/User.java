package lab6.task2;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String nume;
    private List<Topic> abonamente = new ArrayList<>();

    public User(String nume) {
        this.nume = nume;
    }

    public void aboneazaLaTopic(Topic topic) {
        abonamente.add(topic);
    }

    public String getNume(){
        return this.nume;
    }

    public void trimiteMesaj(String topic, String continut) {

        Mesaj mesaj = new Mesaj(continut, this.nume, null, topic);
        for(Topic t : abonamente) {
            if (t.getNume().equals(topic)) {
                t.primesteMesaj(mesaj);
            }
        }
    }
}
