import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

// Класс Hamster наследуется от класса Animal
public class Hamster extends Animal {

	public Hamster(String name, String birthDateStr, String skills) throws ParseException {
		super(name, birthDateStr, skills);
	}

	@Override
	public void displayCommands() {
		System.out.println("Список команд для хомяка:");
		for (String command : getCommands()) {
			System.out.println(command);
		}
	}

	@Override
	public void teachNewCommand(String command) {
		List<String> updatedCommands = new ArrayList<>(getCommands());
		updatedCommands.add(command);
		// Поскольку getCommands возвращает список, нам нужно преобразовать его обратно в строку для сохранения
		String updatedSkills = String.join(", ", updatedCommands);
		setSkills(updatedSkills);
	}
}
