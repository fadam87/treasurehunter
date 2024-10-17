package pti.sb_treasurehunter_rest.dto;

public class UserDto {

	private int id;
	private String name;
	private int lifes;
	private Integer recordSteps;
	
	
	public UserDto(int id, String name, int lifes, Integer recordSteps) {
		super();
		this.id = id;
		this.name = name;
		this.lifes = lifes;
		this.recordSteps = recordSteps;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public Integer getRecordSteps() {
		return recordSteps;
	}

	public void setRecordSteps(Integer recordSteps) {
		this.recordSteps = recordSteps;
	}
}
