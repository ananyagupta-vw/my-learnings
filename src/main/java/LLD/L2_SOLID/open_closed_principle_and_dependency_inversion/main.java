package LLD.L2_SOLID.open_closed_principle_and_dependency_inversion;

class Main {
    public static void main(String[] args) {
        NotificationService emailService = new NotificationService(new EmailNotificationService());
        emailService.notifyUser("Your order has been shipped!");

        NotificationService smsService = new NotificationService(new SMSNotificationService());
        smsService.notifyUser("Your order has been delivered!");
    }
}
