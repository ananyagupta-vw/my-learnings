package LLD.L2_SOLID.open_closed_principle_and_dependency_inversion;

// Open/Closed Principle (OCP) states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
// In other words, you should be able to add new functionality to a class without changing the existing code.
// This can be achieved through the use of interfaces, abstract classes, and polymorphism.

interface NotificationServiceInterface {
    void sendNotification(String message);
}

class EmailNotificationService implements NotificationServiceInterface {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

class SMSNotificationService implements NotificationServiceInterface {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

public class NotificationService {
   private NotificationServiceInterface sender;

   // Dependency Inversion Principle (DIP) states that high-level modules should depend on abstractions rather than concrete implementations.
   // Both should depend on abstractions (e.g., interfaces).

   NotificationService(NotificationServiceInterface sender) {
       this.sender = sender;
   }

    public void notifyUser(String message) {
         sender.sendNotification(message);
    }
}





