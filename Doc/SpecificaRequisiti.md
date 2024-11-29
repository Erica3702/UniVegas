# Specifica dei requisiti

##  Requisiti funzionali: 
### Sistema per la gestione degli utenti
- Il sistema deve consentire agli utenti di regiostrarsi con nome utente, password e e-mail
- Gli utenti devono poter effetturare login e logout
- Ogni utente deve avere un profilo che includa token disponibili e statistiche di gioco
### Gestione dei giochi
- L'utente deve poter accedere ai giochi
- Ogni gioco deve offrire una modalità single-player
- L'utente deve poter scegliere l'importo dei token da puntare prima di iniziare ogni partita
- Le regole di gioco devono essere mostrate all'utente tramite un'apposita interfaccia grafica
### Transazioni e Economia del Casinò
- Il sistema deve calcolare e aggiornare i token degli utenti dopo ogni partita
- Ogni utente riceve 500 token all'iscrizione

###  Classifiche e Statistiche
- Deve esserci una classifica globale basata sui guadagni totali degli utenti
-  Gli utenti possono consultare le proprie statistiche dettagliate: numero di partite giocate e vincita totale
  
### Gestione del Database
- Le statistiche di gioco e i profili degli utenti devono essere salvati nel database
- Tutti i dati devono essere recuperabili in caso di crash

### Interfaccia Utente
- Il sistema deve offrire un'interfaccia grafica (GUI) intuitiva sviluppata con JavaFX
  

## Requisiti non funzionali:
### Performance
- Il caricamento della schermata iniziale deve essere rapido
- Le partite devono rispondere in tempo reale senza lag

### Scalabilità
-  Il sistema deve supportare più utenti contemporanei senza degrado delle prestazioni.

### Sicurezza
- Le password degli utenti devono essere salvate nel database in forma crittografata
- L’accesso ai dati sensibili degli utenti deve essere limitato agli utenti autenticati

### Manutenibilità
- Il codice deve essere modulare, seguendo l’architettura MVC
-  Deve essere documentato e conforme agli standard di Java

### Affidabilità
- Tutte le operazioni critiche devono essere registrate nei log tramite la libreria Log4j

### Portabilità
- L’applicazione deve funzionare su sistemi operativi Windows, macOS e Linux con JVM compatibile

### Usabilità
- Il software deve essere semplice, in modo che gli utenti imparino a utilizzarlo in poco tempo
