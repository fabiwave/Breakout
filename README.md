# Breakout

##

### Descripcion de la implementacion  
##### En este codigo esta la implementacion logica del juego Breakout.
##### Para esto, se implementaron las clases Levels, Game, Brick y HomeworkTwoFacade.  
##### Cada una de estas se encarga de un aspecto del juego, como es el caso de Bricks, que genera las unidades básicas del juego. Levels implementa otra unidad propia del juego que son los niveles (Ya que sabemos que sin niveles no se puede jugar). Y por ultimo Game que es la unidad más grande que contiene a las otras 2, ya que se asegura de que haya un nivel o no, dependiendo del caso y de que si un nivel es jugable este contenga ladrillos. Y a la vez que se pueda cambiar de nivel y ganar el juego.   



### Patrones de diseño usados
##### Para la implementacion de las clases previamente señaladas, se utilizo el patron de diseño Observer, que nos permite notificar si es que se ha sufrido un cambio. Esto fue necesario para poder notificar al nivel que un Brick fue roto, y cuando esto pasara se le aplicara el efecto correspondiente. A su vez el Level tambien fue un objeto observable, ya que era necesario avisarle a game cuando se acababa el nivel por ejemplo o los puntos obtenidos en el nivel.

### Como correr el programa
##### Para este programa es necesario Java 8 y para correr los test necesitas importar JUnit   

### Parte logica del juego
##### Esta es la parte logica del juego asi que no corre sola y se espera que para la proxima tarea esta sea la base para la implementacion de la interfaz grafica. 

### Relacionado a los Test
##### En este projecto solo se encuentra un test, que es para la clase GlassBricks 
##

### Description of the implementation
##### In this code, this is the logical implementation of the game Breakout.
##### For this, the Levels, Game, Brick and HomeworkTwoFacade classes were implemented.
##### Each one of these takes care of an aspect of the game, like the case of the bricks, that generates the basic units of the game. The levels implement another unit of the game that are the levels. And finally Game that is the largest unit that contains the other 2, which ensures that it has been a level or not, a game state and a content game. And at the same time you can change the level and win the game.



### Design patterns used
##### For the implementation of the previously mentioned classes, it is used as an Observer design pattern, which allows us to notify if it has been a change. This was necessary to be able to notify at the level that a brick was broken, and when this is applied to the corresponding effect. At the same time the level was also an observable object, which was necessary to warn a game when the level was finished for example or the points in the level.

### How to run the program
##### Java 8 is required for this program and to run the tests you need to import JUnit

### Logical part of the game
##### This is the logical part of the game so it is not correlated and the next task is not expected to be the basis for the implementation of the graphical interface.

### Related to the Test
##### In this project there is only one test, which is for the GlassBricks class
