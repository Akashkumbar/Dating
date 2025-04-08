package in.Meghana.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Meghana.Entity.Notification;
import in.Meghana.Repository.NotificationRepo;
import in.Meghana.Service.NotificationService;
@Service
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	private NotificationRepo repo;
	@Override
	public Notification create(Notification n) {
		// TODO Auto-generated method stub
		return repo.save(n);
	}

	@Override
	public List<Notification> getAllNotifications(Long receiver) {
		// TODO Auto-generated method stub
		return repo.getAllNotification(receiver);
	}

}
