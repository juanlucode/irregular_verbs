package io.github.iverbs.core;

import java.util.Scanner;

import io.github.iverbs.core.model.business.QuestionaryBO;
import io.github.iverbs.core.model.business.RepositoryBO;
import io.github.iverbs.core.model.value.*;
import io.github.iverbs.core.model.enumeration.Level;
import io.github.iverbs.core.model.enumeration.VerbForm;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);


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
    	
    	System.out.println("Generating questionaryVO...");
    	QuestionaryVO questionaryVO = RepositoryBO.generateQuestionary(NUM_QUESTIONS, Level.values()[level]);
    	
    	System.out.println();
    	
    	VerbVO verbAsked = null;
    	for (QuestionVO questionVO : questionaryVO.getQuestions()) {
    		verbAsked = questionVO.getVerbResponse();
    		
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
       			for ( String opt : questionVO.getTranslateOps() ) {
       				System.out.println(String.format(" [%d] - %s ", ++i, opt));
       			}
       			System.out.println("Write the correct option: ");
       			verbAsked.set(VerbForm.TRANSLATE, questionVO.getTranslateOps()[scanner.nextInt()-1]);
       		}

       			
    	}
    	
    	scanner.close();
    	
    	// Results
    	System.out.println("");
    	System.out.println("******************");
    	System.out.println("* Result of test *");
    	System.out.println("******************");
    	System.out.println(QuestionaryBO.check(questionaryVO.getQuestions()));

    }
    
    
}

// https://blog.openalfa.com/como-leer-y-escribir-ficheros-json-en-java