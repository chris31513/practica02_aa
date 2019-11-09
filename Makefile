all:
	javac src/Grafica.java
	java src/Grafica

clean:
	rm src/*.class
	rm Salida*