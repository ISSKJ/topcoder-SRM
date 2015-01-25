import java.util.*;


public class ChocolateDividingEasy {

    public int findBest(String[] choco) {

        int[][] matrix;
        int X,Y;

        X = choco[0].length();
        Y = choco.length;

        matrix = new int[Y][X];

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                matrix[y][x] = Integer.parseInt(""+choco[y].charAt(x));
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();


        for (int x1 = 1; x1 < X; x1++) {
            for (int x2 = x1+1; x2 < X; x2++) {
                for (int y1 = 1; y1 < Y; y1++) {
                    for (int y2 = y1+1; y2 < Y; y2++) {
                        res.add(findBest(matrix, x1, x2, y1, y2));
                    }
                }
            }
        }

        Collections.sort(res, Collections.reverseOrder());

        return res.get(0);
    }

    private int findBest(int[][] matrix, int x1, int x2, int y1, int y2) {
        int[][] box = new int[3][3];

        int xc = 0;
        int yc = 0;

        for (int y = 0; y < matrix.length; y++) {
            int tmp = 0;
            xc = 0;
            for (int x = 0; x < matrix[0].length; x++) {
                if (x == x1 || x == x2) {
                    box[yc][xc] = tmp;
                    xc++;
                    tmp = 0;
                }
                tmp += matrix[y][x];
            }
            box[yc][xc] = tmp;
            if (y == y1 || y == y2) {
                yc++;
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (box[y][x] != 0) {
                    res.add(box[y][x]);
                }
            }
        }
        Collections.sort(res);

        return res.get(0);
    }

    private static void test(int res, int exp) {
        System.out.println("\n[EXP]="+exp+"\n[RES]="+res);
    }


    public static void main(String[] args) {
        ChocolateDividingEasy obj = new ChocolateDividingEasy();

        test(obj.findBest(
                    new String[] {
                        "9768",
                        "6767",
                        "5313"
                    }), 3);
        // There are three valid ways to cut this chocolate. One of the optimal ones is shown below. 
        // 9 | 7 | 6 8 
        // --|---|----- 
        // 6 | 7 | 6 7 
        // --|---|----- 
        // 5 | 3 | 1 3 
        // 
        // This way of cutting produces parts with the following qualities: 9, 7, 14, 6, 7, 13, 5, 3, and 4.
        // The quality of the worst part (the one that Mirosz will get) is 3. 
        // Here is another way of cutting the same chocolate: 
        //
        // 9 7 | 6 | 8 
        // ----|---|--- 
        // 6 7 | 6 | 7 
        // ----|---|--- 
        // 5 3 | 1 | 3 
        //
        // If Mirosz cuts the chocolate in this way, the quality of his part will be 1, which is worse than 3.

        test(obj.findBest(
                    new String[] {
                        "36753562",
                        "91270936",
                        "06261879",
                        "20237592",
                        "28973612",
                        "93194784"
                    }), 15);
        // There is only one optimal way to divide the chocolate: 
        //
        // 3 6 7 5 | 3 5 | 6 2 
        // 9 1 2 7 | 0 9 | 3 6 
        // --------|-----|----- 
        // 0 6 2 6 | 1 8 | 7 9 
        // 2 0 2 3 | 7 5 | 9 2 
        // --------|-----|----- 
        // 2 8 9 7 | 3 6 | 1 2 
        // 9 3 1 9 | 4 7 | 8 4 
        //
        // The three parts on the top have qualities 3+6+7+5+9+1+2+7 = 40, 3+5+0+9 = 17 and 6+2+3+6 = 17 
        // The worst part is the one in the bottom right corner. Its quality is only 1+2+4+8 = 15.


        test(obj.findBest(
                    new String[]
                    {
                        "012",
                        "345",
                        "678"
                    }
                    ), 0);

        test(obj.findBest(
                    new String[]
                        {
                            "36753562912709360626187920237592289736129319478450", "36106320615547656937452547443078688431492068926649", "50487172722610615949091771159776736563948129390885", "09638561159848103044447631759621785741859753883189", "64333860488897764303092540594692247754812893680210", "51108506462586284724062990813110340391969338056640", "04626756987282996027613215991491075870480429610422", "20552902838040919625449936050294351743146942264128", "89288868383338047689068790333732652658796041048708", "62479392830178915492574994593570819978253490201962", "12073119056774064748582606646289607010137726452029", "09945103788604676097597853383793787419098858437138", "09799324371220217517417111704085166219648081022975", "64637974917060853941541554983852227034636334439725", "89024765713338510876350804113593415083565990763761", "50650812269104274032803700349274252443860892231834", "22451757169813337986704848168521996064990893148967", "73712215090401374113032175654221724165785927364797", "22163021565003466025895060837821058550738230777691", "19089880370692177976271588456568488387524505732721", "34941957412216202297435614031277981076010251971312", "06874924459128960640945466399521309913458573389553", "86033618705110300454249994981639334615617229281247", "86377237253768136403585099802490120063908387310050", "31801791035948469290303379499194206595611437273392", "44499383295439495573907272905041793621253918870527", "91963684667274100644373472179568955215991621053219", "76820643369048512973809231874163855012648562526913", "31526944607437900226903558717060413029609354364319", "10945625917741191387493138793884008682385059268528", "36787266297037235178941643548733501457078993946455", "56062699296553867360269308765240068549468323622470", "49654642516137712108901348582206361057420033904334", "24538113158133975449672101377639104118643477074530", "72993027995208359656302074730167578890780310367322", "15338285808693374371396420295746491231813892451001", "33000222479854786006437581093026438670819816485015", "97062895027281779798898052024373001580004753142013", "00482202458408425427575228660091269482827867709454", "22396574394406022843111900025769198765114857669143", "67697609076687766537697264075401280152071649535110", "07081641498622523273901506979289989363604496641980", "49055016028849834491757624255052977681203287463804", "97975137809521327332386160919150949682465347471404", "83346155466967564300253850566734080815351140118578", "51609124901443251326069680867544605539150496743096", "60458286853401778089783972502480626566341713082901", "08167882138935412277914047876808614525938843505934", "62532000980967214484984419680936389501719826759399", "79735041941436422761851130644753827353748001645831"
                        }), 1171); 

    }
}
