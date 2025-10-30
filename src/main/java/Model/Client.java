package Model;

public class Client {
    private String name;
    private String id;
    private String age;
    private String mail;
    private String phone;

    public Client(String name, String age, String id, String mail,String phone) {
        this.name = name;
        this.id= id;
        this.age = age;
        this.mail =mail;
        this.phone = phone;
    }

    public String getName() { return name; }

    public void setName() { this.name=name;}

    public String getidentification() { return id; }

    public void setIdentification() { this.id=id; }

    public String getAge() { return age; }

    public void setAge() { this.age=age; }

    public String getMail() { return mail; }

    public void setMail() { this.mail=mail; }

    public String getPhone() { return phone; }

    public void setPhone() { this.phone=phone; }

    @Override
    public String toString() {
        return "Nombre='" + name + '\'' +  ", Documento='" + id + '\'' +
                ", Edad='" + age + '\'' + ", Correo='" + mail + '\'' +
                ", Telefono='" + phone + '\'' + '}';
   }

}