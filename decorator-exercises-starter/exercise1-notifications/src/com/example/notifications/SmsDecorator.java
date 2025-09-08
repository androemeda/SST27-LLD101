package com.example.notifications;

/**
 * Concrete decorator that adds SMS notification functionality.
 */
public class SmsDecorator extends NotifierDecorator {
    private final String phoneNumber;

    public SmsDecorator(Notifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        sendSms(text);
    }

    private void sendSms(String text) {
        System.out.println("[SMS -> " + phoneNumber + "]: " + text);
    }
}