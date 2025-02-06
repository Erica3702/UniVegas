# Progettazione dell'architettura software (MVC)

## Struttura package

### Model
Contiene le classi che rappresentano la logica dell'applicazione e i dati.

Classi da creare: 
- User (rappresenta un utente)
- Card
- Mazzo
- Dealer 
- Blackjack, Roulette e Poker 

### View
Contiene le classi legate all'interfaccia utente (Swing).

Classi da creare: 
- MenuGiochi e MenuUtente (schermata principale con menu) 
- Login e Registrazione 
- BlackjackView, RouletteView e RoulettePanel (interfaccia per i giochi) 

### Controller 
Contiene le classi che gestiscono l'interazione tra model e view.
- MainController: (coordina la schermata principale e il flusso dell'app)
- BlackjackController, RouletteController: gestisce la logica dei giochi


### Utils
Contiene classi di utilità (es. connessione al database).
- DBConnection: gestisce la connessione a SQLite

### Data Access Object
Contiene le classi per l'accesso al database
- UserDAO: contiene i metodi per gestire i dati degli utenti
