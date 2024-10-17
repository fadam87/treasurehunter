package pti.sb_treasurehunter_rest.dto;

public class ResponseDTO {

	private UserDto userDto;
	private boolean succes;
	
	
	
	public ResponseDTO() {
		
		this.succes = false;
		this.userDto = null;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public boolean isSucces() {
		return succes;
	}
	public void setSucces(boolean succes) {
		this.succes = succes;
	}
	
	
}
