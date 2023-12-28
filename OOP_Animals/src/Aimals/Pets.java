package Aimals;

import java.util.Date;
import java.util.List;

public abstract class Pets extends Animals{
    public Pets(String name, Date birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }



}
