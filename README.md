# irregular_verbs
An app for praticing english irregular verbs.

./irregular_verbs/irregular_verbs

mvn clean install -U -Dmaven.test.skip=true



For execute
===========
./irregular_verbs/irregular_verbs/irregular_verbs_desktop

$ mvn clean javafx:run

*create a jar with dependencies in lib folder* (requires that javafx modules are availables) --> NO RECOMMENDED
=============================================
First, we need change the setting of maven-assembly-plugin at iverbs-desktop/pom.xml, property <descriptor>src/main/assembly/assembly_jar.xml</descriptor>

$ mvn clean package assembly:single

To create a custom runtime, using th JavaFX Maven plugin:
=========================================================
First, we need change the setting of maven-assembly-plugin at iverbs-desktop/pom.xml, property <descriptor>src/main/assembly/assembly_image.xml</descriptor>

$ mvn clean javafx:jlink assembly:single

Linux / Mac:

/iverbsdesktop/target/irregular-verbs-image/bin/irregular-verbs-launcher

Windows:

iverbsdesktop\target\irregular-verbs-image\bin\launcher

Generate native package (deb, rpm, msi, exe...)

jpackage --name iverbs --app-image irregular-verbs-image

options:

--type {"app-image", "exe", "msi", "rpm", "deb", "pkg", "dmg"}

--linux-shortcut or --win-shortcut

--win-menu --win-menu-group or --linux-menu-group

--win-dir-chooser 
