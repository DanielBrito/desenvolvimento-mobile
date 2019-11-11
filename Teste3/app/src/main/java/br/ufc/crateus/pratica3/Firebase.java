package br.ufc.crateus.pratica3;

public class Firebase {

    private String userPass;

    public Firebase(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "Firebase{" +
                "userPass='" + userPass + '\'' +
                '}';
    }
}
