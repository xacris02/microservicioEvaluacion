# SmokeGamesBack
Aqui tendremos el back del proyecto
Estrategia de Control de Versiones: GitFlow

Para el desarrollo de este microservicio, el Grupo 10 ha decidido implementar la estrategia GitFlow. 
Se seleccionó GitFlow porque proporciona trabajo estructurado, seguro y organizado para el desarrollo colaborativo.
Nuestra elección se fundamenta en los siguientes puntos
1. La rama main se mantiene estrictamente para código estable. Solo recibe código que ya ha sido probado.
2. La rama develop actúa como nuestro entorno de pruebas. Nos permite a los desarrolladores poner nuestras partes y verificar que el microservicio funcione antes de un lanzamiento.
3. El uso de ramas feature/ permite que cada integrante del equipo trabaje sin afectar el codigo del otro.
4. Se nos permite usar ramas hotfix/ para aplicar parches urgentes directamente a main si el microservicio falla, sin tener que arrastrar código incompleto.