set "path=%path%;C:\Program Files\Java\jdk1.8.0_121\bin"
echo %path%
cd src
cd main
cd java
javac -cp "../../../src/main/java;../../../libs/log4j-1.2.17.jar;../../../libs/junit-4.12.jar" main/Main.java
pause
