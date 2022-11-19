package jonathas.IBNCM_API.services.exceptions;

import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found : ID" + id );
	}
	


}
