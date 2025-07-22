public class UserInfo {

private String name;
private int age;
private String email;
private boolean isActive;


public UserInfo(String name, int age, String email, boolean isActive) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.isActive = isActive;

}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void displayInfo(){
    System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }

    public static void main(String[] args){
        UserInfo user1 = new UserInfo("Tasneem " , 24 , "Tas@gmail.com",true);
        UserInfo user2 = new UserInfo("Ibrahim " , 30 , "Ibrahim@gmail.com",false);
        UserInfo user3 = new UserInfo("Mohammed " , 45 , "mohd@gmail.com" , true);

        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();

        user1.setAge(22);
        System.out.println("Updated Age for " + user1.getName() + ": " + user1.getAge());


    }
}
