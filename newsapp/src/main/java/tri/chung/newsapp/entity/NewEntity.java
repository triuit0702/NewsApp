package tri.chung.newsapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "New")
public class NewEntity extends AbtractEntity {

	@Column
	private String title;
	@Column
	private String thumbnail;
	@Column
	private String shortdescription;
	@Column
	private String content;
	@ManyToOne
	@JoinColumn(name= "category_id")
	private CategoryEntity category;
}
