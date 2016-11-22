Osztályok
=========

Egységbezárás - Encapsulation
-----------------------------

Eddig viszonylag kevés adattal kellett dolgoznunk, de ahogy az adatok mennyisége
egyre nő és a feladataink egyre komplexebbé válnak, szükségünk lesz valamilyen
struktúra kialakítására. Szeretnénk az összetartozó adatokat egy egységként
kezelni, illetve az adatokon végezhető műveleteket is szeretnénk ennek az
egységnek a részeként kezelni.

A Java nyelv erre az osztályokat és az objektumokat, más kifejezéssel osztály
példányokat ajánlja nekünk. Az osztály valós vagy képzelt dolgok absztrakciója,
a "dolognak" csak a számunkra fontos tulajdonságait és viselkedését írja le.
Úgy képzeld el mint egy "dolog" leegyszerűsített tervrajzát. Amikor a tervrajz
alapján elkészítjük a "dolog" leegyszerűsített modelljét, azt nevezzük
objektumnak vagy példánynak.

Miért jó nekünk az egységbezárás? Gondolj arra, hogy milyen nehéz lenne, ha pl.
egy diák összes adatát, beleértve a személyes és tanulmányi adatait is külön
tömbölkben kellene tárolni! Akkor most képzeld el ugyanezt 10.000 diákkal, add
hozzá a tanárokat, az osztálytermeket, stb. Ha mindenhez készítünk osztályokat,
utána nem egy borzalmas adatmasszán kell dolgoznod, hanem diák, tanár, stb.
objektumokon, amiknek nem feltétlenül kell érteni a részleteit/működését (mert
pl. valaki más írta az osztályt), elég ha a használatukat érted.

Osztály
-------

Osztályt a következő módon tudsz létrehozni:

  public class ClassName {
  }

Egy osztály csak akkor lehet "public", ha a neve megegyezik a .java fájl nevével.
Tehát a fenti osztálynak a "ClassName.java" fájlban kell lennie. Egy .java fájlban
leírhatsz több osztályt is, de csak egyikük lehet public.

Lehetőség van egy osztályon belül is létrehozni másik osztály(oka)t, de arról
majd később beszélünk.

Adattagok
---------

Az osztály adattagjai meglepő módon adatokat tárolnak, amik leírják az objektumok
pillanatnyi állapotát. Általában elrejtjük az adattagokat, így csak a metódusokon
keresztül lehet megváltoztatni az értéküket (vagyis az objektumok állapotát). Ha
nem állítasz be egy adattagot az objektum elkészültekor, kap default értéket. Ez
a default érték:
  - 0 vagy 0.0: primitív típus esetén (kivéve boolean)
  - false: boolean típus esetén
  - null: nem primitív típus esetén (ha osztályra/objektumra hivatkozol)

Példa néhány adattagra a ClassName osztályon belül:

  public class ClassName {
    private int number; // default értéke: 0
    boolean logicalThing; // default értéke: false
    protected byte[] someData; // default értéke: null (tehát nem egy tömb, ami tele van nullákkal)
    public final String name = "Borond Odon"; // default értéke: "Borond Odon"
  }

Láthatsz néhány új kulcsszót az adattagok előtt:
  - private: az adattagra csak az adott osztályon belül hivatkozhatsz
  - "nincs kulcsszó": az adattagra csak az adott package-n belül hivatkozhatsz
  - protected: az adattagra csak az adott package-n belül hivatkozhatsz + a
    leszármazott osztályokban
  - public: bárhonnét hivatkozhatsz az adattagra
  - final: az adattag konstans, példányosításkor be kell állítani és később nem
    lehet megváltoztatni (nem primitív típus esetén kicsit trükkös, mert igaz,
    hogy nem tudsz másik objektumra hivatkozni, de a hivatkozott objektumot magát
    meg tudod változtatni)

Metódusok
---------

A metódusok írják le az osztályhoz tartozó objektumok viselkedését és teszik
lehetővé, hogy megváltoztassuk az objektumok állapotát (mivel magukat az
adattagokat igyekszünk elrejteni).

Példa egy metódusra:

  public String readFileAsString(String fileName, int startPosition) throws IOException {
    //...
	return fileContent;
  }

- public: láthatóság, lehet még private, "nem definiált" és protected (hasonló
  az adattagokhoz)
- Sting: visszatérési érték, lehet bármilyen típus vagy "void" ha nem adunk vissza
  semmit
- readFileAsString: a metódus neve
- "String fileName, int startPosition": a metódus paraméterei vagy üres
- throws IOException: Exception-ök, amiket nem kezelünk le a metóduson belül

Getterek, setterek
------------------

Vannak olyan metódusok, amik rendkívül buták, nem csinálnak semmit azon kívül,
hogy beállítják vagy visszaadják egy adattag értékét:

  private int weight;

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

A setternél láthatod a "this" kulcsszót, ami hivatkozás az adott objektumra.
Azért használjuk, mert a setter paramétere és az adattag neve is "weight" és
a setterben a paraméter elfedi az adattagot a névütközés miatt. A következő
kód nem változtatná meg az adattagot, hanem a paraméter weight változót
állítaná be a saját értékére, aminek nem lenne sok haszna:

  public void setWeight(int weight) {
    weight = weight;
  }

Igen, jól látod, a setterek és getterek neveit úgy képezzük, hogy

  get + [ADATTAG NEVE]
  set + [ADATTAG NEVE]

boolean értékek esetében a "get" helyett szokás az "is" vagy "has" szavakat
használni:

  private boolean bald;

  public boolean isBald() {
    return bald;
  }

Konstruktor
-----------

Ahhoz, hogy megfelelően inicializáljunk egy objektumot (elkerüljük az objektum
inkonzisztens állapotát), konstruktort használunk.

Fentebb írtam, hogy az adattagok kapnak default értéket. Ha neked ez megfelel,
akkor a Java készít egy úgynevezett default konstruktort. Ennek a konstruktornak
nincsenek paraméterei és te sosem fogod látni, hacsak nem tanulod meg a bájtkódot
olvasni (a fordító a .java fájlokat bájtkódra fordítja, majd futtatáskor a
bájtkódot értelmezi, optimalizálja és hajtja végre). Ha látnád, akkor valahogy
így nézne ki:

  public class MyClass {
  
    public MyClass() {
    }
  }

És már készíthetünk is egy példányt az osztályból:

  MyClass obj = new MyClass();

Ha nem felel meg a default konstruktor, akkor lehetőség van saját konstruktor
létrehozására. Fontos, hogy ilyenkor a Java fordító nem fog default konstruktort
generálni! Ha szükséged van rá, akkor azt magadnak kell elkészíteni:

  public class MyClass {

    private String name;

    public MyClass() { // default konstruktor, csak ha szükséged van rá
    }

    public MyClass(String name) {
      this.name = name;
    }
  }

Ha akarsz, te is készíthetsz default konstruktort. Ennek általában nincs
jelentősége, hacsak nem változtatod meg a konstruktor láthatóságát.

  public class MyClass {
  
    protected MyClass() {
    }
  }