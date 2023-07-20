package in.stackroute.ust;

import in.stackroute.ust.notification.EmailNotification;
import in.stackroute.ust.notification.IMNotification;
import in.stackroute.ust.notification.Notification;
import in.stackroute.ust.notification.SMSNotification;

public class Main {
    public static void main(String[] args) {
        Notification notification;
        Main mainObject = new Main();

        notification=new IMNotification();
        mainObject.sendNotification(notification);

        notification=new EmailNotification();
        mainObject.sendNotification(notification);

        notification=new SMSNotification();
        mainObject.sendNotification(notification);

    }

    public void sendNotification(Notification notification){
        if(notification instanceof EmailNotification){
            System.out.println("Email:");
            notification.notifyUser();
        } else if (notification instanceof SMSNotification) {
            System.out.println("SMS:");
            notification.notifyUser();
        } else if (notification instanceof IMNotification) {
            System.out.println("IM:");
            notification.notifyUser();
        }
    }
}