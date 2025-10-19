ACTIVIDAD 1.3 - SUMA DE DOS NÚMEROS

Autor: Pilar
Paquete: procesosJava.practica13

Descripción:
El proyecto tiene dos programas Java:

1. Suma.java
Recibe dos números enteros como argumentos.
Valida que sean numéricos.
Muestra la suma por pantalla o un mensaje de error.

2. ProcesoSuma.java
Solicita dos números al usuario por teclado.
Llama a la clase Suma mediante un ProcessBuilder.
Muestra el resultado devuelto por el proceso.

Estructura de clases:
Suma
Métodos:
 main(String[] args): realiza la suma de los dos números introducidos.

ProcesoSuma
Métodos:
 main(String[] args): solicita datos, crea un proceso y muestra el resultado.

Ejecución:
1. Compilar las clases:
javac procesosJava/practica13/*.java

2. Ejecutar el programa principal:
java procesosJava.practica13.ProcesoSuma

Ejemplo:
Dime el primer número:
15
Dime el segundo número:
30
15 + 35 = 50
