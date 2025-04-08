package in.Meghana.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long sender;//the person me who is interested 
	private Long receiver;//user who receives the notification
	//the person on whom I have interest on 
	private String message;
	private LocalDateTime time;

}
