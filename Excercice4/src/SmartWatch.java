public class SmartWatch extends SmartDevice{
    String time;
    public SmartWatch(String name, String model, String ramMemory, String Memory, String color, String time) {
        super(name, model, ramMemory, Memory, color);
        this.time = time;
    }
    public SmartWatch(){

    }

    @Override
    public String toString() {
        return "SmartWatch{" +
                "time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", ramMemory='" + ramMemory + '\'' +
                ", Memory='" + Memory + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
