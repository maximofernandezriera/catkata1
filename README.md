# Cat Kata, Part 1

## https://www.codewars.com/kata/5869848f2d52095be20001d1/train/java

## Una lectura avanzada del enunciado

- El objetivo de este ejercicio es determinar si la distancia entre gatos en un jardín es suficiente para evitar conflictos.

La historia detrás del ejercicio es sobre gatos de vecindario que tratan de reclamar un territorio después de que el gato residente, Balor, fallece. Para mantener la paz, es necesario asegurar que los gatos estén lo suficientemente alejados unos de otros.

El reto es el siguiente:

- Recibiendo como entrada un array de cadenas que representan el jardín como una cuadrícula, y un entero que representa la distancia mínima necesaria para prevenir problemas.
- Un punto sin gato se representará con un guion ("-"). Los gatos Lou, Mustache Cat y Raoul se representarán con una "L", "M" y "R" mayúsculas respectivamente.
- Puede haber hasta tres gatos en el jardín, dos, uno o ninguno en un momento dado.
- El ejercicio pide que determines si la situación es pacífica o no. Si hay uno o ningún gato, o si la distancia entre todos los gatos es al menos la mínima requerida, tu función debe devolver True. Si hay dos o tres gatos y la distancia entre al menos dos de ellos es menor que la distancia mínima, la función debe devolver False.


### Análisis del problema (qué necesito después de esa lectura avanzada):

1. **Función `isPeaceful`**: Esta función toma dos argumentos: un array `yard` que representa el jardín, y un entero `minDistance` que es la distancia mínima de seguridad entre los gatos.

2. **Inicialización de Variables**:
   - `cats`: Un array para almacenar las coordenadas de los gatos detectados.
   - `catCount`: Un contador para llevar la cuenta del número de gatos encontrados.

3. **Búsqueda de gatos**:
   - Se recorre el array `yard`. Si se encuentra un gato (indicado por 'L', 'M' o 'R'), se almacena su posición (coordenadas `i` y `j`) en `cats`.

4. **Cálculo y verificación de Distancias**:
   - Se calculan las distancias entre todos los pares de gatos usando la fórmula de distancia euclidiana.
   - Si alguna de las distancias es menor que `minDistance`, se retorna `false`.

5. **Resultado**:
   - Si todas las distancias entre gatos son mayores o iguales a `minDistance`, se retorna `true`.
  
## Visualización del jardín:

Para visualizar mejor cómo funciona yard[i][j], consideramos el siguiente jardín:


      yard = ["--L-", "-R--", "M---"]
      Representación como cuadrícula:

       0 1 2 3
      0 - - L -
      1 - R - -
      2 M - - -

Cada fila del jardín es un string dentro del array yard.

yard[0] es --L-, que representa la fila superior del jardín.
yard[1] es -R--, que representa la segunda fila.
yard[2] es M---, que representa la tercera fila.

Cuando accedemos a yard[i][j], i selecciona una de estas filas, y j selecciona un carácter dentro de esa fila. Por ejemplo:

* yard[0][2] accede al tercer carácter de la primera fila ('L'), ya que estamos contando desde 0.
* yard[2][0] accede al primer carácter de la tercera fila ('M').

```
Función isPeaceful(yard: Array de dos dimensiones, minDistance: Entero) retorna Booleano
    Inicializar cats como Array de Entero[longitud máxima posible][2]
    Inicializar catCount como 0

    // Buscar posiciones de gatos
    Para cada fila i en yard
        Para cada columna j en fila
            Si yard[i][j] es 'L', 'M' o 'R'
                cats[catCount][0] = i  // Coordenada x
                cats[catCount][1] = j  // Coordenada y
                Incrementar catCount

    // Calcular y verificar distancias
    Para cada i de 0 a catCount
        Para cada j de i+1 a catCount
            Calcular dx = cats[i][0] - cats[j][0]
            Calcular dy = cats[i][1] - cats[j][1]
            Calcular distancia como raíz cuadrada de (dx^2 + dy^2)

            Si distancia < minDistance
                Retornar falso

    Retornar verdadero
Fin de la Función
