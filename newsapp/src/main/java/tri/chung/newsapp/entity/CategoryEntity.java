package tri.chung.newsapp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "category")
public class CategoryEntity extends AbtractEntity {

	@Column
	private String name;
	@Column
	private String code;
	@OneToMany(mappedBy = "category")
	private List<NewEntity> news;
}
