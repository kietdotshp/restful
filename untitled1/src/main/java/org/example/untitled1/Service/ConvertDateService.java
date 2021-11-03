package org.example.untitled1.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDateService {
    public Date ConvertStringToDate(String StringDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return (Date) dateFormat.parse(StringDate.trim());
        } catch (Exception e) {
            return null;
        }
    }

    public Date ConvertStringToDate2(String StringDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            return (Date) dateFormat.parse(StringDate.trim());
        } catch (Exception e) {
            return null;
        }
    }

    public String ConvertDateToString(Date date) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = dateFormat.format(date);
            return strDate;
        } catch (Exception e) {
            return null;
        }
    }

    public String ConvertDateToStringDayMonth(Date date) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM");
            String strDate = dateFormat.format(date);
            return strDate;
        } catch (Exception e) {
            return null;
        }
    }

    public String ConvertDateToStringMonthYear(Date date) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
            String strDate = dateFormat.format(date);
            return strDate;
        } catch (Exception e) {
            return null;
        }
    }
}
