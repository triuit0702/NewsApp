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
	@Column(name="created_date")
	protected Timestamp createddate;
	@Column(name="modifed_date")
	protected Timestamp modifedDate;
	@Column(name="created_by")
	protected String createdBy;
	@Column(name="modified_by")
	protected String modifiedBy;
}
