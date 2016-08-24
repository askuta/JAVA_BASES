GIT
===

Tutorial(ok)
------------

Egy rövid (tényleg csak 15 perc), interaktív Git tutorial, érdemes lenne
végigcsinálnod:

  https://try.github.io/levels/1/challenges/1


Git Bash indítása
-----------------

Ha a Git már telepítve van a gépeden, akkor egyszerű:

- Windows keresőjébe beírod, hogy "Git Bash" és futtatod a találatot

vagy

- a Git könyvtárában futtatod a "bin\bash.exe" fájlt (nálam: "D:\Git\bin\bash.exe")

Közös repo letöltése
--------------------

- készítesz egy könyvtárat a közös munkánknak (pl.: "D:\GitRepos\")
- elindítod a "Git Bash"-t
- "Git Bash"-ben belépsz az elkészített könyvtárba:
  $ cd D:\GitRepos
- leszeded a közös repot:
  $ git clone https://github.com/askuta/JAVA_BASES.git

Ha sikerül leszedned, lesz egy új alkönyvtárad ("D:\GitRepos\JAVA_BASES"),
benne a közös tartalommal.


(Nagyon) gyorstalpaló
---------------------

Mi van egy repoban?
~~~~~~~~~~~~~~~~~~~

A legfontosabb, hogy van benne egy ".git" könyvtár. Ez a könyvtár tartalmaz
gyakorlatilag mindent. Benne van az egész Git historija a reponak, amihez
inkább ne nyúlj hozzá. Van benne egy "config" nevű fájl, ami a távoli repon
kívül ("url = ...") más fontos információkat is tartalmaz, ezt néha
szerkesztjük.

A repoban van még egy ".gitignore" nevű fájl, ami leírja, hogy a Git melyik
fájlokat és mappákat hagyja figyelmen kívül. Tehát ha egy fájl vagy mappa
szerepel ebben a fájlban, akkor azt a Git nem fogja követni, így nem tudja
elküldeni a távoli repoba, ami azt jelenti, hogy nem tudod megosztani velem
sem. Miért jó ez? Nagyon jó kérdés, örülök, hogy megkérdezted! Azok a fájlok
és mappák kerülnek ide, amik az adott géptől függenek (pl. a te gépeden lehet,
hogy a repo a "C:\" meghajtón van) vagy generált fájlok mint például a Java
.class, .jar, stb. fájljai.

Az összes többi fájl és könyvtár a repo aktuális állapota. Ha például visszaállsz
egy korábbi állapotra, bizonyos fájlok eltűnnek/megváltoznak/megjelennek.


Fájlok állapota
~~~~~~~~~~~~~~~

Tegyük fel, hogy van egy repod. Abban dolgozol valamit, könyvtárakat és fájlokat
módosítasz. A Git nem fogja automatikusan követni a munkád, nem fog
automatikusan commitokat készíteni és azokat nem fogja feltenni a távoli repoba.
Ha létrehozol egy fájlt a repodban, annak az állapota "Untracked" lesz, ha egy
meglévő fájlt módosítasz, annak az állapota "Modified" lesz. Ha összegyűjtöd a
módosításaidat, hogy egy commitot készíts belőlük, az összegyűjtött változtatások
állapota "Staged" lesz. Ha a commitot végrehajtod, a commitban szereplő
fájlok lezárulnak, az állapotukat "Unmodified" nak tekintjük mindaddig amíg
valaki újból hozzájuk nem nyúl.

Ezt elsőre nem szokták megérteni az emberek. Van egy hasonlat gyöngyökkel, ami
kicsit gagyi, de jól szemlélteti a lényeget és ha nem bánod, szeretném használni
a továbbiakban:

- egy gyöngy = egy commit
- amikor létrehozol egy fájlt (Untracked) vagy módosítasz egy meglévőt (Modified),
  akkor teremted meg a gyöngyhöz szükséges anyagot
- amikor összeszeded a módosításaidat egy commithoz (Staged), akkor gyűjtöd össze
  az anyagot egy commithoz, egy gyöngyhöz (maradhat ki anyag/maradhatnak
  módosítások amik nem kerülnek bele a commitba, de nem feltétlenül maradnak)
- amikor commitálsz, akkor gyúrod meg a gyöngyöt és fűzöd fel egy zsinegre

Egy szép leírás a fájlok állapotáról:

  https://git-scm.com/book/en/v2/Git-Basics-Recording-Changes-to-the-Repository

Commit
~~~~~~

Egy commit (vagy egy gyöngy) módosítások egy halmaza, amiket a commit készítője
valamiért összetartozónak gondolt.

Minden commitnak van:

- SHA1 ID: egy 40 karakterből álló kód/hash, amit a Git generál. Ez a hash
  függ a commit változtatásaitól és az előzményeitől, amit historynak hívunk
  (a gyöngyös hasonlatban a history a zsineg az addigi összes gyönggyel,
  egészen az legelső gyöngyig), így egyértelműen azonosítja a commitot és az
  előzményeit. Ez pl. azért tökjó, mert ha valaki betör a távoli repoba és
  megváltoztatja a tartalmát, azt azonnal észreveszi az első ember, aki a
  lokális és a távoli repo közt megpróbál valamilyen műveletet végrehajtani.
- Parent: az előző commit (az előző gyöngy a zsinegen). A commitok többségének
  egy parentje van, de lehet több is. Továbbá érdemes tudni, hogy a Git csak a
  Parent commito(ka)t tartja számon, a következőket nem.
- Branches: a commit melyik brancheken szerepel (a branchekről a következő
  fejezet szól).

Branch
~~~~~~

A branch ágat, elágazást jelent, ezért sokan úgy képzelik, hogy ha készítenek
egy branchet, akkor a commitok valahogy átrendeződnek, elválnak más branchek
commitjaitól. Ez szemléletmódnak megfelel, de a valóságban a Git nem  teljesen
így működik. A branch maga csak egy címke, amit rátűzünk egy meglévő commitra.
Egy commitra rátűzhetsz több címkét, illetve a címkék eltávolításával nem
feltétlenül szünnek meg a hozzá tartozó commitok létezni.

Mivel egy commit meghatározza a kezdeti committól az adott commitig a
változtatásokat és a branch egy címke az adott commitra, mondhatjuk, hogy a
branch ugyanúgy meghatározza a változtatásokat.

Akkor mi értelme a brancheknek? Kiváló kérdés! Nekem is eszembe jutott anno:
- A commitokat egy 40 karakterből álló hash azonosítja, amit elég nehézkes
  lenne mindig begépelni. Ehelyett használjuk inkább a branchek beszédes neveit
  (használhatjuk a hasheket is, a Git lehetővé teszi).
- Az emberek lusták, igénytelenek, szemetelnek. Ezért a Git időnként
  nagytakarítást végez. A nagytakarítás részeként törli azokat a commitokat
  amik nem tartoznak legalább egy branchez. A branchez tartozás alatt azt értem,
  hogy vagy rajtuk van egy branch címke vagy valamelyik belőlük származó
  commiton.

A következő példában a [branch1]-hez tartoznak az A, B, C, D commitok, a
[branch2]-höz tartoznak az A, E, I, J, K, L commitok. Az F és a G commitok
nem tartoznak egy branchez sem, ezért a Git egy szép napon törölni fogja őket:

  A-B-C-D [branch1]
   \
    E-F-G
     \
      I-J-K-L [branch2]

Amikor létrehozol egy új commitot egy meglévő branchen, a branch (vagyis a
címke) automatikusan átugrik az új commitra.

Merge
~~~~~

A commitok/branchek nem csak szétágazni tudnak, hanem egyesülni is. Ezt a
műveletet hívják MERGE-nek. Amikor Githubon rányomtál a "Merge pull request"
gombra, az egy merge-t hajtott végre a távoli repoban. Nézzünk egy példát:

  A-B-C-F-G [master]
       \
        D-E-H-I-J [my_changes]

Merge után:

  A-B-C-F-G-------K [master]
       \         /
        D-E-H-I-J [my_changes]

Amikre érdemes odafigyelni:
- a merge létrehoz egy új commitot (itt most a K commit)
- az egyik branch (vagyis címke) át fog ugrani az új commitra
- a másik branch marad ahol volt
- az új commit historyjához (és branchez, ami most a [master]) hozzá fog tartozni
  mindkét branch commitjai
