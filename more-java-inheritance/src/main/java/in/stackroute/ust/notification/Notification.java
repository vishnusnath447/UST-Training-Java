package in.stackroute.ust.notification;

public interface Notification {
    public void notifyUser();
    default void defaultNotification(){
        System.out.println("This is a default notification");
    }
}
