# irregular_verbs
An app for praticing english irregular verbs.

./irregular_verbs/irregular_verbs

mvn clean install -U -Dmaven.test.skip=true



For execute

./irregular_verbs/irregular_verbs/irregular_verbs_desktop

mvn clean javafx:run

To create a custom runtime, using GraalVM (adapted by Gluon) Reference https://github.com/juanlucode/despachaJava/blob/master/process_to_native.txt :
 1. Open "x86_x64 Cross Tools Command Prompt for VS 2019" console.
 2. Creating exe file: 
 	# cd iverbs-desktop
 	# mvn clean fluonfx:build
 3. Creating msi file:
 	# mvn gluonfx:package (Requires the exe file generated in previous step)