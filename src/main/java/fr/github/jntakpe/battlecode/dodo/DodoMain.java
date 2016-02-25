package fr.github.jntakpe.battlecode.dodo;

import org.apache.commons.lang3.StringUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jntakpe
 */
public class DodoMain {

    public static final String[] dodoKeys = {"po", "pa", "pe", "pi", "to", "ta", "te", "ti", "ko", "ka"};

    public static final String[] ENONCES = {
            "papopeto",
            "papetedotidepetadokadopatekadatatidopipidopetidetotidatitopidotepetadapipeta",
            "papetedokokopadotidepetadapatadepekodepadekadopatekadotatipipidopetidetotidatitopidotepetadotokadetadekodepodetotidapipetadopepadekopedopipokadakopopedatatopipidotitedopo"
    };

    public static void main(String[] args) throws Exception{
        for (String enonce : ENONCES) {
            List<String> parsed = parse(enonce);
            List<DodoLang> corrTable = initCorrTable();
            String expr = parsed.stream()
                    .map(ope -> corrTable.get(corrTable.indexOf(new DodoLang(ope, null))))
                    .map(DodoLang::getOperation)
                    .collect(Collectors.joining());
            System.out.println(eval(expr).intValue());

        }
    }

    public static List<DodoLang> initCorrTable() {
        List<DodoLang> dodoLangs = new ArrayList<>();
        for (int i = 0; i < dodoKeys.length; i++) {
            dodoLangs.add(new DodoLang(dodoKeys[i], String.valueOf(i)));
        }
        dodoLangs.add(new DodoLang("do", "+"));
        dodoLangs.add(new DodoLang("da", "-"));
        dodoLangs.add(new DodoLang("de", "*"));
        return dodoLangs;
    }

    public static List<String> parse(String text) {
        String noWhiteSpace = StringUtils.deleteWhitespace(text);
        char[] chars = noWhiteSpace.trim().toLowerCase().toCharArray();
        List<String> parsed = new ArrayList<>();
        String current = "";
        for (int i = 0; i< chars.length; i++) {
            if (i % 2 == 0) {
                current = String.valueOf(chars[i]);
            } else {
                current += String.valueOf(chars[i]);
                parsed.add(current);
            }
        }
        return parsed;
    }

    public static Number eval(String expr) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        return (Number) engine.eval(expr);
    }


}
