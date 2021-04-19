public class Namecard {
    private String name;
    private String phone;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void getInformation(String name)
    {
        if (name.equals(this.name))
        {
            System.out.println("Name: " + this.name);
            System.out.println("Phone: " + this.phone);
            System.out.println("Email: " + this.email);
        }
    }
}
