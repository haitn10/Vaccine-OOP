/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHECK;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author tranh
 */
public class CheckDate {
    public static boolean isLeap(int y) {
        boolean result = false;
        if (y % 400 == 0||((y % 4 == 0) && (y % 100 == 0))) result = true;
        return result;
    }
    
    public static boolean valid(int d, int m, int y) {
        if (y < 0 || m < 0 || m > 12 || d < 0 || d > 31) return false;
        int maxD = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) maxD = 30;
        else if (m == 2) {
            if (isLeap(y)) maxD = 29;
            else maxD = 28;
        }
        return d <= maxD;
    }

    public static long toDate(String ymd) {
        String date = ymd;
        StringTokenizer stk = new StringTokenizer(ymd, "/-");
        int d = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());
        if (!valid(d, m, y)) return -1;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d1 = new Date(ymd);
            if (d1.compareTo(sdf.parse("8/3/2021")) < 0) throw new Exception();
        } catch (ParseException e) {
            return -1;
        } catch (Exception ex) {
            System.out.println("Day must be greater than 8/3/2021!");
            return -1;
        }
        
        Calendar cal = Calendar.getInstance();
        cal.set(d, m-1, y);
        long t = cal.getTime().getTime();
        return t;
    }
    public static long daysBetween(String d1, String d2) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            long i = (sdf.parse(d2).getTime() - sdf.parse(d1).getTime()) / (24 * 60 * 60 * 1000);
            return i;
        } catch (ParseException e) {
            System.out.println("The second day of injection must be 4 to 12 weeks after the first injection!");
        }
        return 0;
    }
}
