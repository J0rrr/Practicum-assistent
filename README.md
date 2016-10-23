# Practicum-assistent
Een app die helpt in het documenteren en becijferen van practica van middelbare scholieren.

## Introductie
In de natuurkundelessen die ik aan middelbare scholieren geef, doen we vaak aan practica. Deze practica worden aan het eind van elk trimester beoordeeld met een cijfer, gebaseerd op hoe serieus elke leerling aan de practica heeft deelgenomen. Tegenwoordig wordt dit cijfer vastgesteld op basis van mijn geheugen en wat werk dat de leeringen inleveren. Met meerdere practica over maanden van tijd en met zo'n honderd leerlingen, voelt het becijferen af en toe helaas meer als gokwerk dan iets anders. Een app zou kunnen helpen in het documenteren van sommige gebeurtenissen (zoals slecht gedrag of goede vragen van leerlingen) tijdens de practica. Deze app zou ook een cijfer kunnen toekennen aan elke leerling aan het einde van elk trimester, en de leerlingen kunnen eindelijk een document uitgerijkt krijgen met daarop een gedetailleerd overzicht van de vaststelling van hun practicumcijfer.

## Vereisten
Wat is er belangrijk voor zo'n app? In de eerste plaats moet de app makkelijk en snel te gebruiken zijn. Ik, net als docenten in het algemeen, heb niet veel tijd tijdens de les om me met een app bezig te houden. Tijdens de les ben ik er primair om leerlingen te helpen/begeleiden. Daarnaast staat het niet zo charmant als de docent de hele tijd 'op zijn telefoon zit', terwijl dit voor de leerlingen verboden is. Tijdens de practica zou enkel een paar klikken op knoppen dus genoeg moeten zijn om bepaalde gebeurtenissen te documenteren.

Daarnaast is stabiliteit en onafhankelijkheid erg belangrijk. Als de app gebruikt gaat worden om leerlingen te beoordelen, moet het altijd werken, anders zou het wel eens oneerlijk kunnen zijn ten opzichten van bepaalde leerlingen. Fatale bugs en crashes moeten dus tot een minimum beperkt worden, en de app mag niet afhankelijk zijn van bijvoorbeeld het hebben van een internetverbinding.

Dan nu een lastig punt: door wie gaat de app gebruikt worden? In principe wordt deze app ontwikkeld met een zeer klein publiek in het achterhoofd, namelijk alleen ikzelf. Ik ben (nog) niet van plan om de app op publiek te maken, wat voor de inhoud een aantal dingen betekent. Zo zal de app redelijk specifiek zijn voor de manier waarop bij mij op school practica gegeven worden. Ook zal alleen ontwikkeld en getest worden met een behapbaar aantal klassen (een stuk of 10) en aantal leerlingen (enkele honderden), simpelweg omdat dat de aantallen zijn waar een docent bij mij op school mee te maken heeft. Het streven is er dus om de app voor mijn gebruik perfect te maken, in plaats van een universelere 'goede' app. Toch is het ook niet de bedoeling dat de app zo specifiek wordt dat niemand anders hem kan gebruiken, ik zal dus ook zeker geen namen van bijvoorbeeld de school of leerlingen hard-coden. Ook probeer ik om de app zo duidelijk mogelijk te maken, zodat ook docenten die mij niet kennen ermee uit de voeten kunnen. Uiteindelijk is het de bedoeling dat mijn directe collega natuurkundedocenten de app ook gaan gebruiken. Zij kunnen me ongetwijfeld ook van waardevolle feedback voorzien.

## App design
Hieronder zal besproken worden hoe de schermem van de app er waarschijnlijk uit zullen komen te zien, te beginnen met het hoofdmenu. Daarna zal uitgelegd worden waar alle knoppen uit het hoofdmenu naar leiden en waarom.

### Hoofdmenu
Allereerst beginnen we met het hoofdmenu (zie afbeelding 1). Dit relatief simpele scherm is het eerste wat je te zien krijg bij het opstarten van de app. Met de eerste (bovenste) knop kan een nieuw practicum opgezet worden, de bedoeling is om dit net voor de les te doen of tijdens binnenkomst van de leerlingen. 


