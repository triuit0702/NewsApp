package tri.chung.newsapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class CommenEntity extends AbtractEntity {

	@Column
	private String content;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
}
