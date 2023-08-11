package fr.eni.filmotheque.bo;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

	int id;
	
	@NotBlank(message = "Vous devez renseigner un titre")
	String title;
	
	@NotBlank(message = "Vous devez renseigner une année de sortie")
	String releaseYear;
	
	@Min(0)
	int duration;
	
	@NotBlank(message = "Vous devez renseigner un synopsis")
	@Size(min=0, max=500)
	String synopsis;
	
}
