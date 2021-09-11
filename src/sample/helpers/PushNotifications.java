package sample.helpers;

import io.github.palexdev.materialfx.controls.MFXDialog;
import io.github.palexdev.materialfx.controls.MFXNotification;
import io.github.palexdev.materialfx.controls.SimpleMFXNotificationPane;
import io.github.palexdev.materialfx.notifications.NotificationPos;
import io.github.palexdev.materialfx.notifications.NotificationsManager;
import javafx.scene.layout.Region;
import javafx.util.Duration;
import java.sql.Time;

public class PushNotifications {

    public PushNotifications() {
    }

    public void showNotification(String type) {
        MFXNotification notification = buildNotification(type);
        NotificationPos pos = NotificationPos.TOP_CENTER;
        NotificationsManager.send(pos, notification);
    }
    public void showNotification(String type, String firstName, String lastName, Time time) {
        MFXNotification notification = buildNotification(type, firstName, lastName, time);
        NotificationPos pos = NotificationPos.TOP_CENTER;
        NotificationsManager.send(pos, notification);
    }

    private MFXNotification buildNotification(String type) {
        Region template = getTemplate(type);
        MFXNotification notification = new MFXNotification(template, true, true);
        notification.setHideAfterDuration(Duration.seconds(2.5));

        if (template instanceof SimpleMFXNotificationPane) {
            SimpleMFXNotificationPane pane = (SimpleMFXNotificationPane) template;
            pane.setCloseHandler(closeEvent -> notification.hideNotification());
        } else {
            MFXDialog dialog = (MFXDialog) template;
            dialog.setCloseHandler(closeEvent -> notification.hideNotification());
        }

        return notification;
    }

    private MFXNotification buildNotification(String type, String firstName, String lastName, Time time) {
        Region template = getTemplate(type, firstName, lastName, time);
        MFXNotification notification = new MFXNotification(template, true, true);
        notification.setHideAfterDuration(Duration.seconds(3));

        if (template instanceof SimpleMFXNotificationPane) {
            SimpleMFXNotificationPane pane = (SimpleMFXNotificationPane) template;
            pane.setCloseHandler(closeEvent -> notification.hideNotification());
        } else {
            MFXDialog dialog = (MFXDialog) template;
            dialog.setCloseHandler(closeEvent -> notification.hideNotification());
        }

        return notification;
    }

    private Region getTemplate(String type, String firstName, String lastName, Time time) {
        switch (type) {
            case "INVALIDUSER": {
                return new SimpleMFXNotificationPane(
                        "Obavijest",
                        "Kartica nije valjana.",
                        "Došlo je do problema."
                );
            }
            case "IN": {
                return new SimpleMFXNotificationPane(
                        "Ulazak",
                        "Dobro došli " + firstName + " " + lastName,
                        "Vrijeme: " + time
                );
            }
            case  "OUT" : {
                return new SimpleMFXNotificationPane(
                        "Izlazak",
                        "Doviđenja " + firstName + " " + lastName,
                        "Vrijeme: " + time
                );
            }
            default: {
                return null;
            }
        }
    }

    private Region getTemplate(String type) {
        switch (type) {
            case "INVALIDCARD": {
                return new SimpleMFXNotificationPane(
                        "Obavijest",
                        "Kartica nije valjana.",
                        "Vaša kartica ne postoji u bazi."
                );
            }
            default: {
                return null;
            }
        }
    }
}
