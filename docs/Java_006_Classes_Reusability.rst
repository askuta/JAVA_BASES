Osztályok
=========

Az előző részben foglalkoztunk az objektumorientált programozás első alapelvével,
az egységbezárással (encapsulation). Nagyjából arról volt szó, hogy az
összetartozó adatokat és a rajtuk végezhető műveleteket egy egységbe, egy
osztályba zárjuk, ami nagyban leegyszerűsíti az adatszerkezeteinket és azok
használatát, karbantartását.

Most a második alapelvvel foglalkozunk, ami az újrafelhasználhatóság
(reusability).

A harmadik alapelv a többalakúság (polimorfizmus) lesz.

Újrafelhasználhatóság - Reusability
-----------------------------------

Két részre bontanám az újrafelhasználhatóságot. Az első eset az, amikor egy
osztályt egyszer leimplementálunk mi vagy valaki más és abból több példányt
készítünk. Ez érthetően felgyorsítja a programunk fejlesztésének az idejét,
különösen ha valaki más készítette el az adott osztályt és mi csak felhasználjuk.
Azt sem szabad elhanyagolni, hogy ilyenkor talán több ezer másik programozó
használja, egyúttal teszteli az adott osztályt, ami azért elég jó garancia arra,
hogy jól fog működni. Példaként ott van az egész Java programozási nyelv összes
osztálya amiket nálunk sokkal okosabb emberek implementáltak le, nekünk csak
használni kell őket. Valószínűleg kihullana a maradék hajam, ha pl. minden egyes
fájlműveletet nekem kellene újra és újra végiggondolni és elkészíteni.

A második eset, amikor egy meglévő osztály funkcionalitását bővítjük ki, egyúttal
specializáljuk. Ezt hívjuk öröklődésnek és a következő fejezetben írok róla
részletesebben.

Öröklődés - Inheritance
-----------------------

Tegyük fel, hogy van egy kész Person osztályom, ami emberek dolgaival foglalkozik.
Szeretnék két új osztályt: Man és Woman. A Man egyben Person is, ez egyértelmű.
Fogadjuk el, hogy a Woman is Person. Tehát azt szeretnénk, ha a Man és a Woman
mindent tudna amit a Person, plusz még egyéd dolgokat is. Megtehetnénk, hogy
a Person összes kódját belemásoljuk a Man-be és a Woman-be. Ekkor a közös kód 3
helyen szerepelne, ami nem lenne túl szerencsés. A programozók nem szeretik a
kódismétlést, mert ha később meg kell változtatni, akkor mind a 3 helyen meg kell
változtatni és legalább egyiket el fogod felejteni. Persze, most fogadkozol, hogy
Te aztán nem fogod, pedig de.

Mit lehet ilyenkor csinálni? Leszármaztatjuk a Man és a Woman osztályokat a Person
osztályból. Ezt nagyjából úgy képzeld el, mintha a Person kódját logikailag
bemásolnád a Man és a Woman osztályokba, de fizikailag mégis külön lenne. Egyedül
a láthatósággal lehet játszadozni, az ősosztály private adattagjai és metódusai
nem látszódnak az ősosztályon kívűlről, illetve a package private adattagok és
metódusok nem látszódnak az ősosztály package-én kívülről (nézd meg a
"006_Classes_02" projekt "com.java.inheritance01" package-ét).

Nézzük meg, hogy néz ki mindez megvalósítva (BaseClass és DerivedClass nevekkel):

  public class BaseClass {
      protected String stringField;

      public BaseClass(String stringField) {
          this.stringField = stringField;
      }
  }

A leszármaztatott osztályt kiegészítjük az "extends" szóval és az osztály nevével
amiből szeretnénk leszármaztatni:

  public class DerivedClass extends BaseClass {
  
      DerivedClass(String stringField) {
          super(stringField);
      }
  
      public void printStringField() {
          System.out.println(stringField);
      }
  }

Ha egyértelmű, akkor a leszármaztatott osztályban simán hivatkozhatunk az
ősosztály adattagjaira és metódusaira. Az ősosztály konstruktorára a
következőképpen hivatkozhatunk:

  super(param1, param2, ...);

A leszármaztatott osztályban a "super" kulcsszóval hivatkozhatunk az ősosztály
adattagjaira és metódusaira akkor, ha esetleg névütközés van:

  super.stringField;

Metódus felülírása
------------------

Előfordulhat, hogy az ősosztályban implementált metódus(ok) valamiért nem felelnek
meg a leszármaztatott osztályodnak. Ilyenkor sem kell kétségbeesni, a
leszármaztatott osztályban felülírhatod az ősosztály metódusát. Használhatod az
"@Override" annotációt, hogy felhívd a magad és a programozótársaid figyelmét a
felülírásra, de nem kötelező. Az Eclipse általában megteszi helyetted.

  public class BaseClass {

      public void doSomething() { ... }
  }

  public class DerivedClass extends BaseClass {

      @Override
      public void doSomething() { ... }
  }

  DerivedClass derived = new DerivedClass();
  derived.doSomething(); // Calls the doSomething method of the derived class

Az öröklődés (néhány) szabályai
-------------------------------

- A Java programozási nyelvben minden osztály az Object nevű osztályból származik.
- A Java csak egyszeres öröklődést enged (ellentétben a C++ -szal):
  Az előző ponttal együtt ez azt jelenti, hogy az Object-en kívül minden
  osztálynak pontosan egy ősosztálya van. Természetesen leszármaztathatsz egy
  leszármaztatott osztályból és abból is leszármaztathatsz, stb.
- A Java compiler készít default konstruktort a leszármaztatott osztályhoz (ha mi
  nem készítünk), ami az ősosztály default konstruktorát fogja meghívni első
  lépésben.
- Ha a láthatóság engedi, akkor a leszármaztatott osztályok hivatkozhatnak az
  ősosztályok adattagjaira és metódusaira.
