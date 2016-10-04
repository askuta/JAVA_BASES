Adattípusok
===========

A Java egy objektumorientált programozási nyelv. Ez kb. azt jelenti, hogy a
nyelven belül vannak az osztályok (amik valós vagy nem valós dolgok számunkra
és az adott program számára releváns tulajdonságait és viselkedését írják le),
ezekből az osztályokból a programunk futása során példányokat hozunk létre, amik
egymással kommunikálnak. Amikor elfogy a mondanivalójuk, a programunk véget ér.

Képzeld el úgy, hogy az osztályok a tervrajzok, a példányok a házak, autók, stb.
amiket a tervrajzok alapján elkészítünk.

Egy ideális világban, egy ideális objektumorientált programozási nyelvben minden
osztályokból és az osztályok példányaiból épülne fel. Sajnos nem ideális világban
élünk és a Java sem ideális objektumorientált programozási nyelv. Az osztályokon
és az osztályok példányain kívül vannak még primitív típusaink, aminek történelmi
okai vannak és ami néha fejfájást okoz szegény programozóknak.

Primitív adattípusok
--------------------

Mindegyik primitív adattípusoknak van objektumorientált megfelelője (van hasonló
osztály). Amikor lehet, igyekszünk a primitív adattípusokat használni, mert kevesebb
memóriát foglalnak le, könnyebb átalakítani őket más primitív adattípussá és mert
azt szoktuk meg. Az osztály megfelelőiket akkor használjuk, ha collection-ökben
(olyan osztályok, amik más osztályok példányait tárolják, pl. listák, halmazok,
mapek) akarjuk őket tárolni vagy valamilyen más okból példányokként, objektumokként
szeretnénk kezelni őket.

+--------+--------+----------------------------+---------------------------+-----------+
|        | méret  | min                        | max                       | osztály   |
+--------+--------+----------------------------+---------------------------+-----------+
| byte   | 8 bit  | -128                       | 127                       | Byte      |
+--------+--------+----------------------------+---------------------------+-----------+
| short  | 16 bit | -32.768                    | 32.767                    | Short     |
+--------+--------+----------------------------+---------------------------+-----------+
| int    | 32 bit | -2.147.483.648             | 2.147.483.647             | Integer   |
+--------+--------+----------------------------+---------------------------+-----------+
| long   | 64 bit | -9.223.372.036.854.775.808 | 9.223.372.036.854.775.807 | Long      |
+--------+--------+----------------------------+---------------------------+-----------+
| float  | 32 bit | 1.4E-45                    | 3.4028235E38              | Float     |
+--------+--------+----------------------------+---------------------------+-----------+
| double | 64 bit | 4.9E-324                   | 1.7976931348623157E308    | Double    |
+--------+--------+----------------------------+---------------------------+-----------+
| char   | 16 bit | 0                          | 65.535                    | Character |
+--------+--------+----------------------------+---------------------------+-----------+
| bool   | 8 bit  | -------------------------- | ------------------------- | Boolean   | 
+--------+--------+----------------------------+---------------------------+-----------+

Ha valahol a kódunkban meg kell jelölnünk egy float vagy long konstans típusát, akkor
azt a úgy tehetjük meg, hogy egy 'l', 'L' betűt írunk a szám után long esetén vagy 'f',
'F' betűt float esetén:

  42l; 42L; 42.01f; 42.01F

Alapvetően az int és a double típusokat szoktuk használni számok ábrázolásához. A nyelv
is ezt a két típust feltételezi, ha egy számot típus nélkül írunk bele a kódunkba.

Más nyelvekkel ellentétben a Java nem támogatja az "unsigned" (előjel nélküli) típusokat.

A char típus 0-tól 65.535-ig terjedő számokkal ábrázolja a karaktereket, amik az UTF-16
szabványnak felelnek meg.

A bool értéke lehet "true" vagy "false", a mérete azért 8 bit, mert a processzorok úgy
vannak felépítve, hogy legkevesebb 8 bitet (1 byteot) tudnak egy egységként kezelni.

Metódusokon belül minden típusnak értéket kell adnod mielőtt hivatkozol rájuk, más
esetekben, pl. egy osztály adattagjaiként kapnak default értéket, ami 0, 0.0 vagy false
lesz a típustól függően.

A táblázatban a float és a double kicsit trükkös, mert a hozzájuk tartozó MIN_VALUE nem
a legkisebb negatív számot jelenti amit az adott típus kezelni tud, hanem a legkisebb,
0-nál nagyobb számot.

