package u.schmutz.brutto_netto_rechner;

/**
 * Created by Admin on 30.01.2018.
 */

public class Ergebnis {
    public float betrag;
    public boolean isNetto;
    public int ustProzent;

    public float betragNetto;
    public float betragBrutto;
    public float betragUst;

    public void berechneErgebnis(){
        // Berechne Bruttoertrag aus Nettobetrag:
        if (isNetto){
            betragNetto = betrag;
            betragUst = betrag * ustProzent / 100;
            betragBrutto = betrag + betragUst;
        } else {
            // Berechne Nettobetrag aus Bruttobetrag;
            betragBrutto = betrag;
            betragUst = betrag * ustProzent /
                    (100 + ustProzent);
            betragNetto = betrag- betragUst;
        }
    }

}
