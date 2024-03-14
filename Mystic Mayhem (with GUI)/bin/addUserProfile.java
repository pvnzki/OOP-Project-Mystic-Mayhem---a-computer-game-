package bin;
// import javax.swing.JPanel;

class UserProfile {
    private static int userIDCounter = 0;
    private int userID;
    protected String name;
    private String username;

    public UserProfile(String name, String username) {
        this.userID = userIDCounter;
        userIDCounter++;
        this.name = name;
        this.username = username;
    }
    public int getUserIDCounter(){
        return userIDCounter;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User Profile [userID=" + userID + ", name=" + name + ", username=" + username + "]";
    }

}