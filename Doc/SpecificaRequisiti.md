# Specifica dei requisiti

##  Requisiti funzionali: 
### Sistema per la gestione degli utenti
- Il sistema deve consentire agli utenti di regiostrarsi con nome utente e password 
- Gli utenti devono poter effetturare login 
### Gestione dei giochi
- L'utente deve poter accedere ai giochi
- Ogni gioco deve offrire una modalità single-player
  
### Interfaccia Utente
- Il sistema deve offrire un'interfaccia grafica (GUI) intuitiva 
  

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
