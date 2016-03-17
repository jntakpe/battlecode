package fr.github.jntakpe.battlecode.plutarque;

/**
 * @author jntakpe
 */
public class PlutarqueMain {

    public static final String[] ENONCES = {
            "1.4,10,STSFEROLNOUADOTNMPHKOSEARTRNEOND",
            "13,102,LIUTUMRHKYFEEOAR",
            "28,110,HHHPLOLWMAEEOFAAMTAECADLMIIDINELMSRVTUNOWTSEYNSW",
            "18,51,SODRNDULTRTOVSADILEYAIPIETBNTXASORDRIUGRANTNAEVOSPANDETSSINIR NDPRETOCSNISCEICENEOEVFRRAHREOFSAOIFENIOFTSTRTONOAFFWPEMIRALETEAR AACMBOUHRRONTAALGREIECDILNEYOMNDEPOBCSYPOGESUNUEIEESSVSBPSSTSATIESLRIESTNCNLEIONRCHLOTORCGEVLIEMHPVORSIISAPEMIRASCEIDRMECGMCENSEEA NEAMHSTTRHRTSNEAASHIEKISISLDTENNENOSTLDOADSTFPAHEEMNIICRRTANDASGV OAAITGVKWIENSSOAEAEETPSTTNDSLTRAOURESDCUHOLRLURTROEEFTTTCIOEMABT RFITADSBNEHAONUIESIDSENLGRSLTNITTSISETIHINUHFOYMRVENNSIOSSAUEIGOERR OTNSRRHVODMFEATSMIAFQAEMGEUOGTIUTNSEDCSHINEIDIMBCTQOFSOTNEYECUN OTNOTNLSOASRIPEETESMLOMORNGAAFPIPAN"
    };

    public static void main(String[] args) {
        for (String ENONCE : ENONCES) {
            Baton baton = Baton.init(ENONCE);
            System.out.println(readMsg(baton));
        }
    }

    public static String readMsg(Baton baton) {
        char[] message = baton.getMessage().toCharArray();
        StringBuilder builder = new StringBuilder(message.length);
        for (int i = 0; i < baton.getLetterPerRound(); i++) {
            for (int j = i; j < message.length; j = j + baton.getLetterPerRound()) {
                builder.append(message[j]);
            }
        }
        return builder.toString();
    }

}
