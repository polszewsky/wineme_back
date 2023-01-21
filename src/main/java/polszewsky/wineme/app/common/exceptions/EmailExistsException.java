package polszewsky.wineme.app.common.exceptions;

public class EmailExistsException extends Exception {

    public EmailExistsException(String errorMessage){
        super(errorMessage);
    }
}
