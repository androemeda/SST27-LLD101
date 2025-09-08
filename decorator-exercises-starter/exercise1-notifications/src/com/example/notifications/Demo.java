package com.example.notifications;

public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline behavior (already works)
        base.notify("Baseline email only.");
        
        System.out.println("\n=== Testing Different Notification Combinations ===");
        
        System.out.println("\n1. Email + SMS:");
        Notifier smsAndEmail = new SmsDecorator(base, "+91-99999-11111");
        smsAndEmail.notify("Build green");
        
        System.out.println("\n2. Email + WhatsApp:");
        Notifier whatsAppAndEmail = new WhatsAppDecorator(base, "user_wa");
        whatsAppAndEmail.notify("Code review completed");
        
        System.out.println("\n3. Email + Slack:");
        Notifier slackAndEmail = new SlackDecorator(base, "development");
        slackAndEmail.notify("Database migration finished");
        
        System.out.println("\n4. Email + WhatsApp + Slack:");
        Notifier fullNotification = new SlackDecorator(new WhatsAppDecorator(base, "user_wa"), "deployments");
        fullNotification.notify("Deployment completed ");
    }
}