A float és a double azért is trükkös, mert 32 vagy 64 biten jóval nagyobb számot tud
kezelni mint az int vagy a long. Hogy lehetséges ez? Úgy, hogy ez a két típus a számokat
átalakíthatja és a következő formátumban írja le:
  [SZAM] * 10 E [HATVANY]
Amíg lehet, a számokat [SZAM]-ként ábrázolja ([SZAM] egy tört szám), amikor ez már nem
lehetséges, akkor [SZAM] és 10 [HATVANY]-adik szorzataként. Tehát pl. 100-at "100.0"-ként
ábrázol, float-ként a 2147483647-et (ez az Integer.MAX) pedig "2.14748365E9"-ként. Mi
lesz az eredménye, ha a float "2.14748365E9"-hez adok egyet? "2.14748365E9"-et kapok
eredményül, tehát nem változik az érték, mivel a [SZAM] pontossága nem teszi lehetővé,
hogy ilyen kis változást "érzékeljen" a típus.

Nézzük tovább a pontosságot. Mi történik, ha egy művelet kivinne minket egy adott
típusból? Mi történik például, ha a byte max értékéhez adunk egyet:
  127 + 1 = -128
Ennek az az oka, hogy a byte, short, int és a long típusok első bitje az előjel bit. Ha
az értéke 0 akkor a szám pozitív, ha 1 akkor negatív.
  127 binárisan: 01111111 (azért kezdtem 0-val, hogy kitöltsem a 8 bitet)
  127 + 1 binárisan: 10000000 (ami a byte típusnál -128-at jelent)

Bináris számoknál a pozitív értékeket úgy képezzük, hogy a megfelelő 2-es helyiértékeket
összeadjuk. Ha utánaszámolsz, beláthatod, hogy így 0-tól 127-ig kapunk értéket:

  +--------+-----+-----+-----+-----+-----+-----+-----+
  | előjel | 2^6 | 2^5 | 2^4 | 2^3 | 2^2 | 2^1 | 2^0 |
  +--------+-----+-----+-----+-----+-----+-----+-----+
  | 0      | 64  | 32  | 16  | 8   | 4   | 2   | 1   |
  +--------+-----+-----+-----+-----+-----+-----+-----+

Negatív számoknál hasonlóan összeadjuk a 2-esek helyiértékeit, hasonlóan 0-tól 127-ig
kapunk értéket, amit hozzáadunk -128 -hoz. Itt is, ha utánaszámolsz, beláthatod, hogy
az eredmény -128-tól -1 -ig lehet:

  +--------+-----+-----+-----+-----+-----+-----+-----+
  | előjel | 2^6 | 2^5 | 2^4 | 2^3 | 2^2 | 2^1 | 2^0 |
  +--------+-----+-----+-----+-----+-----+-----+-----+
  | 1      | 64  | 32  | 16  | 8   | 4   | 2   | 1   |
  +--------+-----+-----+-----+-----+-----+-----+-----+

  Így lesz:

  127 binárisan: 01111111
  127 + 1 binárisan: 10000000
  Az első 1-es az előjel, ami 1, tehát negatív.
  A maradék 7 bit 0.
  A szám tehát -128 + 0 = -128

Hasonlóan, ha a byte típusú -128-ból kivonunk 1-et, akkor 127-et kapunk eredményül.

Mindkét esetet "túlcsordulásnak" hívjuk. Ha nem érted pontosan a túlcsordulást,
érdemes leülni és papíron vagy számítógépen eljátszadozni vele.

Mi röténik akkor, ha egy egész számot elosztok egy másik számmal és az eredmény tört
szám lenne? Pl. byte(3) / byte(2) eredménye nem 1,5 lesz, hanem 1. Ennek az oka,
hogy hiába lenne tört szám az eredmény, ha a típus azt nem tudja ábrázolni. Ilyenkor
a típus miatt levágódik a törtrész.

Casting
~~~~~~~

Az egész típusú számokat a Java automatikusan át tudja váltani nagyobb méretű, egész
típusokra, illetve nagyobb vagy azonos méretű lebegőpontos típusokra (float-ra vagy
double-ra). float-ból automatikusan csinálhatunk double-t:

  byte b1 = 42;
  short s1 = b1;
  float f1 = b1;
  :
  :

byte --> byte, short, int, long, float, double
short --> short, int, long, float, double
int --> int, long, float, double
long --> long, double
float --> float, double
double --> double

