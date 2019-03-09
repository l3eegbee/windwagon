package com.windwagon.broceliande.race.entities;

import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumRaceTypeValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumValue;

/**
 * Race type.
 *
 * <style>
 *
 * .table-header-rotated th.row-header { width: auto; text-align: right; }
 *
 * .table-header-rotated td { width: 10px; border-top: 1px solid #dddddd;
 * border-left: 1px solid #dddddd; border-right: 1px solid #dddddd;
 * vertical-align: middle; text-align: center; }
 *
 * .table-header-rotated th.rotate-90 { height: 230px; width: 10px; position:
 * relative; vertical-align: bottom; padding: 0; font-size: 12px; line-height:
 * 0.8; }
 *
 * .table-header-rotated th.rotate-90 > div { position: relative; top: 0px;
 * left: 0px; height: 100%; overflow: hidden; border-left: 1px solid #dddddd;
 * border-right: 1px solid #dddddd; border-top: 1px solid #dddddd; }
 *
 * .table-header-rotated th.rotate-90 span { -ms-transform:rotate(-90deg);
 * -moz-transform:rotate(-90deg); -webkit-transform:rotate(-90deg);
 * -o-transform:rotate(-90deg); transform:rotate(-90deg); position: absolute;
 * bottom: 105px; left: -100px; display: inline-block; width: 220px; text-align:
 * left; }
 *
 * .table-header-rotated th.bottom span { text-align: right; }
 *
 * .table-header-rotated th.center span { text-align: center; }
 *
 * </style>
 *
 * PMU / Enum equivalence
 *
 * <div>
 * <table class="table-header-rotated" style="width: auto;">
 *
 * <thead>
 * <tr>
 * <th></th>
 * <th class="rotate-90"><div><span>{@link Type#INTERNATIONALE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#EUROPEENNE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#NATIONALE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#GROUPE_I}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#GROUPE_II}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#GROUPE_III}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#CLASSIQUE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#SEMI_CLASSIQUE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#AUTOSTART}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#HANDICAP}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#RECLAMER}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#CATEGORIE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#DEDOUBLE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#DIVISE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#LIMITE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#REQUALIFICATION}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#CONDITIONS}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#QUALIF_HP}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#MIXTE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#AMATEURS}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#PROPRIETAIRES}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#DAMES}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#APPRENTIS}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#LADS_JOCKEYS}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#LIEE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#ANGLO_ARABES}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#PREMIERE_SERIE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#DEUXIEME_SERIE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#TROISIEME_SERIE}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#ARABES_PURS}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#VENTES_PUBLIQUES}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#AQPS}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#MILITAIRES}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#CIVILS_ET_MILITAIRES} </span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#CONCOURS}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#DEMONSTRATION}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#QUALIFICATION_ACCAF} </span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#FINALE_REG_ACCAF}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#FINALE_NAT_ACCAF}</span></div></th>
 * <th class="rotate-90"><div><span>{@link Type#INCONNU}</span></div></th>
 * </tr>
 * </thead>
 *
 * <tbody>
 *
 * <tr>
 * <th class="row-header">{@code ANGLO_ARABES}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td>X</td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code ANGLO_ARABES_1ERE_SERIE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td>X</td> <!-- ANGLO_ARABES -->
 * <td>X</td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code ANGLO_ARABES_2EME_SERIE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td>X</td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td>X</td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code ANGLO_ARABES_3EME_SERIE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td>X</td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td>X</td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code ANGLO_ARABES_INTER}</th>
 * <td>X</td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td>X</td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code ARABES_PURS}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td>X</td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code ETALONS_VENTES_PUBLIQUES}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td>X</td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code VENTES_PUBLIQUES}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td>X</td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code ETALONS_VENTES_PUB_HAND}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td>X</td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td>X</td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AUTRES_QUE_PUR_SANG_ANGL}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td>X</td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code A_RECLAMER}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code MIXTE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td>X</td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code HANDICAP}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td>X</td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code HANDICAP_A_RECLAMER}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td>X</td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code HANDICAP_DE_CATEGORIE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td>X</td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td>X</td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code HANDICAP_DEDOUBLE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td>X</td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td>X</td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code HANDICAP_DIVISE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td>X</td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td>X</td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code HANDICAP_CATEGORIE_DEDOUBLE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td>X</td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td>X</td> <!-- CATEGORIE -->
 * <td>X</td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code HANDICAP_CATEGORIE_DIVISE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td>X</td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td>X</td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td>X</td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code HANDICAP_LIMITE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td>X</td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td>X</td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code HANDICAP_INTERNATIONAL}</th>
 * <td>X</td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td>X</td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code HANDICAP_DE_CATEGORIE_A_RECLAMER}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td>X</td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td>X</td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code COURSE_A_CONDITIONS}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td>X</td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code COURSE_A_CONDITION_QUALIF_HP}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td>X</td> <!-- CONDITIONS -->
 * <td>X</td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code COURSE_INTERNATIONALE}</th>
 * <td>X</td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code COURSE_MILITAIRE_INTER}</th>
 * <td>X</td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td>X</td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code GROUPE_III}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td>X</td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code GROUPE_II}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td>X</td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code GROUPE_I}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td>X</td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code CHEVAUX_MILITAIRES}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td>X</td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code CHEVAUX_CIVILS_ET_MILITAIRES}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td>X</td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code CHEVAUX_DE_CONCOURS}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td>X</td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code COURSE_DE_DEMONSTRATION}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td>X</td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code QUALIFICATION_ACCAF}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td>X</td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code FINALE_REGIONALE_ACCAF}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td>X</td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code FINALE_NATIONALE_ACCAF}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td>X</td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code NATIONALE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td>X</td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code NATIONALE_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td>X</td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code NATIONALE_SEMI_CLASSIQUE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td>X</td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td>X</td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code NATIONALE_SEMI_CLASSIQUE_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td>X</td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td>X</td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code NATIONALE_CLASSIQUE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td>X</td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td>X</td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code NATIONALE_CLASSIQUE_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td>X</td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td>X</td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <thead>
 * <tr>
 * <th></th>
 * <th class="rotate-90 center"><div><span>{@link Type#INTERNATIONALE} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#EUROPEENNE}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#NATIONALE}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#GROUPE_I}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#GROUPE_II}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#GROUPE_III}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#CLASSIQUE}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#SEMI_CLASSIQUE} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#AUTOSTART}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#HANDICAP}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#RECLAMER}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#CATEGORIE}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#DEDOUBLE}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#DIVISE}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#LIMITE}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#REQUALIFICATION} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#CONDITIONS}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#QUALIF_HP}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#MIXTE}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#AMATEURS}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#PROPRIETAIRES} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#DAMES}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#APPRENTIS}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#LADS_JOCKEYS} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#LIEE}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#ANGLO_ARABES} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#PREMIERE_SERIE} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#DEUXIEME_SERIE} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#TROISIEME_SERIE} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#ARABES_PURS}</span></div>
 * </th>
 * <th class="rotate-90 center"><div><span>{@link Type#VENTES_PUBLIQUES} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#AQPS}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#MILITAIRES}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#CIVILS_ET_MILITAIRES} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#CONCOURS}</span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#DEMONSTRATION} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#QUALIFICATION_ACCAF} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#FINALE_REG_ACCAF} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#FINALE_NAT_ACCAF} </span></div></th>
 * <th class="rotate-90 center"><div><span>{@link Type#INCONNU}</span></div></th>
 * </tr>
 * </thead>
 *
 * <tr>
 * <th class="row-header">{@code AMATEURS}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AMATEURS_PRIORITE_AUX_PROPRIETAIRES}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td>X</td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AMATEURS_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AMATEURS_AUTOSTART_PRIORITE_AUX_PROPRIETAIRES}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td>X</td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AMATEURS_DAMES}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td>X</td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AMATEURS_INTERNATIONALE}</th>
 * <td>X</td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AMATEURS_DAMES_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td>X</td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AMATEURS_INTERNATIONALE_AUTOSTART}</th>
 * <td>X</td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AMATEURS_NATIONALE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td>X</td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AMATEURS_EUROPEENNE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td>X</td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AMATEURS_EUROPEENNE_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td>X</td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code AMATEURS_NATIONALE_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td>X</td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code COURSE_AP}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td>X</td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code COURSE_AP_EUROPEENNE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td>X</td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td>X</td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code A_RECLAMER_MIXTE_APPRENTIS}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td>X</td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td>X</td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code APPRENTIS_LADS_JOCKEYS}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td>X</td> <!-- APPRENTIS -->
 * <td>X</td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code A_RECLAMER_MIXTE_APPRENTIS_LADS_JOCKEYS}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td>X</td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td>X</td> <!-- APPRENTIS -->
 * <td>X</td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code APPRENTIS_LADS_JOCKEYS_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td>X</td> <!-- APPRENTIS -->
 * <td>X</td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code APPRENTIS_LADS_JOCKEYS_EUROPEENNE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td>X</td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td>X</td> <!-- APPRENTIS -->
 * <td>X</td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code APPRENTIS_LADS_JOCKEYS_A_RECLAMER_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td>X</td> <!-- APPRENTIS -->
 * <td>X</td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code APPRENTIS_LADS_A_RECLAMER_MIXTE_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td>X</td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td>X</td> <!-- APPRENTIS -->
 * <td>X</td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code INTERNATIONALE}</th>
 * <td>X</td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code INTERNATIONALE_AUTOSTART}</th>
 * <td>X</td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code A_RECLAMER_AMATEURS}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code A_RECLAMER_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code A_RECLAMER_MIXTE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td>X</td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code A_RECLAMER_MIXTE_AMATEURS}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td>X</td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code A_RECLAMER_AMATEURS_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code A_RECLAMER_APPRENTIS_LADS_JOCKEYS}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td>X</td> <!-- APPRENTIS -->
 * <td>X</td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code A_RECLAMER_COURSE_AP}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td>X</td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code A_RECLAMER_EUROPEENNE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td>X</td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code A_RECLAMER_INTERNATIONALE}</th>
 * <td>X</td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td>X</td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code CLASSIQUE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td>X</td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code SEMI_CLASSIQUE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td>X</td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code CLASSIQUE_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td>X</td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code SEMI_CLASSIQUE_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td>X</td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code COURSE_EN_PARTIE_LIEE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td>X</td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code COURSE_EN_PARTIE_LIEE_AMATEURS}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td>X</td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td>X</td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code EUROPEENNE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td>X</td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code EUROPEENNE_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td>X</td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code EUROPEENNE_SEMI_CLASSIQUE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td>X</td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td>X</td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code EUROPEENNE_SEMI_CLASSIQUE_AUTOSTART}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td>X</td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td>X</td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code EUROPEENNE_CLASSIQUE}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td>X</td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td>X</td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code EUROPEENNE_CLASSIQUE_AUTOSTAR}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td>X</td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td>X</td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td>X</td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code HANDICAP_DE_REQUALIFICATION}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td>X</td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td>X</td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td></td> <!-- INCONNU -->
 * </tr>
 *
 * <tr>
 * <th class="row-header">{@code INCONNU}</th>
 * <td></td> <!-- INTERNATIONALE -->
 * <td></td> <!-- EUROPEENNE -->
 * <td></td> <!-- NATIONALE -->
 * <td></td> <!-- GROUPE_I -->
 * <td></td> <!-- GROUPE_II -->
 * <td></td> <!-- GROUPE_III -->
 * <td></td> <!-- CLASSIQUE -->
 * <td></td> <!-- SEMI_CLASSIQUE -->
 * <td></td> <!-- AUTOSTART -->
 * <td></td> <!-- HANDICAP -->
 * <td></td> <!-- RECLAMER -->
 * <td></td> <!-- CATEGORIE -->
 * <td></td> <!-- DEDOUBLE -->
 * <td></td> <!-- DIVISE -->
 * <td></td> <!-- LIMITE -->
 * <td></td> <!-- REQUALIFICATION -->
 * <td></td> <!-- CONDITIONS -->
 * <td></td> <!-- QUALIF_HP -->
 * <td></td> <!-- MIXTE -->
 * <td></td> <!-- AMATEURS -->
 * <td></td> <!-- PROPRIETAIRES -->
 * <td></td> <!-- DAMES -->
 * <td></td> <!-- APPRENTIS -->
 * <td></td> <!-- LADS_JOCKEYS -->
 * <td></td> <!-- LIEE -->
 * <td></td> <!-- ANGLO_ARABES -->
 * <td></td> <!-- PREMIERE_SERIE -->
 * <td></td> <!-- DEUXIEME_SERIE -->
 * <td></td> <!-- TROISIEME_SERIE -->
 * <td></td> <!-- ARABES_PURS -->
 * <td></td> <!-- VENTES_PUBLIQUES -->
 * <td></td> <!-- AQPS -->
 * <td></td> <!-- MILITAIRES -->
 * <td></td> <!-- CIVILS_ET_MILITAIRES -->
 * <td></td> <!-- CONCOURS -->
 * <td></td> <!-- DEMONSTRATION -->
 * <td></td> <!-- QUALIFICATION_ACCAF -->
 * <td></td> <!-- FINALE_REG_ACCAF -->
 * <td></td> <!-- FINALE_NAT_ACCAF -->
 * <td>X</td> <!-- INCONNU -->
 * </tr>
 *
 * </tbody>
 *
 * <thead>
 * <tr>
 * <th></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#INTERNATIONALE} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#EUROPEENNE}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#NATIONALE}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#GROUPE_I}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#GROUPE_II}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#GROUPE_III}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#CLASSIQUE}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#SEMI_CLASSIQUE} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#AUTOSTART}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#HANDICAP}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#RECLAMER}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#CATEGORIE}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#DEDOUBLE}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#DIVISE}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#LIMITE}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#REQUALIFICATION} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#CONDITIONS}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#QUALIF_HP}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#MIXTE}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#AMATEURS}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#PROPRIETAIRES} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#DAMES}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#APPRENTIS}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#LADS_JOCKEYS} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#LIEE}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#ANGLO_ARABES} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#PREMIERE_SERIE} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#DEUXIEME_SERIE} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#TROISIEME_SERIE} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#ARABES_PURS}</span></div>
 * </th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#VENTES_PUBLIQUES} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#AQPS}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#MILITAIRES}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#CIVILS_ET_MILITAIRES} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#CONCOURS}</span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#DEMONSTRATION} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#QUALIFICATION_ACCAF} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#FINALE_REG_ACCAF} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#FINALE_NAT_ACCAF} </span></div></th>
 * <th class="rotate-90 bottom"><div><span>{@link Type#INCONNU}</span></div></th>
 * </tr>
 * </thead>
 *
 * </table>
 * </div>
 *
 * <br/>
 * Commentaires:
 * <ul>
 * <li>Les courses de groupe ({@link Type#GROUPE_I}, {@link Type#GROUPE_II}, {@link Type#GROUPE_III}
 * ) ne sont pas marquées comme des courses
 * internationales.</li>
 * <li>Les courses de série ({@link Type#PREMIERE_SERIE}, {@link Type#DEUXIEME_SERIE},
 * {@link Type#TROISIEME_SERIE} ) ne sont pas
 * marquées comme des courses internationales.</li>
 * <li>Qu'est-ce qu'une course {@code COURSE_A_CONDITION_QUALIF_HP}?</li>
 * <li>Qu'est-ce qu'une course {@code HANDICAP_DE_REQUALIFICATION}?</li>
 * <li>Qu'est-ce qu'une course {@code COURSE_A_CONDITION_QUALIF_HP}?</li>
 * <li>Qu'est-ce que l'ACCAF? {@link Type#QUALIFICATION_ACCAF} {@link Type#FINALE_REG_ACCAF}
 * {@link Type#FINALE_NAT_ACCAF} </ul>
 *
 */

