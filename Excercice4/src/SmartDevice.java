public abstract class SmartDevice {
    public String name;
    public String model;
    public String ramMemory;
    public String Memory;

    public String color;


    public SmartDevice(String name, String model, String ramMemory, String Memory, String color) {
        this.name = name;
        this.model = model;
        this.ramMemory = ramMemory;
        this.Memory = Memory;
        this.color = color;
    }

    public SmartDevice() {

    }

    @Override
    public String toString() {
        return "SmartDevice{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", ramMemory='" + ramMemory + '\'' +
                ", Memory='" + Memory + '\'' +
                '}';
    }
}