Saját felelősségre, kedvesen megkérhetjük a Javat, hogy nagyobb méretű típusból
készítsen kisebb méretű típust. Ilyenkor ha túlcsordul az értékünk, akkor az
szívás, mert ami nem fér bele a kisebb típusba, az elvész. Hogy ebből ne legyen
olyan könnyen rejtett hiba, ki kell kényszerítenünk a típuskonverziót úgy, hogy
zárójelben megadjuk a típust. Pl. ha long-ot akarunk kisebb méretű típusokra
konvertálni, akkor a következő a teendő:

  long l2 = 42;
  int i2 = (int) l2;
  short s2 = (short) l2;
  byte b2 = (byte) l2;

Lebegőpontos típusokból is castolhatunk egész típusokra, ami szerintem egy
gyalázatos dolog, de néha biztos hasznos lehet (a példába b3 értéke 42 lesz):

  double d3 = 42.24;
  byte b3 = (byte) d3;

Nézzük az értékadást:

  long num = 42L;

  Az egyenlőségjel bal oldalán lévő kódrészt deklarálásnak nevezzük, a jobb
  oldalán lévő kódrészt inicializálásnak. A deklarálás lefoglal a számítógép
  memóriájában egy megfelelő méretű memória részt, amit az inicializálással
  beállítunk 42-re.

           +----+
  num ---> | 42 |
           +----+
  

Osztályok, objektumok
---------------------

Az osztályokkal később foglalkozunk, most csak az objektumok létrehozását írom le
röviden. Objektumokat általában a "new" kulcsszó segítségével hozunk létre:

  File fileObject = new File("fileName");

  Az egyenlőségjel bal oldalán lévő kódrészt itt is deklarálásnak nevezzük, a
  jobb oldalán lévő kódrészt inicializálásnak. A primitív típusokkal ellentétben
  a deklarálás egy referenciát hoz létre a memóriában, ami majd egy Fájl típusú
  objektumra fog hivatkozni. A jobb oldallal létrehozzuk a File típusú objektumot,
  majd az objektum memóriacímét átadjuk a referenciának mint értéket.

                  +----------------------------+
  fileObject ---> | File object memory address |
                  +------------ | -------------+
								|
								V
						+-------------+
						| File object |
						+-------------+

NAGYON FONTOS! Amikor egy metódusnak paraméterként átadsz egy primitív típust,
akkor az érték másolódik át egy lokális válétozóba. Így ha a lokális változót
módosítod, annak a hívó metódusban semmilyen közvetlen hatása nem lesz.

Objektumok esetében a referencia másolódik át egy lokális referenciába. Így a
metódus elején mindkét referencia ugyanarra az objektumra hivatkozik, tehát
ha a metóduson belül megváltoztatod az objektumot, azzal a "hívó metódusban
is megváltoztatod az objektumot", mert mindkét metódus ugyanarra az objektumra
vonatkozik.

Memory poolok
~~~~~~~~~~~~~

Lehetőségünk van arra, hogy néhány osztályt a new kulcsszó nélkül
példányosítsunk. Ilyen osztályok a primitív típusok megfelelői, illetve a
String osztály. Ha ezekből az osztályokból a new kulcsszóval hozol létre
példányokat, akkor mindig új objektum keletkezik. Ha nem a new kulcsszóval,
akkor a Java optimalizál, megnézi, hogy a pooljaiban szerepel-e már az adott
objektum és ha szerepel, akkor nem hoz létre újat, hanem a meglévőt fogja
használni:

  Long long1 = new Long(3); // Új objektum keletkezik.
  Long long2 = 3L; // Ha van már Long objektum aminek 3 az értéke, akkor
                   // nem keletkezik új objektum.

  String str1 = new String("bakfitty"); // Új objektum keletkezik.
  String str2 = "bakfitty"; // Ha van már String objektum aminek "bakfitty"
                            // az értéke, akkor nem keletkezik új objektum.

A poolok mérete nem végtelen, String-ekből próbál mindent poololni, de a
számokból csak egy bizonyos értékig (egész típusoknál talán -128-tól 127-ig).

Autoboxing
----------

A Memory pooloknál volt egy rusnya példa:

  Long long2 = 3L;

A deklarálással (bal oldal) létrehoztunk egy referenciát, ami egy Long típusú
objektumra hivatkozik, majd az inicializálással (jobb oldal) létrehoztunk egy
primitív long értéket. Aztán valami csoda történt, a Java észrevette, hogy
a két típus nem ugyan kompatibilis, de nem azonos, ezért a háttérben létrehozott
egy Long típusú objektumot (pontosabban megnézte a poolban és ha nem volt benne,
akkor létrehozta) "3" értékkel és átadta a referenciát a "long2"-nek.

Az autoboxing visszafelé is működik, írhatunk olyat, hogy:

  long primitiveLong = long2;
