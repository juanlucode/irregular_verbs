/**
 * 
 */
/**
 * @author juanlucode
 *
 */
module io.github.juanlucode.iverbs.core {
	
	requires com.google.gson;
	
	
	opens io.github.iverbs.core.model to com.google.gson, io.github.juanlucode.iverbcoretest;
	exports io.github.iverbs.commons;
	exports io.github.iverbs.core.model;
	exports io.github.iverbs.core;
    exports io.github.iverbs.core.model.enumeration;
    opens io.github.iverbs.core.model.enumeration to com.google.gson, io.github.juanlucode.iverbcoretest;
	exports io.github.iverbs.core.model.value;
	opens io.github.iverbs.core.model.value to com.google.gson, io.github.juanlucode.iverbcoretest;


}