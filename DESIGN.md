# Design document

In het readme bestand staat omschreven hoe de app er uit moet komen te zien. Nu dat bekend is, is het tijd om te kijken naar hoe dit daadwerkelijk geïmplementeerd gaat worden. Dat zal beschreven worden in dit document, het 'design document'.

## Activities
In het 'readme' bestand zie je hoe je van scherm naar scherm kunt navigeren. Dat wil zeggen: welke knoppen je moet indrukken/handelingen je moet verrichten om van het ene naar het andere scherm te komen. Deze schermen (in android taal: 'activities') zijn echter niet altijd uniek. Soms kun je op verschillende manieren bij dezelfde of heel vergelijkbare activities komen. In afbeelding 1 is te zien hoe er tussen de activities genavigeerd kan worden. Uit de afbeelding is alleen op te maken dat je tussen bepaalde activities kunt navigeren, niet welke handeling je moet verrichten om dit te doen. Onder de afbeelding staat omschreven welke inhoud bij de activities hoort.

![Afbeelding 1](https://github.com/J0rrr/Practicum-assistent/blob/master/doc/app_hierarchie.PNG)
*Afbeelding 1, Activity hierarchie.*

- homeActivity: Het hoofdmenu met 5 knoppen.
- nieuwPracticumActivity: Scherm dat je te zien krijgt wanneer je een nieuw practicum wilt maken.
- leelingDetailActivity: Overzicht gebeurtenissen van één leerling tijdens één practicum. 
- practicumActivity: Lijst met leerlingen uit de vooraf geselcteerde klas.
- klassenActivity: Lijst met klassen met een optie om de klassen te bewerken.
- leerlingenActivity: Lijst met leerlingen met een optie om leerlingen toe te voegen.
- oudePracticaActivity: Lijst met practica uit het verleden.
- gebeurtenissenActivity: Lijst met de mogelijke gebeurtenissen tijdens de practica (met score).
- nieuwePeriodeActivity: Scherm dat je te zien krijgt als je een nieuwe period wilt starten.

