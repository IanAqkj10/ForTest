import org.springframework.context.ApplicationEvent;

/**
 * @Description:
 * @author:ljh
 * @date:2022/3/23 14:45
 */

public class EvenDemo extends ApplicationEvent {
    private static final long serialVersionUID = 1L;

    private String message;

    public EvenDemo(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}