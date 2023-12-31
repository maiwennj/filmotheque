package fr.eni.filmotheque.bo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Film  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Vous devez renseigner un titre.")
	private String title;
	@NotBlank(message = "Vous devez renseigner une année de sortie.")
	private String releaseYear;
	@Min(0)
	private int duration;
	@NotBlank(message = "Vous devez renseigner un synopsis.")
	@Size(min=0, max=500)
	private String synopsis;

	// Relations objets
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Genre genre;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Author> actors;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Author director;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Comment> comments;
	
}
