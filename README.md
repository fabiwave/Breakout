# CC3002-breakout

##

###Descripcion de la implementacion  
##### En este codigo esta la implementacion logica del juego Breakout.
#####Para esto, se implementaron las clases Levels, Game, Brick y HomeworkTwoFacade.  
##### Cada una de estas se encarga de un aspecto del juego, como es el caso de Bricks, que genera las unidades básicas del juego. Levels implementa otra unidad propia del juego que son los niveles (Ya que sabemos que sin niveles no se puede jugar). Y por ultimo Game que es la unidad más grande que contiene a las otras 2, ya que se asegura de que haya un nivel o no, dependiendo del caso y de que si un nivel es jugable este contenga ladrillos. Y a la vez que se pueda cambiar de nivel y ganar el juego.   



### Patrones de diseño usados
##### Para la implementacion de las clases previamente señaladas, se utilizo el patron de diseño Observer, que nos permite notificar si es que se ha sufrido un cambio. Esto fue necesario para poder notificar al nivel que un Brick fue roto, y cuando esto pasara se le aplicara el efecto correspondiente. A su vez el Level tambien fue un objeto observable, ya que era necesario avisarle a game cuando se acababa el nivel por ejemplo o los puntos obtenidos en el nivel.

### Como correr el programa
##### Para este programa es necesario Java 8 y para correr los test necesitas importar JUnit   

### Parte logica del juego
##### Esta es la parte logica del juego asi que no corre sola y se espera que para la proxima tarea esta sea la base para la implementacion de la interfaz grafica.  