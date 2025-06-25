# 🎾 Kata - Calculateur de score de tennis

## Objectif

Implémenter en Java une méthode permettant de calculer et d'afficher le score d'une partie de tennis **à partir d'une chaîne de caractères** représentant les points gagnés par chaque joueur.

## Contexte

Le système de score du tennis suit les règles suivantes :

- Une partie se joue point par point (pas de sets ni de jeux multiples ici).
- Chaque joueur commence à **0 point**.
- Les points évoluent comme suit :
  - 1er point gagné → **15**
  - 2ème point gagné → **30**
  - 3ème point gagné → **40**

### Cas standards

- Si un joueur a **40** et gagne le point suivant **sans égalité (deuce)** → il **gagne la partie**.

### Cas d’égalité (deuce)

- Si les **deux joueurs ont 40 points** → situation de **"deuce"**.
- Le joueur qui gagne le point suivant passe à **"avantage"**.
- Si le joueur **ayant l'avantage** gagne le point suivant → il **gagne la partie**.
- Si le joueur **n'ayant pas l'avantage** gagne le point suivant → retour à **"deuce"**.

## Exemple

Pour l’entrée suivante : `"ABABAA"`  
Le programme doit afficher :

```
Player A : 15 / Player B : 0  
Player A : 15 / Player B : 15  
Player A : 30 / Player B : 15  
Player A : 30 / Player B : 30  
Player A : 40 / Player B : 30  
Player A wins the game
```

## Ressource utile

Pour plus de détails sur le système de score du tennis :  
👉 [Règles du tennis sur Wikipedia](http://en.wikipedia.org/wiki/Tennis#Scoring)
