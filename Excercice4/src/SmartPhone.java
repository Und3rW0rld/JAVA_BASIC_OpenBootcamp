public class SmartPhone extends SmartDevice {
    public String phoneNumber;


    public SmartPhone(String phoneNumber, String name, String model, String ramMemory, String Memory, String color) {
        super(name, model, ramMemory, Memory, color);
        this.phoneNumber = phoneNumber;
    }
    public SmartPhone(){}

    @Override
    public String toString() {
        return "SmartPhone{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", ramMemory='" + ramMemory + '\'' +
                ", Memory='" + Memory + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
