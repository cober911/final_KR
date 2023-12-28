package Aimals;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public abstract class Animals {
    protected String name;
    protected Date birthDate;
    protected List<String> commands;
    private static int animalCount = 0;

    public Animals(String name, Date birthDate, List<String> commands) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", commands=" + commands +
                '}';
    }
}
