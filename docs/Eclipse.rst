Eclipse
=======

Ingyenes fejleszt�eszk�z Javahoz �s sz�mos m�s nyelvhez. Ingyenes, ennek ellen�re
el�g j�, ez�rt nagyobb c�gek is sz�vesen haszn�lj�k.

Mi�rt haszn�lunk Eclipset vagy m�s IDE-t (Integrated Development Environment)
programoz�shoz? Az�rt, mert megk�nny�ti az �let�nket. Ha nem hiszel nekem, p�r
napig �rj programk�dot Notepad-del �s ford�tsd command line-b�l.

Az Eclipse futtat�s�hoz JRE-t vagy JDK-t kell telep�teni a g�pedre. A JRE futtat�
k�rnyezet, a JDK fejleszt�shez kell, az Eclipse mindkett�vel megy. Az�rt �rdemes
a JDK-t telep�teni, mert ad p�r eszk�zt amit a JRE nem �s a JDK-val l�tni fogod
a Java forr�sk�dj�t az Eclipse-ben.

Let�lt�s
--------

Ingyenesen let�ltheted az Eclipse oldal�r�l:
  https://eclipse.org/downloads

Let�lt�d a neked tetsz� verzi�t (r�gebbi verzi�kn�l ezt v�laszd: "Eclipse IDE for
Java Developers"), ami egy .zip f�jl kellene legyen. Tetsz�leges helyre
kicsomagolod a g�peden �s k�sz. Nem kell semmilyen installert futtatni.

Jelenleg a Neon a leg�jabb verzi�, �ll�t�lag van valami gond vele. �n m�g nem
haszn�ltam. 

Workspace �s Project Location
-----------------------------

A Project Location az a hely, ahol a projekt�nk f�jljait helyezz�k. Az els�
projekt�nkn�l ez a "...\JAVA_BASES\programs\001_JavaBases\" k�nyvt�r.

A Workspace az a hely, ahova az Eclipse pakolja a saj�t f�jljait, amik neki
ugyan kellenek, de a projekt�nk j�l megvan n�lk�l�k. �n k�sz�tettem neki
egy "...\WS\" nev� k�nyvt�rat, amit a GIT nem k�vet, teh�t a "...\JAVA_BASES\"
k�nyvt�ron k�v�l van. Amikor az Eclipse elindul, ezt a "...\WS\" k�nyvt�rat
add meg neki.

�ltal�ban a Project Location a Workspacen bel�l szokott lenni, de nem k�telez�.
�n most �nkn�nyesen k�l�nv�lasztottam �ket.

Eclipse els� ind�t�sa
---------------------

K�tszer r�kattintasz az "eclipse.exe" f�jlra �s m�r indul is. El�sz�r k�ri a
Workspacet, add meg neki amit a "Workspace �s Project Location" fejezetben �rtam.

A legels� indul�s ut�n bej�n a "Welcome" oldal, amit nyugodtan bez�rhatsz. Ha
k�s�bb meg akarod n�zni, akkor "Help" --> "Welcome".

�ll�tsuk be a JDK: Nyisd meg a "Windows" --> "Preferences" oldalt. A bal oldalon
keresd meg a "Java" --> "Installed JREs"-t. Jobbr�l nyomd meg az "Add" gombot.
V�laszd ki a "Standard VM"-et, nyomd le a "Next" gombot. Keresd meg a
"JRE Home"-ot (n�lam: "C:\Program Files\Java\jdk1.8.0_91") �s nyomd le a "Finish"
gombot. Kattintsd be a JDK sor�t �s nyomj "OK"-t. Mostant�l az �sszes projekt ami
ehhez a Workspacehez tartozik, alap�rtelmezetten a JDK-t kellene hogy haszn�lja.
Az�rt nem �rt ellen�rizni. :)

Projekt l�trehoz�sa
-------------------

Mivel elfelejtettem hozz�adni a GIT-hez a 001_JavaBases projekt ".project"
f�jlj�t, nem fogod tudni import�lni. Node sebaj! K�sz�ts r� egy projektet,
mintha nem is l�tezne:

- "File" --> "New" --> "Java Project"
- t�vol�tsd el a pip�t a "Use default location"-r�l
- keresd meg a projekt hely�t "...\JAVA_BASES\programs\001_JavaBases\
- elvileg mag�t�l ki fogja t�lteni a "Project name"-t
- "JRE"-nek �ll�tsd be a "Use default JRE (currently 'jdk1.8.0_91')"-t
  (val�sz�n��eg n�lad m�s lesz a verzi�sz�m)
- "Finish"

Ha m�r itt vagy, hozz�adhatn�d GIT-hez a ".project" f�jlt. :)

Projekt import�l�sa
-------------------

Ha nem felejtettem volna el hozz�adni a ".project" f�jlt, akkor ezt kellene
csin�lnod:
- "File" --> "Import"
- "General" --> "Existing project into Workspace"
- "Select root directory:"-nak �ll�tsd be a Project Location-t
  ("...\JAVA_BASES\programs\001_JavaBases")
- miut�n becsekkoltad a projekt checkbox-sz�t, "Finish"

Program futtat�sa Eclipse-ben
-----------------------------

- a baloldalon megkeresed a futtatand� projektet ("001_JavaBases")
- ha kell, addig nyitogatod sz�t, am�g megtal�lod a "HelloWorld.java" f�jlt
  (az�rt pont ezt, mert ebben van a "main" mat�dus, ami a Java programok
  ind�t�si pontja)
- r�kattintasz jobb gombbal
- "Run As" --> "Java Application"
- ha erre r�kattintasz, akkoe el kellene indulni a programnak �s ki kellene
  �rnia, hogy "Hello World!"

Az Eclipse �rz�kelni fogja, ha m�g nem volt leford�tva a projekt vagy
megv�ltozott a legutols� ford�t�s �ta �s �jra ford�tja ind�t�s el�tt.
