package android.example.java;

import java.util.ArrayList;

public class Contacts {
    private String  name;
    private String email;
    private int number;
    private ArrayList<Message> messages;

    public Contacts(String name, String email, int number, ArrayList<Message> messages) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.messages = messages;
    }

    public Contacts(String name, String email, int number) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.messages = new ArrayList<>();
    }

    public static void add(Contacts newContact) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
    public void showContactDetails(){
        System.out.println("Name"+ getName());
        System.out.println("Email" + getEmail());
        System.out.println("Number" + getNumber());
    }
    public void addMessage(Message message){
        this.messages.add(message);
    }
}

