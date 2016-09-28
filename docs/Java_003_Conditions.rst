IF
==

Az IF feltétel szintaxisa egyszerű, én 3 részre bontanám:

  - if kulcsszó
  - zárójelben egy logikai kifejezés
  - az if blokkja, amit én mindenképp kapcsos zárójelek közé teszek, még akkor is,
    ha ez egy művelet esetén nem kötelező

Példa:

  if (logikai_kifejezés)
    művelet;

vagy:

  if (logikai_kifejezés) {
    művelet(ek);
  }

Az if blokkjában lévő kód csak akkor hajtódik végre, ha a logikai kifejezés
kiértékelése igaz, vagyis true lesz.

A logikai kifejezésnél fontos tudni, hogy azok nem feltétlenül balról jobbra
értékelődik ki, hanem a precedencia (elsőbbség/fontosság szerint). A műveletek
precedenciájáról itt találsz egy összefoglaló táblázatot:

  https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html

Példa:

  if (false || 3 < 5 - 7 % 2 && true) {...}

Ez egy csodaszép logikai kifejezés, lehetőleg ne csinálj hasonlót! Az értéke
true lesz, így a "..." végrehajtódik.

Ha szeretnéd te is kiértékelni, indulj el fentről lefelé a belinkelt táblázaton:

  - "%" (multiplicative): 7 % 2 --> 1
  - "-" (additive): 5 - 7 % 2 --> 5 - 1 --> 4
  - "<" (relational): 3 < 5 - 7 % 2 --> 3 < 4 --> true
  - "&&" (logical AND): 3 < 5 - 7 % 2 && true --> true && true --> true
  - "||" (logival OR) : false || 3 < 5 - 7 % 2 && true --> false || true --> true

IF - ELSE
---------

Ha szeretnénk, hogy egy feltétel teljesülése esetén bizonyos művelet(ek)
hajtódjanak végre, egyébként más művelet(ek), akkor használjuk az IF-ELSE
konstrukciót. Az IF megértése után csak egy dolgot hangsúlyoznék ki, IF-ELSE
esetén az egyik ág biztosan végre fog hajtódni, a másik nem.

Példa:

  if (logikai_kifejezés) {
    művelet(ek);
  } else {
    művelet(ek)_2;
  }

IF-ELSE-IF
----------

Ha az első IF kiértékelése igaz, az első blokk hajtódik végre. Ha nem igaz, akkor
kiértékelődik a második IF és így tovább addig, amíg az egyik IF igaz nem lesz
vagy elfogynak az IF-ek. Fontos megjegyezni, hogy előfordulhat olyan eset, amikor
egyik IF kiértékelése sem lesz igaz, így egyik blokk sem hajtódik végre.

Példa:

  if (logikai_kifejezés) {
    művelet(ek);
  } else if (logikai_kifejezés_2) {
    művelet(ek)_2;
  } else if (logikai_kifejezés_3) {
    művelet(ek)_3;
  }

Ha azt szeretnéd, hogy egyik blokk mindenképp végrehajtódjon, tegyél a
feltételrendszer végére egy ELSE-t:

  if (logikai_kifejezés) {
    művelet(ek);
  } else if (logikai_kifejezés_2) {
    művelet(ek)_2;
  } else {
    művelet(ek)_3;
  }

Egymásba ágyazott IF
--------------------

Az eddigi konstrukciókat igény szerint egymásba ágyazhatod, de próbáld elkerülni
azt, hogy túl mély legyen az egymásba ágyazás. Ha mégis szükségesnek látszik,
akkor dőlj hátra és szervezd át a feltételrendszered. Mert igen, a
feltételrendszerek bizonyos szabályokat betartva átalakíthatóak más formába úgy,
hogy a jelentésük nem változik.

Példa:

  if (logikai_kifejezés) {
    if (logikai_kifejezés2) {
      művelet(ek)_1;
    } else {
      művelet(ek)_2;
    }
  } else {
    művelet(ek)_3;
  }

SWITCH
======

A switch-case az IF-ELSE-IF-hez hasonló konstrukció, pár feltétellel. A switch
utáni zárójelben lévő kifejezést vizsgáljuk, amelyik kifejezés int (vagy int-té
konvertálható), String vagy enum (felsorolás, majd később foglalkozunk vele)
lehet. A case-ek konkrét értékeket definiálnak, ami ha egyezik a switch utáni
kifejezéssel, akkor a case blokkja végrehajtódik.

- A case blokkjának nem feltétlenül kell kapcsos zárójelben lennie.
- A case blokk végére tehetsz "break;"-et, ami kiugrasztja a vezérlést a switch
  utánra.
- Ha nem teszel "break;"-et, akkor a kiértékelés abban az esetben is folytatódik
  a következő case(ekk)el, ha az adott case egyezett. Így előfordulhat olyan eset,
  hogy több case vagy egy case és a default blokkjai végrehajtódnak.
- A default blokkja akkor hajtódik végre, ha egy case sem egyezett vagy ha volt
  ugyan egyezés, de nem használtad a "break;"-et.
- Ha egy case-hez nem adsz meg blokkot (akár zárójellel, akár anélkül), akkor az
  adott case egyezése esetén a következő, legközelebbi blokk hajtódik végre (a
  példában a case 0 és 1 esetén a case 2 blokkja, 4, 5, 6 esetén a case 7 blokkja
  hajtódik végre).

Példa:

  switch (number) {
    case 0 :
    case 1 :
    case 2 : {
      System.out.println("Less than 3.");
      break;
    }
    case 3 : {
      System.out.println("3");
      break;
    }
    case 4 :
    case 5 :
    case 6 :
    case 7 : {
      System.out.println("More than 3.");
    }
    default: {
      System.out.println("Too far from 3.");
    }
  }
