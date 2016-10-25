# Design document

In het readme bestand staat omschreven hoe de app er uit moet komen te zien. Nu dat bekend is, is het tijd om te kijken naar hoe dit daadwerkelijk geïmplementeerd gaat worden. Dat zal beschreven worden in dit document, het 'design document'.

## Activities
In het readme bestand zie je hoe je van scherm naar scherm kunt navigeren. Dat wil zeggen: welke knoppen je moet indrukken/handelingen je moet verrichten om van het ene naar het andere scherm te komen. Deze schermen (in android taal: 'activities') zijn echter niet altijd uniek. Soms kun je op verschillende manieren bij dezelfde of heel vergelijkbare activities komen. In afbeelding 1 is te zien hoe er tussen de activities genavigeerd kan worden. De zwartomrande blokken zijn activities, de gekleurde pijlen geven aan welke 'paden' je door activities je kunt nemen. Bij de gekleurde lijnen staat ook (in de bijbehorende kleur) waar je op moet drukken om van activity naar activity te gaan. Hierbij geven aanhalingstekens aan dat het om een knop (met die tekst erop) gaat. Onder de afbeelding staat omschreven welke inhoud bij de activities hoort.

![Afbeelding 1](https://github.com/J0rrr/Practicum-assistent/blob/master/doc/Activity%20hierarchie.png)
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
Stijl lijkt misschien niet zo'n belangrijk punt, maar het heeft wel degelijk invloed op de code en er kan dus niet vroeg genoeg over nagedacht worden. Ik heb er voor gekozen om 'material design' van android aan te houden (zie https://developer.android.com/design/material/index.html). In dit relatief nieuwe design zit de 'material theme', welke ik aan zal houden in de app. Omdat sommige elementen uit de theme alleen werken vanaf android API level 21 of hoger, kies ik er dan ook voor om android API 21 als 'target' aan te houden. De app zal dus te gebruiken zijn door telefoons vanaf android API 21 (android 5.0 Lollipop). Met deze stijlkeuze komen de Home-, NieuwPracticum- en PracticumActivities er als volgt uit te zien:

<kbd>
  <img src="https://github.com/J0rrr/Practicum-assistent/blob/master/doc/Screenshot_20161025-111536.png" width="200">
</kbd>
<kbd>
<img src="https://github.com/J0rrr/Practicum-assistent/blob/master/doc/Screenshot_20161025-111532.png" width="200">
</kbd>
<kbd>
<img src="https://github.com/J0rrr/Practicum-assistent/blob/master/doc/Screenshot_20161025-111513.png" width="200">
</kbd>
<kbd>
<img src="https://github.com/J0rrr/Practicum-assistent/blob/master/doc/Screenshot_20161025-111520.png" width="200">
</kbd>
*Afbeelding 2a, 2b, 2c, 2d, Uiterlijk van drie activities.*


## Data opslag
Het opslaan van alle gebeurtenissen is de belangrijkste functie van de app. Het is dan ook zaak dat dit op een goede en veilige manier gebeurt. De datastructuur is niet ingewikkeld, een tabel is voldoende per klas per periode. De kolommen ('x') van de tabel staan dan voor leerlingen, de rijen ('y') voor practica en de velden worden gevuld met de gebeurtenissen van leerling x tijden practicum y. Zie afbeelding x voor een voorbeeld van zo'n tabel. 




![Afbeelding x](https://github.com/J0rrr/Practicum-assistent/blob/master/doc/spreadsheet output.PNG)
*Afbeelding x, Spreadsheet output.*
