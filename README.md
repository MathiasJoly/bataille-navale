
Projet Bataille Navale de Mathias Joly
==
Les classes que j'utilise sont stockées dans src/main/java/personal.

Exercice 1
-
TestBoard teste les deux constructeurs de Board et la méthode print (la taille maximale d'une grille étant de 26 pour les 26 lettres de l'alphabet).
L'encapsulation (les getter et setter) a bien été effectuée.

Exercice 2
-
On crée un enum Orientation pour définir les valeurs NORTH, SOUTH, EAST, WEST.
On met les fichiers reliés entre eux dans un package à part.

Exercice 3
-
Les indices commencent à 0, ainsi C4 est d'abscisse 2 et d'ordonnée 3.
Au départ j'utilisais un tableau pour représenter la grille,
ainsi le point C4 etait stocké à l'indice 2 + 3*(taille ligne),
mais je me suis rendu compte que je pouvais tout simplement utiliser une matrice.
Je ne maitrisais pas le fonctionnement des matrices,
au début je pensais qu'il fallait faire matrice[abscisse][ordonnée],
mais je me suis rendu compte qu'il fallait en fait faire matrice[ordonnée][abscisse].
<br/>
<br/>
Je pensais tout d'abord que la taille des lignes de la grille devait être un attribut de la classe Board.
Mais en passant d'un tableau à une matrice, je me suis apeçu qu'on pouvait retrouver cette taille en faisant navires.length.
<br/>
<br/>
Si un bateau sort de la grille, son placement doit etre interdit.
Ainsi la fonction putShip vérifie avant le placement si tout le bateau reste bien dans la grille.
Si un bateau va chevaucher un autre bateau, son placement doit etre interdit.
Ainsi la fonction putShip vérifie avant le placement que le bateau n'a pas d'encombre.
<br/>
<br/>
TestBoard vérifie que le placement des bateaux s'affiche bien sur la grille quand les coordonnées sont bonnes,
et que le placement est bien empêché si les coordonnées sont mauvaises.

Exercice 4
-
Pour traiter les exceptions : "le bateau sort de la grille" et "un autre bateau fait obstacle",
j'ai d'abord pensé qu'il fallait créer de nouvelles classes d'Exception, 
mais je me suis ensuite rendu compte que je pouvait simplement utiliser la classe Exception en changeant le message d'erreur.
(Ne pas prendre en compte le package exceptions)
<br/>
<br/>
Si l'un de ses cas arrive, on lève une exception et on demande au joueur de replacer son bateau.
Ainsi si le placement n'a pas réussi, le compteur du nombre de bateaux placés n'augmente pas.
<br/>
<br/>
TestBoard vérifie que le joueur peut bien placer ses 5 bateaux.

Exercice 5
-
Pour la grille des frappes, 
on utilise des Boolean pour avoir trois valeurs :
null (une frappe n'a pas encore eu lieu),
false (une frappe ratée) et true (une frappe réussie).
<br/>
<br/>
On utilise ShipState pour calculer le nombre de frappes reçu par un bateau,
si ce nombre devient égal à la taille du bateau alors le bateau coule.
<br/>
<br/>
Avec ShipState j'ai été confronté à l'erreur java.lang.NullPointerException.
J'ai fini par comprendre qu'il fallait vérifier que ShipState n'était pas vide avant de lui appliquer une méthode.
<br/>
<br/>
J'utilise Eclipse donc j'ai utilisé le plugin ANSI Escape in Console.
J'ai mis un peu de temps à comprendre son fonctionnement.
<br/>
<br/>
La méthode addStrike verifie que le ShipState n'a pas déja été frappé.
Ainsi on n'entre pas dans un état illégal.

Exercice 6
-
Pour que sendHit renvoie à la fois le résultat de la frappe et ses coordonnées,
on crée un tableau de coordonnées avant et on modifie ce tableau dans sendHit.
<br/>
<br/>
Si on appelle sendHit sur deux fois sur la même position,
la deuxième fois la frappe est interdite,
on demande au joueur de cibler une autre position.
<br/>
<br/>
TestBoard vérifie le fonctionnement de la méthode isSunk (le joueur doit frapper aux endroits notés en commentaire).
TestBoard vérifie que la methode hasShip sur une position de navire coulé renvoie faux.

Exercice 7
-
J'ai utilisé un tableau de AbstractShip plutôt qu'une ArrayList,
car j'ai suivi le type défini dans l'entête de putShips dans BattleShipsAI. 
<br/>
<br/>
TestGame fait jouer l'IA contre elle-même.

Exercice 8
-
setHit se fait directement dans sendHit : quand un joueur fait une frappe, elle est directement reçue par son adversaire.
<br/>
<br/>
Game permet de jouer contre une IA

Bonus 1
-
Game permet de jouer contre une IA ou en multijoueur.
<br/>
On choisit le mode au début :
il faut répondre true ou false, à la question "Voulez vous jouer en mode multijoueur ?"

Bonus 2
-
Non traité


