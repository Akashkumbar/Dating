package in.Meghana.Service;

import java.util.List;

import in.Meghana.Entity.Notification;

public interface NotificationService {

	Notification create(Notification n);
	List<Notification> getAllNotifications(Long receiver);
	
}
