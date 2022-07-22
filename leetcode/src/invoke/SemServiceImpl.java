package invoke;

public class SemServiceImpl implements SmsService {

    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
