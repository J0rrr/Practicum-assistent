# Design document

In het readme bestand staat omschreven hoe de app er uit moet komen te zien. Nu dat bekend is, is het tijd om te kijken naar hoe dit daadwerkelijk geïmplementeerd gaat worden. Dat zal beschreven worden in dit document, het 'design document'.

## Activities
In het readme bestand zie je hoe je van scherm naar scherm kunt navigeren. Dat wil zeggen: welke knoppen je moet indrukken/handelingen je moet verrichten om van het ene naar het andere scherm te komen. Deze schermen (in android taal: 'activities') zijn echter niet altijd uniek. Soms kun je op verschillende manieren bij dezelfde of heel vergelijkbare activities komen. In afbeelding 1 is te zien hoe er tussen de activities genavigeerd kan worden. De zwartomrande blokken zijn activities, de gekleurde pijlen geven aan welke 'paden' je door activities je kunt nemen. Bij de gekleurde lijnen staat ook (in de bijbehorende kleur) waar je op moet drukken om van activity naar activity te gaan. Hierbij geven aanhalingstekens aan dat het om een knop (met die tekst erop) gaat. Onder de afbeelding staat omschreven welke inhoud bij de activities hoort.

![Afbeelding 1](doc/Activity%20hierarchie.png)
*Afbeelding 1, Activity hierarchie.*

- Home: Het hoofdmenu met 5 knoppen.
- NieuwPracticum: Scherm dat je te zien krijgt wanneer je een nieuw practicum wilt maken.
- Practicum: Lijst met klikbare namen van leerlingen.
- Detail: Detailoverzicht van de gebeurtenissen van één leerling tijdens één practicum.
- klassen: Lijst met klassen met een optie om de klassen te bewerken.
- Practica: Lijst met practica die zijn verricht door de geselecteerde klas/leerling.
- leerlingen: Lijst met leerlingen met een optie om leerlingen toe te voegen.
- gebeurtenissen: Lijst met de mogelijke gebeurtenissen tijdens de practica (met score). Mogelijkheid om aan te passen/toe te voegen.
- NieuwePeriode: Scherm dat je te zien krijgt als je een nieuwe periode wilt starten.

De namen van de activities zoals ze in de code zullen worden geïmplementeerd, zijn de bovenstaande namen + 'Activity.java'. Dus 'Home' heet in de code 'HomeActivity.java', het bijbehordende layout-bestand zal 'layout_home.xml' heten. Dit naar android standaarden.

## Stijl
Stijl lijkt misschien niet zo'n belangrijk punt, maar het heeft wel degelijk invloed op de code en er kan dus niet vroeg genoeg over nagedacht worden. Ik heb er voor gekozen om 'material design' van android aan te houden (zie https://developer.android.com/design/material/index.html). In dit relatief nieuwe design zit het 'material' thema, welke ik aan zal houden in de app. Omdat sommige elementen uit het thema alleen werken vanaf android API level 21 of hoger, kies ik er voor om android API 21 als 'target' aan te houden. De app zal dus te gebruiken zijn door telefoons vanaf android API 21 (android 5.0 Lollipop). Met deze stijlkeuze komen de Home-, NieuwPracticum- en PracticumActivities er als volgt uit te zien:

<kbd>
  <img src="doc/HomeActivity.png" width="200">
</kbd>
<kbd>
<img src="doc/NieuwPracticumActivity_1.png" width="200">
</kbd>
<kbd>
<img src="doc/NieuwPracticumActivity_2.png" width="200">
</kbd>
<kbd>
<img src="doc/PracticumActivity.png" width="200">
</kbd>
*Afbeelding 2a, 2b, 2c, 2d, Uiterlijk van drie activities (HomeActivity, NieuwPracticumActivity en PracticumActivity).*

De kleuren kunnen binnen dit thema heel makkelijk aangepast worden (in een , wat betekent dat daar nog geen keuze in gemaakt hoeft te worden. 


## Data opslag
Het opslaan van alle gebeurtenissen is de belangrijkste functie van de app. Het is dan ook zaak dat dit op een goede en veilige manier gebeurt. De datastructuur is niet ingewikkeld, een tabel is voldoende per klas per periode. De kolommen ('x') van de tabel staan dan voor leerlingen, de rijen ('y') voor practica en de velden worden gevuld met de gebeurtenissen van leerling x tijden practicum y. Zie afbeelding 3 voor een voorbeeld van zo'n tabel.

Voor het daadwerkelijk opslaan van de data zal gebruik gemaakt worden van SQLite. Dit relationele database management system zit standaard in android ingebakken. Met SQLite kan de app vrij gemakkelijk alle data en de onderlinge relaties daartussen kwijt in één bestand dat op het apparaat blijft staan, zelfs als het wordt uitgeschakeld.

## Data output
Het zou zonde zijn als alle gedocumenteerde gebeurtenissen alleen op de telefoon blijven staan, zonder dat er iets mee gebeurt. Want naast het documenteren van gebeurtenissen en toekennen van score aan leerlingen, is het ook wenselijk dat de leerlingen hier iets van terugzien, zodat ze zelf weten wat goed gaat/wat beter kan. Er moet dus een manier komen om de data op de pc te krijgen, waarna het bewerkt en uitgeprint/digitaal uitgereikt kan worden. Door de vorm van de data (tabellen per klas per periode), ligt een spreadheet voor de hand. Het gebruik van Google sheets heeft als voordeel dat de sheets automatisch naar de cloud worden gesynchroniseerd (namelijk je google drive). Gelukkig heeft Google sheets een uitgebreide API (https://developers.google.com/sheets/), waardoor bovenstaande plan prima uitgevoerd kan worden. Afhankelijk van de snelheid van het genereren/updaten van een sheet, moet nog worden besloten of dit 'realtime' zal gebeuren (bijvoorbeeld elke keer dat de SQLite database update), of dat er een extra knop in het hoofdmenu komt waarmee de Google sheet geupdate/aangemaakt wordt. Zie afbeelding 3 voor een voorbeeld van zo'n sheet (geopend in Excel).

![Afbeelding 3](doc/spreadsheet output.PNG)
*Afbeelding 3, Spreadsheet output.*
