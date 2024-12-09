# Progettazione dell'architettura software (MVC)

## Struttura package

### Model
Contiene le classi che rappresentano la logica dell'applicazione e i dati.

Classi da creare: 
- User (rappresenta un utente)
- Game (abstract)
- Blackjack, Roulette e Poker (estendono Game e implementano la logica specifica di ogni gioco)

### View
Contiene le classi legate all'interfaccia utente (JavaFX).

Classi da creare: 
- MainView (schermata principale con menu) 
- LogicView (schermata di login)
- GameView (interfaccia per i giochi) 
- UserProfileView (mostra statistiche giocatore)

### Controller 
Contiene le classi che gestiscono l'interazione tra model e view.
- MainController: (coordina la schermata principale e il flusso dell'app)
- LoginController: gestisce l'autenticazione degli utenti
- GameController: gestisce la logica comune dei giochi (es. puntate, risultati)


### Utils
Contiene classi di utilità (es. gestione log con Log4j, connessione al database).

Classi da creare:
- DBConnection: gestisce la connessione a SQLite
- LoggerUtil: configura la libreria Log4j


### Data Access Object
Contiene le classi per l'accesso al database

Classi da creare:
- UserDAO: contiene i metodi per gestire i dati degli utenti
