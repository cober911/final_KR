import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class Animal {
	private String name;
	private Date birthDate;
	private List<String> commands;
	static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public Animal(String name, String birthDateStr, String skills) throws ParseException {
		this.name = name;
		this.birthDate = dateFormat.parse(birthDateStr);
		this.commands = Arrays.asList(skills.split(",\\s*"));
	}

	public String getName() {
		return name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public List<String> getCommands() {
		return commands;
	}

	public void setSkills(String updatedSkills) {
		this.commands = Arrays.asList(updatedSkills.split(",\\s*"));
	}

	public abstract void displayCommands();

	public abstract void teachNewCommand(String command);
}