// length = 20
public enum Type {

    /**
     * Course internationale.
     */
    @PMUEnumValue( {
            "INTERNATIONALE",
            "COURSE_INTERNATIONALE",
            "ANGLO_ARABES_INTER",
            "HANDICAP_INTERNATIONAL",
            "COURSE_MILITAIRE_INTER",
            "AMATEURS_INTERNATIONALE",
            "AMATEURS_INTERNATIONALE_AUTOSTART",
            "INTERNATIONALE_AUTOSTART",
            "A_RECLAMER_INTERNATIONALE" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.INTERNATIONALE )
    INTERNATIONALE,

    /**
     * Course européenne.
     */
    @PMUEnumValue( {
            "EUROPEENNE",
            "AMATEURS_EUROPEENNE",
            "AMATEURS_EUROPEENNE_AUTOSTART",
            "COURSE_AP_EUROPEENNE",
            "APPRENTIS_LADS_JOCKEYS_EUROPEENNE",
            "A_RECLAMER_EUROPEENNE",
            "EUROPEENNE_AUTOSTART",
            "EUROPEENNE_SEMI_CLASSIQUE",
            "EUROPEENNE_SEMI_CLASSIQUE_AUTOSTART",
            "EUROPEENNE_CLASSIQUE",
            "EUROPEENNE_CLASSIQUE_AUTOSTAR" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.EUROPEENNE )
    EUROPEENNE,

    /**
     * Course nationale.
     */
    @PMUEnumValue( {
            "NATIONALE",
            "NATIONALE_AUTOSTART",
            "NATIONALE_SEMI_CLASSIQUE",
            "NATIONALE_SEMI_CLASSIQUE_AUTOSTART",
            "NATIONALE_CLASSIQUE",
            "NATIONALE_CLASSIQUE_AUTOSTART",
            "AMATEURS_NATIONALE",
            "AMATEURS_NATIONALE_AUTOSTART" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.NATIONALE )
    NATIONALE,

    /**
     * Course de groupe I.
     */
    @PMUEnumValue( "GROUPE_I" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.GROUPE_I )
    GROUPE_I,

    /**
     * Course de groupe II.
     */
    @PMUEnumValue( "GROUPE_II" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.GROUPE_II )
    GROUPE_II,

    /**
     * Course de groupe III.
     */
    @PMUEnumValue( "GROUPE_III" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.GROUPE_III )
    GROUPE_III,

    /**
     * Course classique.
     */
    @PMUEnumValue( {
            "CLASSIQUE",
            "NATIONALE_CLASSIQUE",
            "NATIONALE_CLASSIQUE_AUTOSTART",
            "CLASSIQUE_AUTOSTART",
            "EUROPEENNE_CLASSIQUE",
            "EUROPEENNE_CLASSIQUE_AUTOSTAR" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.CLASSIQUE )
    CLASSIQUE,

    /**
     * Course semi-classique.
     */
    @PMUEnumValue( {
            "SEMI_CLASSIQUE",
            "NATIONALE_SEMI_CLASSIQUE",
            "NATIONALE_SEMI_CLASSIQUE_AUTOSTART",
            "SEMI_CLASSIQUE_AUTOSTART",
            "EUROPEENNE_SEMI_CLASSIQUE",
            "EUROPEENNE_SEMI_CLASSIQUE_AUTOSTART" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.SEMI_CLASSIQUE )
    SEMI_CLASSIQUE,

    /**
     * Départ à l'autostart.
     */
    @PMUEnumValue( {
            "AUTOSTART",
            "NATIONALE_AUTOSTART",
            "NATIONALE_SEMI_CLASSIQUE_AUTOSTART",
            "NATIONALE_CLASSIQUE_AUTOSTART",
            "AMATEURS_AUTOSTART",
            "AMATEURS_AUTOSTART_PRIORITE_AUX_PROPRIETAIRES",
            "AMATEURS_DAMES_AUTOSTART",
            "AMATEURS_INTERNATIONALE_AUTOSTART",
            "AMATEURS_EUROPEENNE_AUTOSTART",
            "AMATEURS_NATIONALE_AUTOSTART",
            "APPRENTIS_LADS_JOCKEYS_AUTOSTART",
            "APPRENTIS_LADS_JOCKEYS_A_RECLAMER_AUTOSTART",
            "APPRENTIS_LADS_A_RECLAMER_MIXTE_AUTOSTART",
            "INTERNATIONALE_AUTOSTART",
            "A_RECLAMER_AUTOSTART",
            "A_RECLAMER_AMATEURS_AUTOSTART",
            "CLASSIQUE_AUTOSTART",
            "SEMI_CLASSIQUE_AUTOSTART",
            "EUROPEENNE_AUTOSTART",
            "EUROPEENNE_SEMI_CLASSIQUE_AUTOSTART",
            "EUROPEENNE_CLASSIQUE_AUTOSTAR" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.AUTOSTART )
    AUTOSTART,

    /**
     * Course à handicap.
     *
     * @see Type#CATEGORIE
     * @see Type#DEDOUBLE
     * @see Type#DIVISE
     * @see Type#LIMITE
     * @see Type#REQUALIFICATION
     */
    @PMUEnumValue( {
            "HANDICAP",
            "HANDICAP_A_RECLAMER",
            "HANDICAP_DE_CATEGORIE",
            "HANDICAP_DEDOUBLE",
            "HANDICAP_DIVISE",
            "HANDICAP_CATEGORIE_DEDOUBLE",
            "HANDICAP_CATEGORIE_DIVISE",
            "HANDICAP_LIMITE",
            "HANDICAP_DE_CATEGORIE_A_RECLAMER",
            "HANDICAP_INTERNATIONAL",
            "ETALONS_VENTES_PUB_HAND",
            "HANDICAP_DE_REQUALIFICATION" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.HANDICAP )
    HANDICAP,

    /**
     * Course à réclamer.
     *
     * @see Type#MIXTE
     */
    @PMUEnumValue( {
            "A_RECLAMER",
            "HANDICAP_A_RECLAMER",
            "HANDICAP_DE_CATEGORIE_A_RECLAMER",
            "A_RECLAMER_MIXTE_APPRENTIS",
            "A_RECLAMER_MIXTE_APPRENTIS_LADS_JOCKEYS",
            "APPRENTIS_LADS_JOCKEYS_A_RECLAMER_AUTOSTART",
            "MIXTE",
            "APPRENTIS_LADS_A_RECLAMER_MIXTE_AUTOSTART",
            "A_RECLAMER_AMATEURS",
            "A_RECLAMER_AUTOSTART",
            "A_RECLAMER_MIXTE",
            "A_RECLAMER_MIXTE_AMATEURS",
            "A_RECLAMER_AMATEURS_AUTOSTART",
            "A_RECLAMER_APPRENTIS_LADS_JOCKEYS",
            "A_RECLAMER_COURSE_AP",
            "A_RECLAMER_EUROPEENNE",
            "A_RECLAMER_INTERNATIONALE" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.RECLAMER )
    RECLAMER,

    /**
     * Course à handicap de catégorie. Obligatoirement associé avec {@link Type#HANDICAP}.
     *
     * @see Type#HANDICAP
     */
    @PMUEnumValue( {
            "HANDICAP_DE_CATEGORIE",
            "HANDICAP_CATEGORIE_DEDOUBLE",
            "HANDICAP_CATEGORIE_DIVISE",
            "HANDICAP_DE_CATEGORIE_A_RECLAMER" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.CATEGORIE )
    CATEGORIE,

    /**
     * Course à handicap dédoublé. Obligatoirement associé avec {@link Type#HANDICAP}.
     *
     * @see Type#HANDICAP
     */
    @PMUEnumValue( { "HANDICAP_DEDOUBLE", "HANDICAP_CATEGORIE_DEDOUBLE" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.DEDOUBLE )
    DEDOUBLE,

    /**
     * Course à handicap divisé. Obligatoirement associé avec {@link Type#HANDICAP}.
     *
     * @see Type#HANDICAP
     */
    @PMUEnumValue( { "HANDICAP_DIVISE", "HANDICAP_CATEGORIE_DIVISE" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.DIVISE )
    DIVISE,

    /**
     * Course à handicap limité. Obligatoirement associé avec {@link Type#HANDICAP}.
     *
     * @see Type#HANDICAP
     */
    @PMUEnumValue( "HANDICAP_LIMITE" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.LIMITE )
    LIMITE,

    /**
     * Course à handicap de requalification. Obligatoirement associé avec {@link Type#HANDICAP}.
     *
     * @see Type#HANDICAP
     */
    @PMUEnumValue( "HANDICAP_DE_REQUALIFICATION" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.REQUALIFICATION )
    REQUALIFICATION,

    /**
     * Course à conditions.
     *
     * @see Type#QUALIF_HP
     */
    @PMUEnumValue( { "COURSE_A_CONDITIONS", "COURSE_A_CONDITION_QUALIF_HP" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.CONDITIONS )
    CONDITIONS,

    /**
     * Course à conditions "qualif HP". Obligatoirement associé avec {@link Type#CONDITIONS}.
     *
     * @see Type#CONDITIONS
     */
    @PMUEnumValue( "COURSE_A_CONDITION_QUALIF_HP" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.QUALIF_HP )
    QUALIF_HP,

    /**
     * Course mixte. Signifie qu'une partie seulement des chevaux sont à
     * réclamer. Obligatoirement associé avec {@link Type#RECLAMER}.
     *
     * @see Type#RECLAMER
     */
    @PMUEnumValue( {
            "MIXTE",
            "A_RECLAMER_MIXTE_APPRENTIS",
            "A_RECLAMER_MIXTE_APPRENTIS_LADS_JOCKEYS",
            "APPRENTIS_LADS_A_RECLAMER_MIXTE_AUTOSTART",
            "A_RECLAMER_MIXTE",
            "A_RECLAMER_MIXTE_AMATEURS" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.MIXTE )
    MIXTE,

    /**
     * Course amateur.
     *
     * @see Type#PROPRIETAIRES
     * @see Type#DAMES
     */
    @PMUEnumValue( {
            "AMATEURS",
            "AMATEURS_AUTOSTART",
            "AMATEURS_AUTOSTART_PRIORITE_AUX_PROPRIETAIRES",
            "AMATEURS_DAMES",
            "AMATEURS_DAMES_AUTOSTART",
            "AMATEURS_INTERNATIONALE",
            "AMATEURS_INTERNATIONALE_AUTOSTART",
            "AMATEURS_NATIONALE",
            "AMATEURS_NATIONALE_AUTOSTART",
            "AMATEURS_EUROPEENNE",
            "AMATEURS_EUROPEENNE_AUTOSTART",
            "A_RECLAMER_AMATEURS",
            "A_RECLAMER_MIXTE_AMATEURS",
            "A_RECLAMER_AMATEURS_AUTOSTART",
            "COURSE_EN_PARTIE_LIEE_AMATEURS" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.AMATEURS )
    AMATEURS,

    /**
     * Course amateur avec priorité aux propriétaires. Obligatoirement associé
     * avec {@link Type#AMATEURS}.
     *
     * @see Type#AMATEURS
     */
    @PMUEnumValue( {
            "AMATEURS_PRIORITE_AUX_PROPRIETAIRES",
            "AMATEURS_AUTOSTART_PRIORITE_AUX_PROPRIETAIRES" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.PROPRIETAIRES )
    PROPRIETAIRES,

    /**
     * Course amateurs réservé aux dames. Obligatoirement associé avec {@link Type#AMATEURS}.
     *
     * @see Type#AMATEURS
     */
    @PMUEnumValue( { "AMATEURS_DAMES", "AMATEURS_DAMES_AUTOSTART" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.DAMES )
    DAMES,

    /**
     * Course réservée aux apprentis. Par défaut, apprentis lad-driver, sauf en
     * présence de {@link Type#LADS_JOCKEYS}.
     *
     * @see Type#LADS_JOCKEYS
     */
    @PMUEnumValue( {
            "COURSE_AP",
            "COURSE_AP_EUROPEENNE",
            "A_RECLAMER_MIXTE_APPRENTIS",
            "APPRENTIS_LADS_JOCKEYS",
            "A_RECLAMER_MIXTE_APPRENTIS_LADS_JOCKEYS",
            "APPRENTIS_LADS_JOCKEYS_AUTOSTART",
            "APPRENTIS_LADS_JOCKEYS_EUROPEENNE",
            "APPRENTIS_LADS_JOCKEYS_A_RECLAMER_AUTOSTART",
            "APPRENTIS_LADS_A_RECLAMER_MIXTE_AUTOSTART",
            "A_RECLAMER_APPRENTIS_LADS_JOCKEYS",
            "A_RECLAMER_COURSE_AP" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.APPRENTIS )
    APPRENTIS,

    /**
     * Course réservée aux apprentis lads-jockey. Obligatoirement associé avec
     * {@link Type#APPRENTIS}.
     *
     * @see Type#APPRENTIS
     */
    @PMUEnumValue( {
            "APPRENTIS_LADS_JOCKEYS",
            "A_RECLAMER_MIXTE_APPRENTIS_LADS_JOCKEYS",
            "APPRENTIS_LADS_JOCKEYS_AUTOSTART",
            "APPRENTIS_LADS_JOCKEYS_EUROPEENNE",
            "APPRENTIS_LADS_JOCKEYS_A_RECLAMER_AUTOSTART",
            "APPRENTIS_LADS_A_RECLAMER_MIXTE_AUTOSTART",
            "A_RECLAMER_APPRENTIS_LADS_JOCKEYS" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.LADS_JOCKEYS )
    LADS_JOCKEYS,

    /**
     * Courses en partie liée. Définition:
     * "Course dont le résultat ne devient définitif qu'après plusieurs épreuves"
     * .
     */
    @PMUEnumValue( { "COURSE_EN_PARTIE_LIEE", "COURSE_EN_PARTIE_LIEE_AMATEURS" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.LIEE )
    LIEE,

    /**
     * Course réservée à la race anglo-arabe.
     *
     * @see Type#PREMIERE_SERIE
     * @see Type#DEUXIEME_SERIE
     * @see Type#TROISIEME_SERIE
     */
    @PMUEnumValue( {
            "ANGLO_ARABES",
            "ANGLO_ARABES_1ERE_SERIE",
            "ANGLO_ARABES_2EME_SERIE",
            "ANGLO_ARABES_3EME_SERIE",
            "ANGLO_ARABES_INTER" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.ANGLO_ARABES )
    ANGLO_ARABES,

    /**
     * Course d'anglo-arabes de première série. Obligatoirement associé avec
     * {@link Type#ANGLO_ARABES} .
     *
     * @see Type#ANGLO_ARABES
     */
    @PMUEnumValue( "ANGLO_ARABES_1ERE_SERIE" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.PREMIERE_SERIE )
    PREMIERE_SERIE,

    /**
     * Course d'anglo-arabes de deuxième série. Obligatoirement associé avec
     * {@link Type#ANGLO_ARABES} .
     *
     * @see Type#ANGLO_ARABES
     */
    @PMUEnumValue( "ANGLO_ARABES_2EME_SERIE" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.DEUXIEME_SERIE )
    DEUXIEME_SERIE,

    /**
     * Course d'anglo-arabes de troisième série. Obligatoirement associé avec
     * {@link Type#ANGLO_ARABES}.
     *
     * @see Type#ANGLO_ARABES
     */
    @PMUEnumValue( "ANGLO_ARABES_3EME_SERIE" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.TROISIEME_SERIE )
    TROISIEME_SERIE,

    /**
     * Course réservée à la race arabe pure.
     */
    @PMUEnumValue( "ARABES_PURS" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.ARABES_PURS )
    ARABES_PURS,

    /**
     * Course à ventes publiques.
     */
    @PMUEnumValue( { "VENTES_PUBLIQUES", "ETALONS_VENTES_PUBLIQUES", "ETALONS_VENTES_PUB_HAND" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.VENTES_PUBLIQUES )
    VENTES_PUBLIQUES,

    /**
     * Course réservée aux AQPS. AQPS: Autre Que de Pur-Sang anglais.
     */
    @PMUEnumValue( "AUTRES_QUE_PUR_SANG_ANGL" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.AQPS )
    AQPS,

    /**
     * Course de chevaux militaires.
     */
    @PMUEnumValue( { "CHEVAUX_MILITAIRES", "COURSE_MILITAIRE_INTER" } )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.MILITAIRES )
    MILITAIRES,

    /**
     * Course courues par des chevaux civils et militaires.
     */
    @PMUEnumValue( "CHEVAUX_CIVILS_ET_MILITAIRES" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.CIVILS_ET_MILITAIRES )
    CIVILS_ET_MILITAIRES,

    /**
     * Course de concours.
     */
    @PMUEnumValue( "CHEVAUX_DE_CONCOURS" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.CONCOURS )
    CONCOURS,

    /**
     * Course de démonstration.
     */
    @PMUEnumValue( "COURSE_DE_DEMONSTRATION" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.DEMONSTRATION )
    DEMONSTRATION,

    /**
     * Course de qualification ACCAF.
     */
    @PMUEnumValue( "QUALIFICATION_ACCAF" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.QUALIFICATION_ACCAF )
    QUALIFICATION_ACCAF,

    /**
     * Finale régionale ACCAF.
     */
    @PMUEnumValue( "FINALE_REGIONALE_ACCAF" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.FINALE_REG_ACCAF )
    FINALE_REG_ACCAF,

    /**
     * Finale nationale ACCAF.
     */
    @PMUEnumValue( "FINALE_NATIONALE_ACCAF" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.FINALE_NAT_ACCAF )
    FINALE_NAT_ACCAF,

    /**
     * Type de course inconnu.
     */
    @PMUEnumValue( "INCONNU" )
    @KaamelottEnumRaceTypeValue( com.windwagon.kaamelott.race.RaceType.INCONNU )
    INCONNU

}
