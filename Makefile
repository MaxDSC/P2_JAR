#Папка с внешними библиотеками (для проверки стиля и форматирования по стилю)
LIB=lib
#относительный путь до package проекта
SRC=src/main/java
#корневая папкам куда уходят компилированные файлы
TRG=target
#корневой путь до package, где квесты
Q=maxdsc/quests
# тотже путь, но в формате через точку
PKG=maxdsc.quests

check:
	java -jar $(LIB)/checkstyle-10.21.3-all.jar -c $(LIB)/google_checks.xml $$(find $(SRC) -name "*.java")

format:
	java -jar $(LIB)/google-java-format-1.25.2-all-deps.jar -i $$(find $(SRC) -name "*.java")

q1: compile_q1
	jar cfm $(TRG)/P2_JAR.jar Manifest.txt -C $(TRG) .

compile_q1:
	javac -Werror -d $(TRG) -sourcepath $(SRC) $(SRC)/$(Q)/Main.java

clean:
	rm -r $(TRG)
