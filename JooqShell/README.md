 **utworzenie classpath**
Do pliku lub do zmiennej systemowej
mvn dependency:build-classpath -DincludeTypes=jar -Dmdep.outputFile=.cp.txt -f JooqShell/pom.xml 

jshell --class-path `cat .cp.txt`:target/classes