Objectif
Ce TP a pour but de mettre en œuvre les concepts d’injection de dépendances (IoC) en Java à travers :

Une première partie reproduisant les exemples vus en cours/vidéo,

Une deuxième partie consistant à concevoir un mini framework d’injection de dépendances similaire à Spring IoC.

Partie 1 — Reprise du support de cours et vidéo

1 Création de l’interface IDao
2 Implémentation concrète de l’interface
3 Création de l’interface IMetier
4 Implémentation MetierImpl avec injection via interface IDao
5 Injection des dépendances   (   Par instanciation statique  & Par instanciation dynamique (réflexion) Avec le Framework Spring Version XML )


Partie 2 — Mini Framework d’Injection de Dépendances

1 Injection par XML (JAXB + réflexion)
2 Injection par annotations personnalisées
3 Trois types d’injection supportés( Par constructeur : via @InjectByConstructor  & Par setter :XML <property>  & Par champ (Field) : via @InjectByField )


version JAVA : 21
IDE : IntelliJ IDEA
