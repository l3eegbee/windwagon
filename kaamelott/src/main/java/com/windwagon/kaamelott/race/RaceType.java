package com.windwagon.kaamelott.race;

public enum RaceType {

    /**
     * Course internationale.
     */
    INTERNATIONALE,

    /**
     * Course européenne.
     */
    EUROPEENNE,

    /**
     * Course nationale.
     */
    NATIONALE,

    /**
     * Course de groupe I.
     */
    GROUPE_I,

    /**
     * Course de groupe II.
     */
    GROUPE_II,

    /**
     * Course de groupe III.
     */
    GROUPE_III,

    /**
     * Course classique.
     */
    CLASSIQUE,

    /**
     * Course semi-classique.
     */
    SEMI_CLASSIQUE,

    /**
     * Départ à l'autostart.
     */
    AUTOSTART,

    /**
     * Course à handicap.
     *
     * @see RaceType#CATEGORIE
     * @see RaceType#DEDOUBLE
     * @see RaceType#DIVISE
     * @see RaceType#LIMITE
     * @see RaceType#REQUALIFICATION
     */
    HANDICAP,

    /**
     * Course à réclamer.
     *
     * @see RaceType#MIXTE
     */
    RECLAMER,

    /**
     * Course à handicap de catégorie. Obligatoirement associé avec {@link RaceType#HANDICAP}.
     *
     * @see RaceType#HANDICAP
     */
    CATEGORIE,

    /**
     * Course à handicap dédoublé. Obligatoirement associé avec {@link RaceType#HANDICAP}.
     *
     * @see RaceType#HANDICAP
     */
    DEDOUBLE,

    /**
     * Course à handicap divisé. Obligatoirement associé avec {@link RaceType#HANDICAP}.
     *
     * @see RaceType#HANDICAP
     */
    DIVISE,

    /**
     * Course à handicap limité. Obligatoirement associé avec {@link RaceType#HANDICAP}.
     *
     * @see RaceType#HANDICAP
     */
    LIMITE,

    /**
     * Course à handicap de requalification. Obligatoirement associé avec {@link RaceType#HANDICAP}.
     *
     * @see RaceType#HANDICAP
     */
    REQUALIFICATION,

    /**
     * Course à conditions.
     *
     * @see RaceType#QUALIF_HP
     */
    CONDITIONS,

    /**
     * Course à conditions "qualif HP". Obligatoirement associé avec {@link RaceType#CONDITIONS}.
     *
     * @see RaceType#CONDITIONS
     */
    QUALIF_HP,

    /**
     * Course mixte. Signifie qu'une partie seulement des chevaux sont à
     * réclamer. Obligatoirement associé avec {@link RaceType#RECLAMER}.
     *
     * @see RaceType#RECLAMER
     */
    MIXTE,

    /**
     * Course amateur.
     *
     * @see RaceType#PROPRIETAIRES
     * @see RaceType#DAMES
     */
    AMATEURS,

    /**
     * Course amateur avec priorité aux propriétaires. Obligatoirement associé
     * avec {@link RaceType#AMATEURS}.
     *
     * @see RaceType#AMATEURS
     */
    PROPRIETAIRES,

    /**
     * Course amateurs réservé aux dames. Obligatoirement associé avec {@link RaceType#AMATEURS}.
     *
     * @see RaceType#AMATEURS
     */
    DAMES,

    /**
     * Course réservée aux apprentis. Par défaut, apprentis lad-driver, sauf en
     * présence de {@link RaceType#LADS_JOCKEYS}.
     *
     * @see RaceType#LADS_JOCKEYS
     */
    APPRENTIS,

    /**
     * Course réservée aux apprentis lads-jockey. Obligatoirement associé avec
     * {@link RaceType#APPRENTIS}.
     *
     * @see RaceType#APPRENTIS
     */
    LADS_JOCKEYS,

    /**
     * Courses en partie liée. Définition:
     * "Course dont le résultat ne devient définitif qu'après plusieurs épreuves"
     * .
     */
    LIEE,

    /**
     * Course réservée à la race anglo-arabe.
     *
     * @see RaceType#PREMIERE_SERIE
     * @see RaceType#DEUXIEME_SERIE
     * @see RaceType#TROISIEME_SERIE
     */
    ANGLO_ARABES,

    /**
     * Course d'anglo-arabes de première série. Obligatoirement associé avec
     * {@link RaceType#ANGLO_ARABES}.
     *
     * @see RaceType#ANGLO_ARABES
     */
    PREMIERE_SERIE,

    /**
     * Course d'anglo-arabes de deuxième série. Obligatoirement associé avec
     * {@link RaceType#ANGLO_ARABES}.
     *
     * @see RaceType#ANGLO_ARABES
     */
    DEUXIEME_SERIE,

    /**
     * Course d'anglo-arabes de troisième série. Obligatoirement associé avec
     * {@link RaceType#ANGLO_ARABES}.
     *
     * @see RaceType#ANGLO_ARABES
     */
    TROISIEME_SERIE,

    /**
     * Course réservée à la race arabe pure.
     */
    ARABES_PURS,

    /**
     * Course à ventes publiques.
     */
    VENTES_PUBLIQUES,

    /**
     * Course réservée aux AQPS. AQPS: Autre Que de Pur-Sang anglais.
     */
    AQPS,

    /**
     * Course de chevaux militaires.
     */
    MILITAIRES,

    /**
     * Course courues par des chevaux civils et militaires.
     */
    CIVILS_ET_MILITAIRES,

    /**
     * Course de concours.
     */
    CONCOURS,

    /**
     * Course de démonstration.
     */
    DEMONSTRATION,

    /**
     * Course de qualification ACCAF.
     */
    QUALIFICATION_ACCAF,

    /**
     * Finale régionale ACCAF.
     */
    FINALE_REG_ACCAF,

    /**
     * Finale nationale ACCAF.
     */
    FINALE_NAT_ACCAF,

    /**
     * Type de course inconnu.
     */
    INCONNU;

}
