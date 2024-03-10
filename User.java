public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isAdmin;
    private String password;

    public User(int userId, String firstName, String lastName, String email, boolean isAdmin, String password){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isAdmin = isAdmin;
        this.password = password;
    }

    public String toString(){
        return "User Id: " + userId + "\nName: " + firstName + " " + lastName + "\nEmail: " + email + "\nAdmin: " + isAdmin;
    }

    public Object[] getAllInformation(){
        Object[] mixedArray = new Object[6];
        mixedArray[0] = userId;
        mixedArray[1] = firstName;
        mixedArray[2] = lastName;
        mixedArray[3] = email;
        mixedArray[4] = isAdmin;
        mixedArray[5] = password;
        return mixedArray;
    }

    public int getUserId(){
        return userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
