Feature: Realizar busqueda de vuelo exitosa
  Yo como usuario de despegar.com
  Quiero buscar un itinerario de vuelo
  Para poder realizar la reserva del vuelo que seleccione
  
   @Exitoso
   Scenario: Busqueda de vuelo exitoso
    Given el usuario esta en la pagina principal de despegar
    When se elige la opcion vuelos
    And selecciona la ciudad de origen "Medellin, Antioquia, Colombia
    And escoge la ciudad de destino "Aeropuerto Rafael Nunez, Cartagena de Indias 
    And la fecha de inicio "01/09/2018
    And de fin "29/09/2018
    And cantidad de viajeros "2
    And presiona el boton Buscar
    And ordena de menor a mayor los registros arrojados por la busqueda
    Then almacena los 7 registros con precio mas bajo en un archivo de excel y se colorea de verde el precio mas bajo
    
    @Alterno
    Scenario: Busqueda de vuelo con ciudad de origen y destino iguales
    Given el usuario esta en la pagina principal de despegar
    When se elige la opcion vuelos
    And selecciona la ciudad de origen "Medellin, Antioquia, Colombia
    And escoge la ciudad de destino "Medellin, Antioquia, Colombia 
    And la fecha de inicio "01/09/2018
    And de fin "29/09/2018
    #And cantidad de viajeros "2
    And presiona el boton Buscar
    Then se visualiza mensaje indicando que el destino debe ser diferente al origen
    
    @Alterno2
    Scenario: Busqueda de vuelo sin fecha de regreso
    Given el usuario esta en la pagina principal de despegar
    When se elige la opcion vuelos
    And selecciona la ciudad de origen "Medellin, Antioquia, Colombia
    And escoge la ciudad de destino "Aeropuerto Rafael Nunez, Cartagena de Indias 
    And la fecha de inicio "01/09/2018
    #And cantidad de viajeros "2
    And presiona el boton Buscar
    Then se visualiza mensaje indicando que se debe ingresar una fecha de regreso
    
    
    
    
    
    
    
    
    
   # Examples:
   # | identificacion | razonSocial | ciudad	| tipoCliente	| nivelRiesgo	| identificacion |
   # | 11112322 |	Prueba1	|	Medellin |	Particular	| 1	|	11112322 |

