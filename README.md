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

Naming de Ramas
El equipo ha definido la siguiente estructura de ramas para organizar el trabajo:
develop: Rama principal donde se integra el trabajo del equipo de desarrollo.
feature/Alvaro: Rama de trabajo individual de Álvaro.
feature/Juan: Rama de trabajo individual de Juan.
hotfix/Grupo10: Rama dedicada exclusivamente a la corrección de bugs o errores de emergencia (hotfix).

 
Convenciones de Commits y Flujos de Merge
Se actualizo el mensaje de respuesta de la linea 31 y la linea 33 desde la rama feature.
Se hace envio de con error en linea 61 de feature a develop.
Se hace envio el codigo comentando el error a la rama hotfix para su solución desde la rama develop.
De hotfix se hace envio el codigo corregido hacia develop.

 
Estrategias de Revisión
Uso de Pull Requests (PR): Toda integración de código hacia la rama develop se realiza mediante un Pull Request en GitHub, dejando un registro visual de los cambios.
Verificación Local: Antes de aceptar un Pull Request, el código se debe probar localmente.
Comunicación Interna: Se comenta al compañero sobre los cambios que se van realizando.
Resolución de Conflictos: Si Github detecta un conflicto de merge, comparar ambos códigos y resolver el conflicto manualmente. (Nos paso cuando Alvaro no podia hacer un mergue, ya que habia conflicto en el archivo Radme.txt)

Estructura de Carpetas
Para mantener el orden del microservicio, el equipo debe respetar esta estructura:
controller/: Para los controladores REST.
model/: Para las entidades de la base de datos.
repository/: Para las interfaces de acceso a datos.
.github/workflows/: Carpeta exclusiva para los pipelines DevOps.

Reglas de Commits Oficiales
Además de registrar nuestros cambios, el equipo establece usar prefijos para estandarizar el historial:
feat: (nuevas funcionalidades).
fix: (arreglos urgentes).
docs: (documentación).

Automatización y CI/CD
Se configuró GitHub Actions como nuestra herramienta de automatización. Su rol fundamental en nuestro proceso CI/CD es garantizar la Integración Continua (CI): el pipeline se ejecuta automáticamente con cada push a develop y PR a main, verificando el flujo sin que tengamos que hacerlo manualmente.