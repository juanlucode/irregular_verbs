/**
 * 
 */
/**
 * @author juanlucode
 *
 */
module io.github.juanlucode.iverbscore{
	
	requires com.google.gson;
	
	
	opens io.github.juanlucode.iverbscore.models to com.google.gson, io.github.juanlucode.iverbcoretest;
	exports io.github.juanlucode.commons;
	exports io.github.juanlucode.iverbscore.models;
	exports io.github.juanlucode.iverbscore;
	
	

	
}