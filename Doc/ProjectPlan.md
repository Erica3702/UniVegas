# Casinò (nome)
## Progetto di ingegneria del software a.a. 2024/2025

### Progetto a cura di:
- Cattaneo Luca, matricola 1079489
- Locatelli Erica, matricola 1081101
- Tacuri Rodrigo, matricola 1073963


## Indice
- __1. Project plan__
  - [1.1 Introduzione](#11-introduzione)
  - [1.2 Modello di processo](#12-modello-di-processo)
  - [1.3 Organizzazione del progetto](#13-organizzazione-del-progetto)
  - [1.4 Standards, linee guida e procedure](#14-standard-linee-guida-e-procedure)
  - [1.5 Attività di gestione](#15-attività-di-gestione)
  - [1.6 Rischi](#16-rischi)
  - [1.7 Membri](#17-membri)
  - [1.8 Metodi e tecniche](#18-metodi-e-tecniche)
  - [1.9 Garanzie di qualità](#19-garanzie-di-qualità)
  - [1.10 Package di lavoro](#110-package-di-lavoro)
  - [1.11 Risorse](#111-risorse)
  - [1.12 Budget e pianificazione](#112-budget-e-pianificazione)
  - [1.13 Cambiamenti](#113-cambiamenti)
  - [1.14 Consegna](#114-consegna)


   ## 1. Project plan
  Il seguente project plan si riferisce al progetto di ingegneria del Software a.a. 24/25 e consiste nello sviluppo di un casinò virtuale all'interno del quale è 
  possibile giocare a tre differenti giochi: Blackjack, Poker e Roulette. Le partite si possono svolgere in due modalità: multiplayer sullo stesso pc e 
  singleplayer.

   ## 1.1 Introduzione
  Negli ultimi anni, il settore del gioco d'azzardo online ha registrato una crescita esponenziale, spinta dall'aumento dell'accesso a internet, dall'evoluzione 
  tecnologica e dalla crescente popolarità dei giochi digitali.
  Il progetto prevede lo sviluppo, il test e il rilascio del software entro il 19/01/2025, attraverso l'impiego di metodologie agili per garantire un 
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

#### Progettazione 
Dopo la definizione dei requisiti, il team si è dedicato alla progettazione del sistema. La fase di progettazione è stato il punto di riperimento per l'organizzazione del tempo, la creazione degli issues e la pianificazione degli sprint.
Questa fase comprende:
- La creazione di diagrammi UML per rappresentare la struttura e il 
  comportamento del sistema.
- La progettazione dell’architettura software, identificando i moduli 
  principali e il loro collegamento.
- La progettazione del database per garantire la persistenza dei dati.
- La definizione della GUI, con JavaFX (da definire) come framework grafico.

#### Implementazione e test
Durante la fase di implementazione, il team sviluppa i moduli funzionali del software:
- Realizzazione dei giochi (blackjack, roulette, e poker) in modo 
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
Tutti i membri del team partecipano attivamente alla progettazione e allo sviluppo del software. Dopo la pubblicazione sarà disponibile un forum dedicato dove i giocatori potranno segnalare bug e malfunzionamenti, oltre che proporre idee e nuove funzionalità da integrare.
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
  - Git per il controllo del versionamento del codice, utilizzando 
    strategie come Git Flow per la gestione dei rami.
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
- Tecniche di testing(? da definire?) !!!!

 ## 1.9 Garanzie di qualità
 La qualità del software è garantita dall'osservazione in tutte le fasi dei seguenti criteri:
 -Funzionalità: il software deve rispettare le esigenze espresse e deve funzionare senza 
 errori, verranno eseguiti diversi test funzionali per assicurare che operi correttamente in 
 tutti gli scenari previsti
 -Affidabilità: il software deve garantire un elevato livello di prestazioni durante 
 l'utilizzo e deve operare sempre in modo stabile.
 -Usabilità: il software deve offrire un'esperienza utente ottimale. L'interfaccia utente sarà 
 semplice con un focus sulla facilità d'uso; verranno inviati messaggi chiari e tempestivi 
 per ogni interazione dell'utente, come conferme delle operazioni e notifiche di errori in 
 modo da facilitare l'utilizzo.
 -Manutenibilità: il software deve essere aggiornabile nel tempo, per far fronte a nuove esigenze o correggere eventuali malfunzionamenti.

 
## 1.10 Package di lavoro  DA SISTEMARE NON SONO SICURA
  Elenco dei package di lavoro

| **ID** | **Nome del package**           | **Descrizione**                                                                 | **Responsabile**       | **Output atteso**                               | **Durata prevista** |
|--------|--------------------------------|---------------------------------------------------------------------------------|------------------------|-------------------------------------------------|---------------------|
| WP1    | Raccolta requisiti             | Identificazione dei requisiti utilizzando la metodologia MoSCoW.                | Luca e Erica          | Documento dei requisiti.                       | 1 settimana         |
| WP2    | Progettazione                  | Creazione di diagrammi UML e definizione dell'architettura MVC.                 | ???                   | Diagrammi UML, struttura del progetto.         | ???         |
| WP3    | Configurazione ambiente        | Configurazione di GitHub, Maven, database SQLite(?) e JavaFX(?).                      | ???                | Ambiente pronto per lo sviluppo.               | ???         |
| WP4    | Sviluppo del Model             | Implementazione della logica applicativa, del database e delle regole di gioco. | ???                 | Componenti del Model funzionanti.              | ???         |
| WP5    | Sviluppo del Controller        | Implementazione della logica che collega il Model con la View.                  | ???                   | Controller funzionanti e testati.              | ???         |
| WP6    | Sviluppo della View            | Creazione dell’interfaccia grafica con JavaFX.                                  | ???                | Interfaccia grafica operativa.                 | ???         |
| WP7    | Integrazione e testing         | Integrazione dei moduli e test unitari, di integrazione e di sistema.           | Tutto il team          | Software funzionante e testato.                | ???         |
| WP8    | Documentazione                 | Creazione della documentazione finale, inclusi manuale utente e report tecnico. | ???                 | Documentazione completa del progetto.          | 1 settimana         |

  ## 1.11 Risorse
  Le risorse usate dal team sono le seguenti:
  - Github come sistema per il Configuration Management
  - Papyrus come software per la creazione dei diagrammi UML
  -  *** per la crezione del database
  -  Eclipse come ambiente di sviluppo

 L'utente invece per poter usare il software necessita semplicemente di un computer. 

  ## 1.12 Budget e pianificazione
  Non è stato concordato alcun budget monetario, ma solamente il tempo messo a disposizione dal team. 
  
  ## 1.13 Cambiamenti
  Qualsiasi cambiamento potrà essere effettuato solamente dopo l'approvazione da parte di tutti  membri del team della richiesta di modifica.
  Le proposte di cambiamento potranno provenire sia dai membri del team sia dagli utenti attraverso l’apposito forum. Ogni richiesta dovrà essere corredata da una 
  documentazione dettagliata che illustri il motivo della modifica e i benefici che essa comporterebbe.

  ## 1.14 Consegna
La consegna del progetto è prevista per cinque giorni prima dell'esame scritto, mentre il project plan deve essere consegnato un mese prima dell'esame. Il team si impegna,inoltre, ad effettuare un'ultima revisione prima della pubblicazione finale del progetto.
