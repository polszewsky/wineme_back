package polszewsky.wineme.app.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CustomStateException  extends RuntimeException {
        private final String message;
        private final HttpStatus httpStatus;
        private final String errorCode;

        public CustomStateException(String message) {
            this.message = message;
            this.httpStatus = null;
            this.errorCode = "";
        }

        public CustomStateException(String message, HttpStatus httpStatus) {
            this.message = message;
            this.httpStatus = httpStatus;
            this.errorCode = "";
        }

}
