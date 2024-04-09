package lab6.task2;

public class Mesaj {
    private String continut;
    private String expeditor;
    private String destinatar;
    private String topic;

    public Mesaj(String continut, String expeditor, String destinatar, String topic) {
        this.continut = continut;
        this.expeditor = expeditor;
        this.destinatar = destinatar;
        this.topic = topic;
    }

    public void setDetinatar(String destinatar) {
        this.destinatar = destinatar;
    }
    public String getExpeditor() {
        return this.expeditor;
    }

    @Override
    public String toString() {
        return "[" + destinatar + "] " + expeditor + " @ " + topic + ": " + continut;
    }
}
