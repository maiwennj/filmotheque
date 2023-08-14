package fr.eni.filmotheque.bo;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Film {

	int id;
	
	@NonNull
	@NotBlank(message = "Vous devez renseigner un titre")
	String title;
	
	@NonNull
	@NotBlank(message = "Vous devez renseigner une année de sortie")
	String releaseYear;
	
	@NonNull
	@Min(0)
	int duration;
	
	@NonNull
	@NotBlank(message = "Vous devez renseigner un synopsis")
	@Size(min=0, max=500)
	String synopsis;
	
	Genre genre;
	
	public Film(int id,String title,String releaseYear,int duration,String synopsis) {
		this.duration=duration;
		this.id=id;
		this.title=title;
		this.synopsis=synopsis;
		this.releaseYear=releaseYear;
	}
}
