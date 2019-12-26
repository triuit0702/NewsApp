package tri.chung.newsapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter; 

@Getter
@Setter
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "category_id")
	//@JsonManagedReference
	@JsonBackReference 
	private CategoryEntity category;
}
