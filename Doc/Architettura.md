# Progettazione dell'architettura software (MVC)

## Struttura package

### Model
Contiene le classi che rappresentano la logica dell'applicazione e i dati.

Classi da creare: 
- User (rappresenta un utente)
- Card
- Mazzo
- Dealer (astratta) e classi figlie DealerBlackjack e DealerPoker
- Blackjack, Roulette e Poker 

### View
Contiene le classi legate all'interfaccia utente (Swing).

Classi da creare: 
- MainView (schermata principale con menu) 
- LogicView (schermata di login)
- BlackjackView, RouletteView, PokerView (interfaccia per i giochi) 

### Controller 
Contiene le classi che gestiscono l'interazione tra model e view.
- MainController: (coordina la schermata principale e il flusso dell'app)
- LoginController: gestisce l'autenticazione degli utenti
- BlackjackController, RouletteController, PokerController: gestisce la logica dei giochi


### Utils
Contiene classi di utilità (es. connessione al database).

Classi da creare:
- DBConnection: gestisce la connessione a SQLite

### Data Access Object
Contiene le classi per l'accesso al database

Classi da creare:
- UserDAO: contiene i metodi per gestire i dati degli utenti
