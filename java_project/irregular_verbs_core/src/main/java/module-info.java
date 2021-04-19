/**
 * 
 */
/**
 * @author juanlucode
 *
 */
module irregular_verbs_core_module{
	
	requires com.google.gson;
	
	
	opens io.github.juanlucode.irregular_verbs_core.models to com.google.gson, irregular_verbs_coreTest;
	exports io.github.juanlucode.commons;
	exports io.github.juanlucode.irregular_verbs_core.models;
	exports io.github.juanlucode.irregular_verbs_core;
	
	

	
}