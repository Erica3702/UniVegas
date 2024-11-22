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
  Questo project plan si riferisce al progetto di ingegneria del Software a.a. 24/25, si basa sullo sviluppo di un casinò virtuale all'interno del quale è 
  possibile giocare a tre differenti giochi: Blackjack, Poker e Roulette. Le partite si possono svolgere in due differenti modalità: multiplayer sullo stesso pc e 
  single player.

   ## 1.1 Introduzione
  Negli ultimi anni, il settore del gioco d'azzardo online ha registrato una crescita esponenziale, spinta dall'aumento dell'accesso a internet, dall'evoluzione 
  tecnologica e dalla crescente popolarità dei giochi digitali.
  Il progetto prevede lo sviluppo, il test e il rilascio del software entro il 24/01/2025, attraverso l'impiego di metodologie agili per garantire un 
  approccio flessibile e iterativo. Questo documento illustra i dettagli relativi agli obiettivi, alla portata, ai requisiti tecnici, al piano di lavoro e alle 
  risorse necessarie per lo sviluppo del progetto. I requisiti sono stati classificati e prioritizzati con l'approccio MoSCoW come verrà mostrato in seguito.
  
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
Tutti i membri del team sono coinvolti nella progettazione del gioco. Verrà reso disponibile un forum in seguito alla pubblicazione che permetterà ai giocatori di segnalare bug ed eventuali malfunzionamenti, oltre che suggerire idee e nuove funzionalità da implementare. 
Sono previsti due incontri a settimana, lunedì e venerdi ed eventuali meeting per analizzare e pianificare le successive attività da svolgere.
Si è deciso di suddividere i lavori in base alle capacità personali, con l'aggiunta di una revisione del codice in seguito ad ogni giornata lavorativa, che permette a chi l'ha sviluppato di spiegare ciò che ha realizzato e agli altri membri del team di proporre evenutuali migliorie.

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
Lo sviluppo del progetto è stato organizzato seguendo i principi dei metodi agili, in particolare ispirandosi alla filosofia dell'Extreme Programming, che favorisce una maggiore efficienza e flessibilità ad eventuali modifiche dei requisiti. Il team ha collaborato in tutte le fasi, in modo da mantenere sempre il focus sugli obiettivi del progetto piuttosto che quelli personali.
Durante i primi incontri è stata data grande importanza all'attività pianificazione, alla scelta dei requisiti e alla loro classificazione in base alla priorità, dopodichè è stato eseguito il lavoro vero e proprio, in parallelo con verifiche e test per assicurarsi volta per volta che tutto venisse svolto correttamente. 
Per ogni attività pianificata è stata inoltre definita una scadenza allo scopo di garantire un avanzamento costante del progetto, monitorare i progressi rispetto agli obiettivi prefissati e intervenire tempestivamente in caso di eventuali ritardi o problematiche.

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
  I membri che hanno partecipato al progetto sono stati precedentemente menzionati.
  ## 1.8 Metodi e tecniche
  ## 1.9 Garanzie di qualità
  
  ## 1.10 Package di lavoro
  ## 1.11 Risorse
  Le risorse usate dal team sono le seguenti:
  - Github come sistema per il Configuration Management
  - Papyrus come software per la creazione dei diagrammi UML
  -  *** per la crezione del database
  -  Eclipse

 L'utente invece per poter usare il software necessita semplicemente di un computer. 

  ## 1.12 Budget e pianificazione
  ## 1.13 Cambiamenti
  Qualsiasi cambiamento potrà essere effettuato solo dopo l'approvazione da parte del team della richiesta di modifica.
  I cambiamenti, come detto in precedenza, potranno essere suggeriti dagli utenti tramite un forum apposito, oltre che dai membri del team per perfezionare il software insieme alla documentazione per chiarire le    migliorie introdotte.

  ## 1.14 Consegna
