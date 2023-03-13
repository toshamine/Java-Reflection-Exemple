package Models;

public class TestModel {


    private String name;
    public int id;

    @Override
    public String toString() {
        return "TestModel{" +
                "name='" + name + '\'' +
                ", id=" + id +
                "}\n";
    }

    public TestModel(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void privateMethod(){
        System.out.print("This is a private method \n");
    }

    public void publicMethod(){
        System.out.print("This is a public method");
    }


    public static void isPublicStatic(){
        System.out.print("This is a public static method \n");
    }

    private static void isPrivateStatic(){
        System.out.print("This is a private static method \n");
    }
}
