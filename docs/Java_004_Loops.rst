Ciklusok
========

Amikor szeretnénk egy kódblokkot többször végrehajtani (adott számú ismétlés vagy
amíg egy feltétel teljesül), olyankor ciklusokat használunk. Több lehetőség közül
is lehet választani, az adott feladattól függően választjuk ki a megfelelőt. A
ciklusok kis trükközéssel átírhatóak egymásba.

FOR ciklus
----------

A for ciklust egy kódblokk adott számú végrehajtásához használjuk. Általában.

  for (inicializálás; feltételek; műveletek) {
    // kódblokk
  }

- inicializálás: ciklusváltozók inicializálása (általában csak egyre van
  szükségünk, de lehetőség van több változó létrehozására)
- feltételek: addig fut a ciklus amíg minden feltétel igaz, utána megáll
  (általában csak egyre van szükségünk, de lehetőség van több feltétel
  megadására)
- műveletek: a ciklusváltozókon hajthatsz végre tetszőleges műveleteket,
  amik az iterációk végén hajtódnak végre

Bármelyik elhagyható az "inicializálás", "feltételek", "műveletek" közül vagy
akár mindegyik egyszerre. Ha mindegyiket elhagyod, akkor egy végtelen ciklust
kapsz (nem nagyon használják, de jó ha tudsz róla):

  for ( ; ; ) {
    // kódblokk
  }

A végtelen ciklusnak nevükben a lényegük: sose állnak le maguktól. A végtelen
ciklusokat vagy a ciklus "kódblokkbjából" állítjuk le vagy magát a java programot
gyilkoljuk le kívűlről erőszakkal.

FOR ciklus tömbökhöz és collection-ökhöz
----------------------------------------

Ha szeretnél végigmenni egy tömb vagy egy collection (halmaz, lista, sor)
elemein, akkor 5-ös Javatól lehetőség van használni a FOR egy változatát:

  String[] strArray = new String[10];
  for (String element : strArray) {
    // kódblokk
  }

A teljesség kedvéért a példa első sorában létrehoztam egy tömböt, ami String-eket
tartalmaz. Szám szerint 10 darabot. A példa második sora, azon belül is a
zárójeles rész érdekes nekünk. A "String" határozza meg a tömb elemeinek típusát.
Az "element" egy tetszőleges név, amivel a tömb adott elemére hivatkozhatunk a
kódblokkon belül. Végül, egy kettőspont után hivatkozok a tömbre amin végig
szeretnék iterálni.

A "végigiterálást" meg lehet szakítani itt is a kódblokkból. Tehát, ha pl. egy
bizonyos elemét keresed a tömbnek, ami után a többi már nem érdekel, van
lehetőség kiugrani a ciklusból. De ezt majd később.

WHILE ciklus
------------

A WHILE ciklust akkor használjuk, ha egy kódblokkot egy feltétel teljesüléséig
szeretnénk újra és újra végrehajtani.

  while (feltételek) {
    // kódblokk
  }

Fontos megjegyezni, hogy a feltételek a kódblokk végrehajtása előtt értékelődik ki.
Ha a feltételek nem teljesülnek már az első iterációban, a kódblokk egyszer sem fog
lefutni.

Ha végtelen ciklusra van szükségünk, általában a végtelenített WHILE ciklust
használjuk. Kevésbé gusztustalanul néz ki mint a "for (;;)". Ebben az esetben
is a cikluson belülről tudjuk megszakítani az ismétlődéseket vagy az egész
programot állítjuk le erőszakkal.

  while (true) {
    // kódblokk
  }

DO-WHILE ciklus
---------------

Ezt a ciklust akkor használjuk, ha szeretnénk legalább egyszer végrehajtani a
kódblokkunkat.

  do {
    // kódblokk
  } while (feltételek);

A feltételek mindig a kódblokk lefutása után értékelődnek ki és akkor dől el,
hogy lesz-e újabb iteráció.

A végtelenített változat:

  do {
    // kódblokk
  } while (true);

Ezzel a ciklussal pl. jól lehetne kezelni a számkitalálós játékot, mivel a user
legalább egy számot be kell hogy gépeljen.

FONTOS: A WHILE sora végén van egy pontosvessző!

Vezérlésmódosító utasítások
===========================

Ciklusokon belül 3 furmányos dolgot tehetsz:
- return: az adott ponton leáll a ciklus, és a program kilép a metódusból
- break: az adott ponton leáll a ciklus, és a program a ciklus utáni sorral
  folytatódik
- continue: a program a ciklus végére ugrik és (ha a ciklus feltételei
  teljesülnek) jön a következő iteráció

BREAK
-----

  while (true) {
    // kódblokk 1
	if (condition) break;
	// kódblokk 2
  }
  // kódblokk 3

Ha "condition" teljesül, akkor a "break" hatására kiugrik a vezérlés a ciklusból
("kódblokk 2" nem fut le) és "kódblokk 3"-mal folytatódik a program.

CONTINUE
--------

  while (true) {
    // kódblokk 1
	if (condition) continue;
	// kódblokk 2
  }
  // kódblokk 3

Ha "condition" teljesül, akkor a "continue" hatására a vezérlés átugorja a
"kódblokk 2"-t (a ciklus végére ugrik) és folytatódik a ciklus végrehajtása a
következő iterációval.
