# irregular_verbs
An app for praticing english irregular verbs.

./irregular_verbs/irregular_verbs

mvn clean install -U -Dmaven.test.skip=true



For execute

./irregular_verbs/irregular_verbs/irregular_verbs_desktop

mvn clean javafx:run

To create a custom runtime, using th JavaFX Maven plugin:

mvn clean javafx:jlink

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
