package io.github.juanlucode.irregular_verbs_core;

import java.util.Scanner;

import io.github.juanlucode.irregular_verbs_core.models.Level;
import io.github.juanlucode.irregular_verbs_core.models.Question;
import io.github.juanlucode.irregular_verbs_core.models.Questionary;
import io.github.juanlucode.irregular_verbs_core.models.Repository;
import io.github.juanlucode.irregular_verbs_core.models.Verb;
import io.github.juanlucode.irregular_verbs_core.models.VerbForm;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);
    	
    	Repository repository = new Repository();
    	
    	final byte NUM_QUESTIONS = 10;
    	
    	byte level = 0;
    	
    	System.out.println("********************************");
    	System.out.println("* English irregular verbs test *");
    	System.out.println("********************************");
    	System.out.println();
    	
    	System.out.println("Select level [0 = Easy | 1 = Medium | 2 = Hard]");
    	do {
    		level = scanner.nextByte();
    	} while ( level < 0 && level > 2);
    	
    	System.out.println("Generating questionary...");
    	Questionary questionary = repository.generateQuestionary(NUM_QUESTIONS, Level.values()[level]);
    	
    	System.out.println();
    	
    	Verb verbAsked = null;
    	for (Question question : questionary.getQuestions()) {
    		verbAsked = question.getVerbResponse();
    		
    		System.out.println(verbAsked);
    		
    		// infinitive
    		if ( verbAsked.get(VerbForm.INFINITIVE) == null ) {
    			System.out.println("[Infinitive]: " );
    			verbAsked.set(VerbForm.INFINITIVE, scanner.next());
    		}

    		// past
    		if ( verbAsked.get(VerbForm.PAST) == null ) {
    			System.out.println("[Past]: ");
    			verbAsked.set( VerbForm.PAST, scanner.next());
    		}
    		
    		// participle
       		if ( verbAsked.get(VerbForm.PARTICIPLE) == null ) {
    			System.out.println("[Participle]: ");
    			verbAsked.set(VerbForm.PARTICIPLE, scanner.next());
    		}    	
       		
       		// translate
       		if ( verbAsked.get(VerbForm.TRANSLATE) == null) {
       			System.out.println("[Translate]: ");
       			byte i =  0;
       			for ( String opt : question.getTranslateOps() ) {
       				System.out.println(String.format(" [%d] - %s ", ++i, opt));
       			}
       			System.out.println("Write the correct option: ");
       			verbAsked.set(VerbForm.TRANSLATE, question.getTranslateOps()[scanner.nextInt()-1]);
       		}

       			
    	}
    	
    	scanner.close();
    	
    	// Results
    	System.out.println("");
    	System.out.println("******************");
    	System.out.println("* Result of test *");
    	System.out.println("******************");
    	System.out.println(questionary.check());

    }
    
    
}

// https://blog.openalfa.com/como-leer-y-escribir-ficheros-json-en-java