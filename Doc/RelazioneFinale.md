# Relazione Finale: UniVegas
## Progetto di ingegneria del software a.a. 2024/2025

![UniVegas](https://github.com/user-attachments/assets/d83cec09-0da9-4971-bc5d-36c31beb56df)


### Progetto a cura di:
- Cattaneo Luca, matricola 1079489
- Locatelli Erica, matricola 1081101


## Indice
1. Project Plan
   - Software Engineering Management
2. Gestione Del Progetto
   - Software Life Cycle
   - Configuration Management
   - People Management and team Organisation
3. Requisiti
   - Requirements Engineering
   - Software Quality
4. Desing
   - Modeling
   - Software Achitecture
   - Software Desing
5. Testing
   - Software testing
6. Maintenance
   - Software Maintenance

## 1. Project Plan 
### Software Engineering Management 
 ## 1. Project plan
  Il seguente project plan si riferisce al progetto di ingegneria del Software a.a. 24/25 e consiste nello sviluppo di un casinò virtuale all'interno del quale è 
  possibile giocare a tre differenti giochi: Blackjack e Roulette. Le partite si svolgono in modalità singleplayer.

   ## 1.1 Introduzione
  Negli ultimi anni, il settore del gioco d'azzardo online ha registrato una crescita esponenziale, spinta dall'aumento dell'accesso a internet, dall'evoluzione 
  tecnologica e dalla crescente popolarità dei giochi digitali.
  Il progetto prevede lo sviluppo, il test e il rilascio del software, attraverso l'impiego di metodologie agili per garantire un 
  approccio flessibile e iterativo. Questo documento illustra i dettagli relativi agli obiettivi, alla portata, ai requisiti tecnici, al piano di lavoro e alle 
  risorse necessarie per lo sviluppo del progetto. I requisiti sono stati classificati e prioritizzati seguendo l'approccio MoSCoW come verrà mostrato in seguito.
  
  ## 1.2 Modello di processo
   Durante la fase di lavoro iniziale il team si è focalizzato sulla definizione dei requisiti del software ideato. I requisiti sono stati identificati attraverso un'analisi approfondita delle esigenze funzionali e non funzionali, basandosi su ciò che il gruppo riteneva opportuno e prendendo ispirazione da software di casinò già presenti sul mercato. Questa attività è stata essenziale per creare una base solida per le fasi successive. Per garantire un approccio chiaro e prioritario alla definizione dei requisiti, abbiamo utilizzato la metodologia MoSCoW. Di seguito vengono elencati i requisiti identificati per il nostro software di casinò virtuale:
<table>
    <tr>
        <th>MUST HAVE</th>
        <th>SHOULD HAVE</th>
        <th>COULD HAVE</th>
        <th>WON'T</th>
    </tr>
    <tr>
    <td>Implementazione dei giochi: Blackjack e Roulette</td>
    <td>Animazioni e grafica avanzata</td>
    <td>Possibilità di modificare il profilo utente</td>
    <td>Applicazione per dispositivi mobili</td>
    </tr>
     <tr>
    <td>Sistema per la gestione degli utenti (registrazione e login)</td>
    <td>Statistiche dettagliate per ogni utente (vincite e tempo di gioco)</td>
    <td>Supporto per lingue multiple</td>
    <td>Integrazione con social network</td>
    </tr>
    <tr>
    <td>Interfaccia grafica user-friendly</td>
    <td>Effetti sonori</td>
    <td>Modalità multiplayer sullo stesso pc per competere con altri utenti</td>
    <td>Transazioni con denaro</td>
    </tr>
    <tr>
    <td>Integrazione di un database per la persistenza dei dati</td>
    <td>Compatibilità con sistemi operativi principali</td>
    <td>Sistema di tutorial per i nuovi giocatori</td>
    <td>Chat in tempo reale tra giocatori</td>
    </tr>
    <tr>
    <td>Gestione degli errori</td>
    <td>Forum per segnalazioni di bug/suggerimenti</td> 
    <td>Integrazione di un sistema di premi virtuali</td>
    <td>Modalità multiplayer su pc diversi</td>
    </tr>
</table>

#### Progettazione 
Dopo la definizione dei requisiti, il team si è dedicato alla progettazione del sistema. Questa fase è stata il punto di riferimento per l'organizzazione del tempo, la creazione degli issue e la pianificazione degli sprint. La fase di progettazione comprende:
- La creazione di diagrammi UML per rappresentare la struttura e il comportamento del sistema.
- La progettazione dell’architettura software, identificando i moduli principali e il loro collegamento.
- La progettazione del database per garantire la persistenza dei dati.
- La definizione della GUI, con Swing come framework grafico.

#### Implementazione e test
Durante la fase di implementazione, il team sviluppa i moduli funzionali del software:
- Realizzazione dei giochi in modo 
  incrementale.
- Integrazione del database per gestire i dati utente.
- Configurazione della libreria di logging per monitorare e registrare 
  eventi critici.
  La fase di testing, invece, prevede:
- Test unitari per verificare la correttezza dei singoli moduli.
- Test di integrazione per assicurare che i moduli funzionino correttamente 
  insieme.
- Test di accettazione per garantire che il prodotto soddisfi i requisiti 
  definiti e offra un'esperienza utente ottimale.

#### Manutenzione
Dopo la consegna del prodotto, il team si impegna a fornire supporto per la risoluzione di eventuali bug e l’implementazione di nuove funzionalità richieste. La manutenzione sarà gestita seguendo un approccio agile per rispondere rapidamente alle esigenze.

Grazie al modello SCRUM, ogni sprint culmina con una revisione del lavoro completato e una retrospettiva per migliorare il processo nelle iterazioni successive.

  ## 1.3 Organizzazione del progetto
Tutti i membri del team partecipano attivamente alla progettazione e allo sviluppo del software. 
Il team si riunirà due volte a settimana, il lunedì e il venerdì, con la possibilità di organizzare videoconferenze a distanza per discutere e pianificare le attività future.
I compiti sono suddivisi in base alle competenze individuali, con l'introduzione di una revisione del codice al termine di ogni giornata lavorativa. Questo momento consente allo sviluppatore di spiegare il proprio lavoro e agli altri membri di suggerire eventuali miglioramenti.

  ## 1.4 Standards, linee guida e procedure
  Per garantire uno sviluppo strutturato e di alta qualità del software, il team ha stabilito l'adozione di standard e linee guida specifiche durante tutte le fasi del progetto. Di seguito sono riportati i principali standard, procedure e strumenti utilizzati:
  #### Standards
Standard di codifica: il team adotta lo standard di codifica Java ufficiale fornito da Oracle.
#### Linee guida
Il repository GitHub segue una struttura chiara, con rami principali e rami specifici per ogni feature. Ogni merge nel ramo principale richiede una revisione (pull request) da parte di almeno un altro membro del team.
#### Procedure
Prima di effettuare un merge nel ramo principale, il codice viene sottoposto a una revisione per verificare:
- Qualità del codice (aderenza agli standard di codifica).
- Assenza di bug evidenti.
- Adeguata copertura di test unitari.
#### Strumenti
- Gestione delle dipendenze: Utilizzo di Maven per garantire un controllo 
  centralizzato delle librerie e delle versioni utilizzate nel progetto.
- Strumenti di test: JUnit per il testing automatico delle funzionalità 
  principali.
- Gestione del lavoro: Utilizzo di strumenti come Kanban board per 
  tracciare le attività e monitorare lo stato di avanzamento del progetto.

## 1.5 Attività di gestione
Lo sviluppo del progetto è stato organizzato secondo i principi dei metodi agili, con particolare riferimento alla filosofia dell'Extreme Programming, che promuove efficienza e adattabilità a eventuali modifiche dei requisiti. Il team ha lavorato in stretta collaborazione durante tutte le fasi, mantenendo il focus sugli obiettivi del progetto anziché su interessi personali.
Nei primi incontri si è data grande importanza alla pianificazione, con la definizione dei requisiti e la loro classificazione per priorità. Successivamente, si è passati alla realizzazione vera e propria, affiancata da verifiche e test continui per garantire che ogni fase fosse svolta correttamente.
Ogni attività pianificata è stata associata a una scadenza specifica, con l’obiettivo di assicurare un avanzamento costante del progetto, monitorare i progressi rispetto agli obiettivi stabiliti e intervenire rapidamente in caso di ritardi o problemi.

  ## 1.6 Rischi
 Nel corso del progetto, il team ha identificato una serie di potenziali 
rischi che potrebbero compromettere il completamento o la qualità del 
software. Di seguito si descrivono i principali:
1. Ritardi nello sviluppo
2. Mancanza di esperienza con alcune tecnologie
3. Problemi di integrazione tra componenti
4. Requisiti non chiari o tardivi
5. Errori nel database

Ogni sprint sarà un’occasione per rivalutare i rischi e adottare misure 
correttive.
 
  ## 1.7 Membri
  I membri che hanno partecipato al progetto sono quelli precedentemente menzionati.
 
  ## 1.8 Metodi e tecniche
  Nel progetto sono stati adottati metodi e tecniche specifiche per garantire un approccio strutturato, efficace e allineato agli obiettivi prefissati. Di seguito vengono descritte le metodologie utilizzate nelle principali aree del ciclo di sviluppo.
- Metodologia SCRUM: il team utilizza il framework agile SCRUM per organizzare il lavoro in sprint di durata fissa. Le attività principali includono:
  - Pianificazione dello sprint (Sprint Planning) per definire obiettivi e 
    priorità.
  - Meeting giornalieri per monitorare i progressi.
  - Retrospettive al termine di ogni sprint per valutare i risultati e 
    migliorare il processo.
- Strumenti di gestione:
  - GitHub Projects per tracciare attività, assegnare 
    responsabilità e monitorare lo stato di avanzamento.
- Progettazione UML: il sistema è stato progettato utilizzando i diagrammi 
  UML, tra cui:  use case diagram, class diagram, state machine diagram, 
  sequence diagram, communication diagram/timing diagram, activity diagram 
  e component diagram.
- Architettura MVC (Model-View-Controller): il progetto segue l'architettura MVC per separare le responsabilità tra i diversi moduli del software, migliorando la manutenibilità e la modularità.
  - Model: rappresenta i dati principali e la logica applicativa del sw, gestione del database e logica di gioco.
  - View: gestisce la rappresentazione grafica dell'applicazione
  - Controller: funziona come intermediario tra model e view.
- Programmazione orientata agli oggetti: il software è sviluppato seguendo 
  i principi della programmazione orientata agli oggetti, garantendo 
  riusabilità del codice e manutenibilità.
- Tecniche di testing: è stato implementata la continous integration with maven in GitHub, che permette di effettuare un testing automatico ad ogni commit

 ## 1.9 Garanzie di qualità
 La qualità del software è garantita dall'osservazione in tutte le fasi dei seguenti criteri:
 - Funzionalità: il software deve rispettare le esigenze espresse e deve funzionare senza errori, verranno eseguiti diversi test funzionali per assicurare che operi correttamente in  tutti gli scenari previsti.
 - Affidabilità: il software deve garantire un elevato livello di prestazioni durante l'utilizzo e deve operare sempre in modo stabile.
 
 - Usabilità: il software deve offrire un'esperienza utente ottimale. L'interfaccia utente sarà semplice con un focus sulla facilità d'uso; verranno inviati messaggi chiari e tempestivi per ogni interazione dell'utente, come conferme delle operazioni e notifiche di errori in modo da facilitare l'utilizzo.
 
 - Manutenibilità: il software deve essere aggiornabile nel tempo, per far fronte a nuove esigenze o correggere eventuali malfunzionamenti.
 

 
## 1.10 Package di lavoro  
  Elenco dei package di lavoro

| **ID** | **Nome del package**           | **Descrizione**                                                                 | **Responsabile**       | **Output atteso**                               | **Durata prevista** |
|--------|--------------------------------|---------------------------------------------------------------------------------|------------------------|-------------------------------------------------|---------------------|
| WP1    | Raccolta requisiti             | Identificazione dei requisiti utilizzando la metodologia MoSCoW.                | Tutto il team         | Documento dei requisiti.                       | 1 settimana         |
| WP2    | Progettazione                  | Creazione di diagrammi UML e definizione dell'architettura MVC.                 | Tutto il team                  | Diagrammi UML, struttura del progetto.         | 3 giorni         |
| WP3    | Configurazione ambiente        | Configurazione di GitHub, Maven, database SQLite e JavaSwing.                      | Erica               | Ambiente pronto per lo sviluppo.               | 3 giorni         |
| WP4    | Sviluppo del Model             | Implementazione della logica applicativa, del database e delle regole di gioco. | Tutto il team                 | Componenti del Model funzionanti.              | 1 settimana         |
| WP5    | Sviluppo del Controller        | Implementazione della logica che collega il Model con la View.                  | Tutto il team                  | Controller funzionanti e testati.              | 1 settimana         |
| WP6    | Sviluppo della View            | Creazione dell’interfaccia grafica con JavaSwing.                                  | Tutto il team                | Interfaccia grafica operativa.                 | 1 settimana         |
| WP7    | Integrazione e testing         | Integrazione dei moduli e test unitari, di integrazione e di sistema.           | Luca         | Software funzionante e testato.                | 1 settimana         |
| WP8    | Documentazione                 | Creazione della documentazione finale, inclusi manuale utente e report tecnico. | Erica                 | Documentazione completa del progetto.          | 1 settimana         |

  ## 1.11 Risorse
  Le risorse usate dal team sono le seguenti:
  - Github come sistema per il Configuration Management
  - Papyrus come software per la creazione dei diagrammi UML
  - SQLite per la crezione del database
  - Eclipse come ambiente di sviluppo

 L'utente invece per poter usare il software necessita semplicemente di un computer. 

  ## 1.12 Budget e pianificazione
  Non è stato concordato alcun budget monetario, ma solamente il tempo messo a disposizione dal team. 
  
  ## 1.13 Cambiamenti
  Qualsiasi cambiamento potrà essere effettuato solamente dopo l'approvazione da parte di tutti  membri del team della richiesta di modifica.
  Le proposte di cambiamento potranno provenire sia dai membri del team sia dagli utenti attraverso l’apposito forum. Ogni richiesta dovrà essere corredata da una 
  documentazione dettagliata che illustri il motivo della modifica e i benefici che essa comporterebbe.

  ## 1.14 Consegna
La consegna del progetto è prevista per cinque giorni prima dell'esame orale, mentre il project plan deve essere consegnato un mese prima. 
Il team si impegna, inoltre, ad effettuare una revisione finale prima della pubblicazione del progetto.

## 2. Gestione del Progetto
### Software Life Cycle
### 1. Processo Seguito
Per lo sviluppo del progetto UniVegas, abbiamo adottato un approccio Agile basato sul framework Scrum. Questo metodo ci ha permesso di gestire il progetto in modo iterativo e incrementale, 
garantendo flessibilità e adattabilità ai cambiamenti durante lo sviluppo.

### 2. Organizzazione del Progetto
Abbiamo organizzato il progetto in sprint della durata di 2 settimane, seguendo il classico ciclo di Scrum. Ogni sprint è stato pianificato, eseguito e revisionato per garantire il raggiungimento degli obiettivi.

#### Timebox e Sprint
##### Sprint 1:
Obiettivo: 
- Definizione dei requisiti e progettazione dell'architettura.

Attività: 
- Brainstorming iniziale e raccolta dei requisiti.
- Creazione del Project Plan e del Product Backlog.
- Progettazione dell'architettura MVC e dei diagrammi UML iniziali (Use Case, Class Diagram).

##### Sprint 2:
Obiettivo: 
- Implementazione e connessione database.
  
Attività:
- Sviluppo del controller, view e model.
- Connessione con il database per login e registrazione.

##### Sprint 3:
Obiettivo: 
- Testing, debugging e miglioramenti finali.

Attività:
- Esecuzione di test funzionali e correzione dei bug.
- Ottimizzazione delle prestazioni e refactoring del codice.
- Preparazione della documentazione finale.

### 3. Differenze Rispetto al Project Plan
Durante lo sviluppo, abbiamo riscontrato alcune differenze rispetto a quanto previsto nel Project Plan iniziale:

Modifica dei Requisiti:
Durante lo Sprint 2, abbiamo riscontrato delle difficoltà nella gestione dei token nel blackjack, li abbiamo quindi eliminati.

Ridistribuzione delle Attività:
A causa di imprevisti tecnici, un membro del gruppo si è ritirato dal progetto, ciò ha richiesto una riorganizzazione delle attività e la mancata implementazione del gioco del Poker, assegnata a quest'ultimo. 

Estensione del Timebox:
Lo Sprint 3 è stato esteso per consentire il completamento di tutte le attività di testing e documentazione.

### Configuration management
### 1. Gestione della Configurazione
La gestione della configurazione è stata un aspetto fondamentale per garantire il controllo delle versioni del codice, la tracciabilità delle modifiche e la collaborazione efficace tra i membri del team. Abbiamo adottato una combinazione di strumenti e pratiche per gestire il codice sorgente, le attività e i rilasci.

### 2. Strumenti utilizzati
GitHub: Abbiamo utilizzato GitHub per ospitare il repository del progetto, garantendo un accesso centralizzato al codice sorgente. Ogni merge request è stata sottoposta a una revisione del codice da parte di un altro membro del team per garantire la qualità del codice.
KanbanBoard: Abbiamo utilizzato una Kanban Board per gestire le attività del progetto. Ogni attività è stata rappresentata come un issue, organizzata in colonne corrispondenti agli stati del flusso di lavoro (ad esempio, "To Do", "In Progress", "Revision", "Done"). La Kanban Board ci ha permesso di visualizzare lo stato delle attività in tempo reale e di identificare eventuali colli di bottiglia.

![image](https://github.com/user-attachments/assets/f5b081b8-5744-4d12-bdb0-4c1c07131b8a)


### People Management and Team Organisation
#### Organizzazione del Team
Nel progetto UniVegas, abbiamo adottato l'approccio Scrum, che prevede un'organizzazione del lavoro basata su ruoli ben definiti e su un processo iterativo e incrementale. Il team è stato organizzato secondo i principi di Scrum, con una chiara divisione dei ruoli e delle responsabilità.

#### Ruoli in Scrum
#### Product Owner (PO)
- Responsabilità: Il Product Owner è stato responsabile della definizione e della priorizzazione del Product Backlog, garantendo che il team sviluppasse le funzionalità più importanti per il progetto.
- Persona: Erica.
- Attività: Raccolta e definizione dei requisiti, approvazione delle funzionalità completate alla fine di ogni sprint.

#### Scrum Master (SM)
- Responsabilità: Lo Scrum Master ha facilitato il processo Scrum, rimuovendo gli ostacoli e garantendo che il team rispettasse le pratiche e i principi di Scrum.
- Persona: Luca.
- Attività: Organizzazione delle riunioni (Daily Stand-up, Sprint Planning, Sprint Review, Sprint Retrospective). Monitoraggio del progresso del team e del rispetto dei timebox, supporto al team nella risoluzione di problemi organizzativi o tecnici.

#### Development Team
- Responsabilità: Il Development Team è stato responsabile dello sviluppo del prodotto, dalla progettazione all'implementazione e al testing.
- Persone: Erica e Luca.
- Attività: Implementazione delle user story assegnate durante lo sprint, collaborazione nella progettazione e nel codice (pair programming, code review) e esecuzione dei test e correzione dei bug.

#### Collaborazione e Comunicazione
La collaborazione tra i membri del team è stata favorita da:

Riunioni Regolari: Daily Stand-up, Sprint Planning, Sprint Review, Sprint Retrospective.

Strumenti di Comunicazione: Abbiamo utilizzato strumenti come [E-Mail, Gogle Meet, Whatsapp, ecc.] per la comunicazione quotidiana.

Kanban Board: Utilizzato per visualizzare lo stato delle attività e migliorare la trasparenza del lavoro.

## 3. Requisiti
### Requirements Engineering 
<table>
    <tr>
        <th>MUST HAVE</th>
        <th>SHOULD HAVE</th>
        <th>COULD HAVE</th>
        <th>WON'T</th>
    </tr>
    <tr>
    <td>Implementazione dei tre giochi: Poker, Blackjack e Roulette</td>
    <td>Possibilità di modificare il profilo utente</td>
    <td>Animazioni e grafica avanzata</td>
    <td>Applicazione per dispositivi mobili</td>
    </tr>
     <tr>
    <td>Sistema per la gestione degli utenti (registrazione e login)</td>
    <td>Statistiche dettagliate per ogni utente (vincite e tempo di gioco)</td>
    <td>Supporto per lingue multiple</td>
    <td>Integrazione con social network</td>
    </tr>
    <tr>
    <td>Interfaccia grafica user-friendly</td>
    <td>Modalità multiplayer sullo stesso pc per competere con altri utenti</td>
    <td>Modalità multiplayer su pc diversi</td>
    <td>Transazioni con denaro</td>
    </tr>
    <tr>
    <td>Integrazione di un database per la persistenza dei dati</td>
    <td>Compatibilità con sistemi operativi principali</td>
    <td>Sistema di tutorial per i nuovi giocatori</td>
    <td>Chat in tempo reale tra giocatori</td>
    </tr>
    <tr>
    <td>Gestione degli errori</td>
    <td>Forum per segnalazioni di bug/suggerimenti</td> 
        <td>Integrazione di un sistema di premi virtuali</td>
    <td></td>
    </tr>
</table>

##  Requisiti funzionali: 
### Sistema per la gestione degli utenti
- Il sistema deve consentire agli utenti di registrarsi con nome utente e password 
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


### Sicurezza
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

![useCase](https://github.com/user-attachments/assets/2b0e7b76-0b32-43c9-82fc-2793b806d010)

## Software Quality 
Durante lo sviluppo di UniVegas, ci siamo focalizzati su una serie di qualità chiave che hanno guidato le nostre decisioni e il nostro approccio al lavoro. Queste qualità non solo hanno influenzato il processo di sviluppo, ma hanno anche contribuito al successo del progetto nel suo complesso. Per garantire un prodotto di alta qualità, abbiamo adottato il modello di qualità del software di McCall, che ci ha permesso di valutare e migliorare il software sotto diversi aspetti. Di seguito sono riportate le principali qualità su cui ci siamo concentrati, organizzate secondo le tre categorie del modello di McCall:
### Operational Quality 
La qualità operativa si riferisce alla capacità del software di funzionare correttamente durante l'esecuzione. Le caratteristiche principali su cui ci siamo concentrati sono:

Correttezza: Abbiamo garantito che il software soddisfacesse tutti i requisiti funzionali e non funzionali definiti durante la fase di analisi. Attraverso i test, abbiamo verificato che il comportamento del sistema fosse conforme alle specifiche.

Affidabilità: Il sistema è stato progettato per essere robusto e resistente a guasti. Abbiamo implementato meccanismi di gestione degli errori e di recupero per garantire che il software funzionasse in modo affidabile anche in condizioni non ideali.

Efficienza: Abbiamo ottimizzato le prestazioni del software, riducendo i tempi di risposta e minimizzando l'utilizzo delle risorse di sistema. Questo è stato particolarmente importante per garantire un'esperienza utente fluida e reattiva.

Integrità: La sicurezza dei dati è stata una priorità. Abbiamo implementato meccanismi di autenticazione e autorizzazione per proteggere le informazioni sensibili e prevenire accessi non autorizzati.

Usabilità: L'interfaccia utente è stata progettata per essere intuitiva e facile da usare. Abbiamo condotto test di usabilità con utenti reali per raccogliere feedback e migliorare l'esperienza complessiva.
### Revision Quality 
La qualità di revisione si riferisce alla capacità del software di essere modificato e mantenuto nel tempo. Le caratteristiche principali su cui ci siamo concentrati sono:

Manutenibilità: Il codice è stato scritto seguendo buone pratiche di programmazione, come l'uso di commenti, nomi significativi per variabili e funzioni, e una struttura modulare. Questo ha reso il codice più facile da comprendere e modificare.

Flessibilità: Abbiamo progettato il sistema in modo che fosse facile da estendere e adattare a nuovi requisiti. L'uso di design pattern e principi di programazione orientata agli oggetti ha contribuito a raggiungere questo obiettivo.

Testabilità: Il software è stato progettato per essere facilmente testabile. Abbiamo scritto test automatizzati per garantire che le modifiche future non introducessero regressioni.
### Transition Quality
La qualità di transizione si riferisce alla capacità del software di adattarsi a nuovi ambienti o di essere integrato con altri sistemi. Le caratteristiche principali su cui ci siamo concentrati sono:

Portabilità: Abbiamo progettato il software per essere compatibile con diverse macchine. 

Riusabilità: Abbiamo cercato di massimizzare la riusabilità del codice, creando componenti modulari che possono essere facilmente riutilizzati in altri progetti o contesti.

![image](https://github.com/user-attachments/assets/4f4a820c-8705-4111-a556-9210fe17ecb2)


## 4. Design
### Modelling 
INSERIre IMMAGINI DIAGRAMMI 

### Software Architecture
Per il progetto UniVegas, abbiamo adottato l'architettura Model-View-Controller (MVC), un pattern architetturale che separa la logica dell'applicazione in tre componenti principali: Model, View e Controller. Questa scelta ci ha permesso di mantenere il codice ben organizzato, modulare e facile da mantenere.
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
Il package DAO contiene le classi per l'accesso ai dati, implementando il pattern Data Access Object per separare la logica di accesso ai dati dalla logica di business.
- UserDAO: contiene i metodi per gestire i dati degli utenti

### Architectural views
Per descrivere in modo completo l'architettura del sistema, abbiamo adottato il modello 4+1 View Model di Philippe Kruchten. Questo modello ci ha permesso di rappresentare il sistema da diverse prospettive, garantendo che tutti gli aspetti chiave fossero adeguatamente documentati.

![image](https://github.com/user-attachments/assets/2b1fd07c-e81a-4d20-b00a-473e1540d9ee)

### Logical View (Vista Logica)
La Logical View descrive la struttura del sistema in termini di componenti software e relazioni tra di essi. Nel nostro progetto, abbiamo adottato un'architettura MVC (Model-View-Controller), che separa chiaramente la logica di business, l'interfaccia utente e il controllo dell'applicazione.

Model: Rappresenta i dati e la logica di business del sistema. Ad esempio, il BlackjackModel e il RouletteModel contengono le regole dei giochi e gestiscono lo stato delle partite, mentre User gestisce le informazioni del giocatore.

View: Si occupa della visualizzazione dei dati all'utente. Le classi come BlackjackView e RouletteView definiscono l'interfaccia grafica dei giochi, mostrando il tavolo da gioco, le carte, i pulsanti per le scommesse e i messaggi di feedback.

Controller: Gestisce l'interazione tra il Model e la View. I controller, come BlackjackController e RouletteController, elaborano gli input dell'utente e aggiornano il Model di conseguenza.

Diagrammi utilizzati:

Diagrammi di classe UML per rappresentare le classi del Model, View e Controller.

Diagrammi di package per mostrare l'organizzazione modulare del sistema.

### Development View (Vista di Sviluppo)
La Development View si concentra sull'organizzazione del codice sorgente e delle dipendenze tra i moduli. Per garantire una struttura chiara e manutenibile, abbiamo organizzato il progetto in directory e package ben definiti:

model/: Contiene le classi del Model.

view/: Contiene le interfacce utente.

controller/: Contiene i Controller.

utils/: Include la connessione al database.

test/: Contiene i test unitari e di integrazione per garantire la qualità del codice.

Diagrammi utilizzati:

Diagrammi di componenti per mostrare le dipendenze tra i moduli.

### Process View (Vista dei Processi)
La Process View descrive il comportamento dinamico del sistema, con particolare attenzione ai processi, ai thread e alle interazioni tra i componenti. Nel nostro progetto, ci siamo concentrati sui seguenti aspetti:

Flusso di gioco: Descrive come l'utente interagisce con il sistema durante una partita. Ad esempio, in una partita di Roulette, l'utente piazza una scommessa, il Controller aggiorna il Model e la View mostra il risultato.

Gestione delle sessioni: Illustra come il sistema gestisce l'avvio e la fine di una partita, oltre all'aggiornamento del saldo del giocatore.

Diagrammi utilizzati:

Diagrammi di sequenza UML per mostrare le interazioni tra Model, View e Controller durante un flusso di gioco.

Diagrammi di attività per descrivere i passaggi di una partita.

### Physical View (Vista Fisica)
La Physical View descrive l'infrastruttura hardware e la distribuzione del sistema. Sebbene il nostro progetto sia un'applicazione singleplayer, abbiamo comunque considerato i seguenti aspetti:

Ambiente di esecuzione: Il software è progettato per essere eseguito su PC desktop con sistemi operativi Windows, macOS e Linux.

### Scenarios (Vista degli Scenari)
La Scenarios View combina elementi delle altre viste per descrivere casi d'uso specifici o scenari di funzionamento del sistema. Per il nostro progetto, abbiamo identificato i seguenti scenari principali:

Casi d'uso:

Un utente avvia una partita di Blackjack.

Un utente piazza una scommessa alla Roulette.

Un utente visualizza il saldo corrente.

Scenari di errore:

Cosa succede se l'utente tenta di piazzare una scommessa superiore al saldo disponibile.

Diagrammi utilizzati:

Diagrammi di casi d'uso UML per mostrare le interazioni tra l'utente e il sistema.

Diagrammi di sequenza per descrivere scenari specifici.

L'uso delle architectural views ci ha permesso di documentare in modo completo e strutturato l'architettura del sistema UniVegas. Grazie a questo approccio, abbiamo garantito che tutti gli aspetti del sistema fossero chiaramente rappresentati, facilitando la comunicazione e supportando lo sviluppo, il testing e il mantenimento del software.

### Software design
Il design del sistema è basato sull'architettura MVC (Model-View-Controller), che separa chiaramente la logica di business (Model), l'interfaccia utente (View) e il controllo dell'applicazione (Controller). Di seguito sono riportati i diagrammi UML principali.

Diagramma delle Classi (Class Diagram)
Il diagramma delle classi mostra la struttura statica del sistema, con le classi principali e le relazioni tra di esse.

Diagramma delle Classi
METTI IMMAGINE



Diagramma di Sequenza (Sequence Diagram)
Il diagramma di sequenza descrive il flusso di interazione tra gli oggetti durante una partita di Blackjack.

Diagramma di Sequenza
METTI IMMAGINE

### Calcolo della Complessità (McCabe)
Per valutare la complessità del codice, abbiamo utilizzato la metrica di complessità ciclomatica di McCabe. Questa metrica misura il numero di cammini linearmente indipendenti attraverso un metodo, aiutando a identificare codice potenzialmente complesso e difficile da mantenere.
### Esempio: il metodo determineResult in BlackjackController

 
 public String determineResult() {
        
        int playerSum = model.getPlayer().reduceAce();
        int dealerSum = model.getDealer().reduceAce();
        
        if (playerSum > 21) {
            return "Hai Perso!";
        } else if (dealerSum > 21) {
            return "Hai Vinto!";
        } else if (playerSum == dealerSum) {
            return "Pareggio!";
        } else if (playerSum > dealerSum) {
            return "Hai Vinto!";
        } else {
            return "Hai Perso!";
        }
    }
    
La complessità ciclomatica V(G) può essere calcolata utilizzando la formula:

V(G)=E−N+2= 10-7+1=4

Dove:

E = Numero di archi nel grafo di controllo (flusso del programma).

N = Numero di nodi nel grafo di controllo (blocchi di codice).

Valore 4: Indica che il metodo ha una complessità moderata. Un valore inferiore a 10 è generalmente considerato accettabile e gestibile.

### Metriche del codice
VEDI STRUCTURE 101

VEDI DESIGN PATTERN

## 5. Testing
### Software Testing
Per garantire una buona copertura del sistema e verificare che i singoli moduli del sistema sviluppato funzionassero correttamente, abbiamo implementato test automatici con il framework JUnit4. L'implementazione dei test unitari è stata eseguita nella directory src/test/java, creando un "JUnit Test Case" per le classi principali, denominato "NomeClasseTest".  I test sono stati svolti per verificare il corretto funzionamento dei metodi analizzati, simulando l'input e confrontando l'output con quello atteso tramite la funzione "assertEquals".


## 6. Maintenance
### Software maintenance
Il refactoring è una pratica di sviluppo software che consiste nel modificare la struttura interna del codice senza cambiarne il comportamento esterno. L'obiettivo principale del refactoring è migliorare la leggibilità, la manutenibilità, la scalabilità e la qualità complessiva del codice, senza introdurre nuovi bug o alterare le funzionalità esistenti. 
Alcune classi del codice avevano una complessità piuttosto elevata, abbiamo quindi lavorato per risolvere dove possibile i seguenti problemi: metodi eccessivamente lunghi, classi contenenti troppi metodi e il passaggio di un elevato numero di parametri tra i metodi.

La manutenzione di un software rappresenta un processo fondamentale per garantire il suo funzionamento ottimale e la sua continua adattabilità alle mutevoli esigenze degli utenti e dell'ambiente in cui opera. Tale processo si articola in diverse tipologie di intervento:

Manutenzione Correttiva:

Interventi volti alla risoluzione tempestiva di errori e malfunzionamenti riscontrati durante l'uso del sistema.
Esempio: Correzione di un bug nel calcolo del punteggio nel gioco del Blackjack.

Manutenzione Perfettiva:

Implementazione di nuove funzionalità richieste dagli utenti o ottimizzazione delle prestazioni dell'applicativo.
Esempio: Aggiunta di un nuovo gioco (ad esempio, Poker) o miglioramento dell'interfaccia utente.

Manutenzione Preventiva:

Interventi proattivi per prevenire futuri problemi e migliorare la manutenibilità complessiva del software.
Esempio: Refactoring del codice per ridurre la complessità ciclomatica o migliorare la modularità.

### Strategie di Manutenzione
Per garantire una manutenzione efficace e continua, abbiamo adottato le seguenti strategie:

 1. Documentazione Completa
Tutte le funzionalità del sistema sono documentate in modo dettagliato, inclusi diagrammi UML, descrizioni dei design pattern e metriche di qualità.
La documentazione è aggiornata regolarmente per riflettere le modifiche apportate al sistema.

 2. Codice Modulare e Ben Strutturato
Il sistema è stato progettato seguendo i principi dell'architettura MVC (Model-View-Controller), che separa chiaramente la logica di business, l'interfaccia utente e il controllo dell'applicazione.
L'uso di design pattern come AGGIUNGERE migliora la manutenibilità e l'estensibilità del codice.

 3. Versionamento del Codice
Il codice è gestito utilizzando un sistema di versionamento (Git) con piattaforme come GitHub o GitLab.
Ogni modifica è tracciata attraverso commit descrittivi, e le funzionalità sono sviluppate in branch separati per facilitare il merging e il rollback.

 4. Test Automatici
Sono stati implementati test unitari e di integrazione per garantire che le modifiche non introducano regressioni.
Per garantire che il sistema rimanga funzionale e aggiornato, abbiamo definito un piano di manutenzione che include:
Monitoraggio Continuo: raccolta di feedback dagli utenti per identificare bug o miglioramenti.
Aggiornamenti Periodici:revisione e aggiornamento del codice per supportare nuove tecnologie o requisiti.
Refactoring: miglioramento continuo della struttura del codice per ridurre la complessità e migliorare la manutenibilità.
Formazione del Team: formazione continua del team di sviluppo sulle best practice di manutenzione del software.
