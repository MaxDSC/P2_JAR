#корневая директория
ROOT_DIR=~/my_java_projects
#название проекта
PRJ=P2_JAR
#где лежат package проекта
SRC=$(ROOT_DIR)/$(PRJ)/src/main/java
#корневая папкам куда уходят компилированные файлы
TRG=$(ROOT_DIR)/$(PRJ)/target
#корневой путь до package, где квесты
Q=maxdsc/quests
# тотже путь, но в формате через точку
PKG=maxdsc.quests
# пути до квестов
Q1=$(Q)/divider
#пути до квестов через точку
PKG1=$(PKG).divider


check:
	java -jar $(ROOT_DIR)/checkstyle-10.21.3-all.jar -c $(ROOT_DIR)/google_checks.xml $$(find $(SRC) -name "*.java")

format:
	java -jar $(ROOT_DIR)/google-java-format-1.25.2-all-deps.jar -i $$(find $(SRC) -name "*.java")

q1: compile_q1
	jar cfm $(TRG)/P2_JAR.jar Manifest.txt -C $(TRG) .

compile_q1:
	javac -Werror -d $(TRG) $(SRC)/$(Q)/Main.java

clean:
	rm -r $(TRG)
