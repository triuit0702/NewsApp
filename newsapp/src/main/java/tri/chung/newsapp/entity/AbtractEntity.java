package tri.chung.newsapp.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbtractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Timestamp createdDate;
	@Column
	private Timestamp modifedDate;
	@Column
	private String createdBy;
	@Column
	private String modifiedBy;
}
