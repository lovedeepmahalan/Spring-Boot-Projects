package in.pwskills.nitin.exception;

public class StudentRecordNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentRecordNotFoundException() {
		System.out.println("Student Not Found");
	}
	
	public StudentRecordNotFoundException(String str) {
		super(str);
	}
}
