package tri.chung.newsapp.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class AbtractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@Column
	protected Timestamp createdDate;
	@Column
	protected Timestamp modifedDate;
	@Column
	protected String createdBy;
	@Column
	protected String modifiedBy;
}
