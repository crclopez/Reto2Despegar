Feature: Realizar busqueda de vuelo exitosa
  Yo como usuario de despegar.com
  Quiero buscar un itinerario de vuelo
  Para poder realizar la reserva del vuelo que seleccione
  
   Scenario: Creacion de usuario exitoso
    Given el usuario esta en la pagina principal de despegar
    When se elige la opcion vuelos
    And selecciona la ciudad de origen "Medellin, Antioquia, Colombia
    And escoge la ciudad de destino "Aeropuerto Rafael Nunez, Cartagena de Indias 
    And la fecha de inicio "01/09/2018
    And de fin "29/09/2018
    #And cantidad de viajeros "2
    And presiona el boton Buscar
    And ordena de menor a mayor los registros arrojados por la busqueda
    #And captura los 7 primeros registros del resultado de la consulta
    And almacena los registros en un archivo de excel
    Then se muestre el registro de menor valor restado en verde
    
   # Examples:
   # | identificacion | razonSocial | ciudad	| tipoCliente	| nivelRiesgo	| identificacion |
   # | 11112322 |	Prueba1	|	Medellin |	Particular	| 1	|	11112322 |

