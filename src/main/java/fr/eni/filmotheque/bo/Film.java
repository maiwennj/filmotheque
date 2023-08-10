package fr.eni.filmotheque.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

	int id;
	String title;
	String releaseYear;
	int duration;
	String synopsis;
	
}
