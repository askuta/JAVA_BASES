Eclipse
=======

Ingyenes fejlesztõeszköz Javahoz és számos más nyelvhez. Ingyenes, ennek ellenére
elég jó, ezért nagyobb cégek is szívesen használják.

Miért használunk Eclipset vagy más IDE-t (Integrated Development Environment)
programozáshoz? Azért, mert megkönnyíti az életünket. Ha nem hiszel nekem, pár
napig írj programkódot Notepad-del és fordítsd command line-ból.

Az Eclipse futtatásához JRE-t vagy JDK-t kell telepíteni a gépedre. A JRE futtató
környezet, a JDK fejlesztéshez kell, az Eclipse mindkettõvel megy. Azért érdemes
a JDK-t telepíteni, mert ad pár eszközt amit a JRE nem és a JDK-val látni fogod
a Java forráskódját az Eclipse-ben.

Letöltés
--------

Ingyenesen letöltheted az Eclipse oldaláról:
  https://eclipse.org/downloads

Letöltöd a neked tetszõ verziót (régebbi verzióknál ezt válaszd: "Eclipse IDE for
Java Developers"), ami egy .zip fájl kellene legyen. Tetszõleges helyre
kicsomagolod a gépeden és kész. Nem kell semmilyen installert futtatni.

Jelenleg a Neon a legújabb verzió, állítólag van valami gond vele. Én még nem
használtam.

Workspace és Project Location
-----------------------------

A Project Location az a hely, ahol a projektünk fájljait helyezzük. Az elsõ
projektünknél ez a "...\JAVA_BASES\programs\001_JavaBases\" könyvtár.

A Workspace az a hely, ahova az Eclipse pakolja a saját fájljait, amik neki
ugyan kellenek, de a projektünk jól megvan nélkülük. Én készítettem neki
egy "...\WS\" nevû könyvtárat, amit a GIT nem követ, tehát a "...\JAVA_BASES\"
könyvtáron kívül van. Amikor az Eclipse elindul, ezt a "...\WS\" könyvtárat
add meg neki.

Általában a Project Location a Workspacen belül szokott lenni, de nem kötelezõ.
Én most önknényesen különválasztottam õket.

Eclipse elsõ indítása
---------------------

Kétszer rákattintasz az "eclipse.exe" fájlra és már indul is. Elõször kéri a
Workspacet, add meg neki amit a "Workspace és Project Location" fejezetben írtam.

A legelsõ indulás után bejön a "Welcome" oldal, amit nyugodtan bezárhatsz. Ha
késõbb meg akarod nézni, akkor "Help" --> "Welcome".

Állítsuk be a JDK: Nyisd meg a "Windows" --> "Preferences" oldalt. A bal oldalon
keresd meg a "Java" --> "Installed JREs"-t. Jobbról nyomd meg az "Add" gombot.
Válaszd ki a "Standard VM"-et, nyomd le a "Next" gombot. Keresd meg a
"JRE Home"-ot (nálam: "C:\Program Files\Java\jdk1.8.0_91") és nyomd le a "Finish"
gombot. Kattintsd be a JDK sorát és nyomj "OK"-t. Mostantól az összes projekt ami
ehhez a Workspacehez tartozik, alapértelmezetten a JDK-t kellene hogy használja.
Azért nem árt ellenõrizni. :)

Projekt létrehozása
-------------------

A következo feladatokhoz így készíts projektet:

- "File" --> "New" --> "Java Project"
- adj meg egy szép projektnevet, mint pl. "001_JavaBases" (ha még nincs ilyen)
- távolítsd el a pipát a "Use default location"-rõl (ez csak azért kell, mert
  nekünk külön van a workspace)
- keresd meg a projekt helyét GIT alatt "...\JAVA_BASES\programs\"
- "JRE"-nek állítsd be a "Use default JRE (currently 'jdk1.8.0_91')"-t
  (valószínűleg nálad más lesz a verziószám)
- "Finish"

Projekt importálása
-------------------

Ezt kellene csinálnod azokkal a projektekkel, amiket én tettem fel GIT-be:

- "File" --> "Import"
- "General" --> "Existing project into Workspace"
- "Select root directory:"-nak állítsd be a Project Location-t
  ("...\JAVA_BASES\programs\001_JavaBases")
- miután becsekkoltad a projekt checkbox-szát, "Finish"

Program futtatása Eclipse-ben
-----------------------------

- a baloldalon megkeresed a futtatandó projektet ("001_JavaBases")
- ha kell, addig nyitogatod szét, amíg megtalálod a "HelloWorld.java" fájlt
  (azért pont ezt, mert ebben van a "main" matódus, ami a Java programok
  indítási pontja)
- rákattintasz jobb gombbal
- "Run As" --> "Java Application"
- ha erre rákattintasz, akkoe el kellene indulni a programnak és ki kellene
  írnia, hogy "Hello World!"

Az Eclipse érzékelni fogja, ha még nem volt lefordítva a projekt vagy
megváltozott a legutolsó fordítás óta és újra fordítja indítás elõtt.
