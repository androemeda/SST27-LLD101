package com.example.notifications;

/**
 * Base decorator class that wraps another Notifier.
 * This is the core of the Decorator pattern implementation.
 */
public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void notify(String text) {
        wrappedNotifier.notify(text);
    }
}