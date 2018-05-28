Reto
Buscar los 10 precios m�s baratos de tiquetes de la pagina de despegar 
Origen: Medell�n Destino: Cartagena Viajeros dos personas Fecha Inicio 01 de septiembre de 2018 Fecha Regreso 29 de septiembre
Guardar en Excel los 7 precios mas baratos de la primera p�gina del sitio. 
Marcar en verde el precio mas econ�mico.

Resumen de la codificacion
Se crea el proyecto en el IDE de eclipse con gradle y cucumber, se crean cuatro paquetes:
- configurations En este paquete se almacena la clase "ShareDriver" donde se codifican las diferentes operaciones que se deben realizar cada vez que se ejecute alg�n escenario tal como, abrir el navegador (Chrome en este caso), maximizar la ventana, etc.
- pages: Se almacenan en este paquete las clases asociadas a las paginas a las cuales se accedera y se realizar� alguna operacion en alguno de sus componentes. En dichas clases se c�dificara el acceso y operacion sobre los diferentes objetos (botones, cajas de texto, listas desplegables, etc.)
que ser�n utilizadas en la ejecuci�n de los diferentes casos automarizados. Para este reto puntualmente se crearon dos paginas: DespegarPpalPage el cual tiene todos los objetos de la p�gina principal de despegar incluyendo el link de "Vuelos" los campos de texto de las ciudades de origen y destino, los campos de fechas de inicio y regreso, el campo de cantidad de pasajeros (con sus objetos internos) y el bot�n de busqueda. La otra clase creada fue ResultadoBusquedaPage, el cual contiene todos los objetos de la pagina de resultado de busqueda que se necesitan en la ejecuci�n de los diferentes escenarios, tales como; lista desplegable para ordenar los resultados de busqueda y link para ver los resultados de la busqueda con diferentes aerolineas ("Diferentes compa�ias")
- runners Contiene la clase con el c�digo "traductor" entre java y el lenguaje gherkin escrito en los escenarios en cucumber, aqui se especifica donde el nombre del paquete donde se almacenan los escenarios en gherkin y el nombre del paquete donde se almacenan los steps de esos escenarios
- stepDefinitios Contiene la clase con todos los pasos descritos en el feature pero ya en lenguaje java, cada step invoca un objeto de las paginas anteriormente descritas donde se hace una operaci�n especifica de acuerdo a lo descrito en los steps del escenario en gherkin, algunos tienen adicionalmente l�gica (ej for)
- utiliades: En este paquete se almacena una clase que tienen diferentes clases que pueden ser utilizados en cualquier escenario y son transversales a toda la automatizaci�n (ej: wait, calcularMes, calcularDiaMes, funci�n de excel para escribir en un archivo)
- projectFeatures: aqui se encuentra el feature (en cucumber) con todos los escenarios planteados para la automatizaci�n, se plantearon 3 escenarios, 1 exitoso y dos alternos.

Los tres escenarios a probar son
Escenario exitoso Se hace una busqueda de los vuelos de Medellin hac�a Cartagena con fecha de salida el 1 de septiembre y de regreso el 29 de septiembre con dos pasajeros, el resultado de la busqueda se ordena por precio de menor a mayor, se almacena en un excel ya existente con nombre "tiquetesDespegar.xlsx" los 7 registros mas baratos y la celda que tiene el precion menor se pinta de verde
Escenario alterno Se hace una busqueda de los vuelos con origen y destino iguales (Medell�n) ingresando las mismas fechas del escenario exitoso y evidenciando que cuando se presione el bot�n Buscar se muestre un mensaje indicando que el destino debe ser diferente al origen
Escenario alterno2 Se hace una busqueda de los vuelos con las mismas condiciones del escenario exitosos pero se deja vacio el campo de fecha de regreso y evidenciando que cuando se presione el bot�n Buscar se muestre un mensaje indicando que se debe digitar una fecha de regreso


Framework: Junit, con cucumber y gradle
Compilador Eclipse Oxigen
Navegador Chrome version 66, webdrive Chromedriver version 2.38
Herramienta de automatizaci�n Selenium con Java
patrones de desarrollo Page Object Model, TDD
practicas de automatizaci�n BDD con cucumber

Estrategia de automatizaci�n Lo primero que se hizo fue realizar una prueba manual de lo que se ped�a en el reto con el fin de identificar los diferentes objetos que se deben mapear, la forma en que se debe ejecutar, cuantas paginas interactuan, etc. Esto se realiz� tanto para el escenario exitoso como para los escenarios alternos.
Desp�es de realizar la prueba manual se procedi� a crear el proyecto con sus diferentes paquetes, se agregaron las dependencias que se necesitan para el proyecto, se creo el feature y se escribieron en lenguaje gherkin los tres escenarios a probar. Con los escenarios descritos se procedio a crear la clase de configuraci�n para poder iniciar la ejecuci�n de los diferentes escenarios.Posteriormente, se procedi� a crear las clases que alojaran los objetos de las paginas identificadas en la prueba manual, y se crearon las diferentes clases con los mapeos y acciones sobre los objetos de las p�ginas.
Luego, se creo la clase que tendr�a todos los steps de los pasos y se empezaron a colocar cada uno de los pasos que se escribieron en el feature, y se  c�difica la acci�n que solicitaba el paso, al mismo tiempo, se creo en el paquete runners la clase con la informaci�n necesaria para ejecutar los casos descritos en el feature con los pasos escritos en la clase de steps. Por cada paso que se implementaba en la clase de steps se ejecutaba en runner con el fin de garantizar que la clase c�dificada realizara la acci�n descrita en el paso del escenario en el feature, y de ser necesario realizar las modificaciones necesarias. Para aquellas acciones que eran necesarias en diferentes pasos o que eran invocadas por diferentes clases (ej: wait, calcularMes, etc.) se creo una clase de utilidades desde donde podian ser invocadas desde la clase que las necesitaban.
Finalmente, se prueba el escenario completo, evidenciando que la automatizaci�n realizar� lo que indicase el escenario.

Conclusiones de la automatizaci�n
- La practica de automatizaci�n BDD es muy util para automatizar pruebas ya que ayuda a tener una mayor cobertura de casos de prueba y que no se omitan casos importantes, adicionalmente, ayuda a que se pruebe acci�n por acci�n y que no se trate de probar con un paso o clase mas de una cosa, lo que ayuda a que la automatizaci�n sea mas facil de mantener en el tiempo.
- La practica de desarrollo TDD ayuda a que se puedan automatizar pruebas sobre la herramienta mas f�cilmente puesto que el desarrollo es muy modular y permite acceder a las diferentes opciones, clases, funcionalidades, etc. mas f�cilmente
- Es muy importante que una p�gina web este correctamente c�dificada y su html tenga buenos identificadores para que a la hora de automatizarla sea mucho mas f�cil y mantenible. En el caso de la p�gina despegar se evidencio que no ten�a identificador adecuados (tales como Id, name, etc,) lo que dificulto mucho localizar correctamente los objetos y utlizar mucho xpath (no es muy recomendable
