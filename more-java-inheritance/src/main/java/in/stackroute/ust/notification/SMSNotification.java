package in.stackroute.ust.notification;

public class SMSNotification implements Notification{
    @Override
    public void notifyUser(){
        System.out.println("SMS Notification send");
    }
}
