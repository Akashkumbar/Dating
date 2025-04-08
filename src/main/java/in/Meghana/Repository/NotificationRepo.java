package in.Meghana.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.Meghana.Entity.Notification;

public interface NotificationRepo  extends JpaRepository<Notification, Long>{

	@Query("select n from Notification n where n.receiver=:receiver")

	List<Notification> getAllNotification(Long receiver);
}