![Afbeelding 1](https://github.com/J0rrr/Practicum-assistent/blob/master/doc/Slide1%20nieuw.PNG)
*Afbeelding 1, Hoofdmenu.*


### Nieuw practicum
Het opzetten en van een practicum is te zien op afbeelding 2 (meest linker scherm). Hier moet de naam van het practicum (bijvoorbeeld 'Evenwicht met katrollen') worden ingevuld, de klas worden geselecteerd en kan eventueel nog een opmerking worden toegevoegd. Door op 'maak practicum' te drukken, wordt het practicum aangemaakt en krijg je een lijst met leerlingen uit die klas te zien (middelste scherm). Bij het drukken op een leerling verschijnt een pop-up menu (meest rechter scherm), van waaruit je een aantal standaard evenementen (zoals 'goede vraag') snel kunt aanklikken. Deze evenementen representeren een standaard scoretoekenning; elke keer dat bij een leerling zo'n evenement wordt aangeklikt neemt zijn/haar cijfer met een vooraf bepaalde hoeveelheid toe of af. Bij een evenement dat niet onder de standaard evenementen valt, kan het veld 'anders' worden ingevuld en op een van de scoretoekenningen gedrukt worden. Op deze manier kunnen uitzonderlijke of onvoorziene situaties toch de boeken ingaan en becijferd worden.

![Afbeeling 2](https://github.com/J0rrr/Practicum-assistent/blob/master/doc/Slide2.PNG)
*Afbeelding 2, Aanmaken en uitvoeren van een practicum.*

### Practica
Het kan handig zijn om een oud practicum terug te zien. Vandaar dat je vanuit het hoofdmenu door middel van de knop 'pratica' kunt navigeren naar de oude practica. Na het drukken op deze knop, moet eerst een klas geselecteerd worden (zie afbeelding 3, meest linker scherm). Daarna vershijnt een lijst met de door deze klas gedane practica (middelste scherm). Door op een practicum te klikken, verschijnt er een lijst met leerlingen en de daarbij geregistreerde evenementen (meest rechter scherm). Door in dit scherm op een leerling te klikken, zou eventueel nog een evenement toegevoegd kunnen worden. Zo zou iemand die afwezig was tijdens het praticum, wat in het voorbeeld twee punten aftrek betekent, na het practicum ingehaald te hebben de twee punten weer terug kunnen krijgen.

![Afbeeling 3](https://github.com/J0rrr/Practicum-assistent/blob/master/doc/Slide3.PNG)
*Afbeelding 3, Overzicht en inzicht practica.*


### Leerlingen
Dan zijn er nog de leerlingen. Net als bij de practica, kan het ook bij de leerlingen handig zijn om een overzicht te kunnen zien. Door op de knop 'leerlingen' te drukken, kom je in een menuutje waar je de klas moet selecteren (zie afbeelding 4, meest rehter plaatje. Deze is heel vergelijkbaar met die van afbeelding 3). Hier kun je, door op de 'menu' knop van je android-toestel te drukken, een knop tevoorschijn halen genaamd 'klassen beheren'. Via deze weg kun je klassen toevoegen of verwijderen (niet afgebeeld). Als je op een klas drukt, krijg je een lijst met leerlingen uit die klas voor je, met het practicumcijfer dat ze op dat moment staan. In dit scherm worden onvoldoendes rood. Door in dit scherm op de 'menu' knop te drukken, verschijnt een optie om leerlingen te beheren. Hier kunnen leerlingen toegevoegd dan wel verwijderderd worden (niet afgebeeld). Als je op een leerling drukt, vershijnt een overzicht met alle geregistreerde evenementen en de berekening van het cijfer (meest rechter scherm). Deze berekening berust op een bepaald startcijfer (waarover later meer), waar allerlei evenement-afhankelijke cijfer bij opgeteld/van afgetrokken worden. 

![Afbeeling 4](https://github.com/J0rrr/Practicum-assistent/blob/master/doc/Slide4.PNG)
*Afbeelding 4, Overzicht en inzicht leerlingen.*


### Start nieuwe periode
Tot slot vinden we op het hoofdmenu nog de knop 'start nieuwe periode'. Het is de bedoeling dat bij de start van elke periode deze knop wordt ingedrukt. Nadat deze knop is ingedrukt, moet nog even bevestigd worden dat dit écht is wat je wil (er is namelijk geen weg meer terug). Daarna moet het startcijfer worden ingevoerd, dit is het cijfer waar alle leerlingen de periode mee beginnen (bijvoorbeeld een 7). Vanuit dit cijfer zullen de leerlingen punten verdienen of verliezen, afhankelijk van hun gedrag tijdens de practica. 


## Technische details
Nu we weten hoe de app er uit moet zien, is het tijd om te bepalen hoe we dit daadwerkelijk gaan implementeren. 

### Google sheets
Het belangrijkste aan de app is het opslaan van de gegevens. Aan het einde van elk trimester is het de bedoeling dat er van deze gegevens een google sheet (vergelijkbaar met excel spreadheed) gemaakt wordt, dat verder uitgewerkt en/of uitgeprint kan worden. Deze sheet zal er als volgt uit moeten zien:
- Voor elke klas een aparte worksheet (tabblad).
- Elke kolom in een worksheet staat voor een leerling in de desbetreffende klas.
- Elke rij in een worksheet staat voor een practicum met de desbetreffende klas.

Op deze manier ontstaat er een matrix aan data, waarin in elke cel de gedocumenteerde gebeurtenissen van elke leerling bij elk practicum te zien zijn, met bijbehorende scoretoekenning. 

Het voordeel aan het gebruik van google sheets is dat de spreadsheets automatisch in de cloud worden opgeslagen. Ze zijn dan vanuit allerlei apparaten te vinden in de google drive. Dit scheelt ontzettend veel programmeerwerk, omdat google alle netwerktaken op zich neemt. Google sheets heeft een handige API waarmee de relatief simpele handelingen die deze app moet kunnen verrichten, makkelijk geïmplementeerd kunnen worden.

Omdat de app in gebruik zeer snel moet reageren, wordt tijdens het gebruik van de app (tijdens een practicum) gebruik gemaakt van de 'shared preferences'. Dit is een manier om binnen android data op te slaan, waarbij gebruik wordt gemaakt van 'key-value pairs'. Elke waarde (value) aan data wordt weggeschreven met een sleutel (key), en kan alleen weer gevonden worden met die sleutel. 
