package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckAddNewFacility {
    static final private String VILLA_ID_REGEX = "^SVVL-\\d{4}$";
    static final private String ROOM_ID_REGEX = "^SVRO-\\d{4}$";
    static final private String NAME_SERVICE_REGEX = "^[A-Z]\\w+";
    static final private String AREA_REGEX = "(0*3[1-9]+\\.?\\d*)|(0*30\\.?\\d*[1-9])|(0*[4-9]\\d+\\.?\\d*)";
    static final private String PRICE_REGEX = "(\\d*\\.?\\d*[1-9]$)|(\\d*\\.?\\d*[1-9]+\\d*)|(\\d*[1-9]\\.?\\d*)||([1-9]\\d*\\.?\\d*)";
    static final private String MAXIMUM_PERSON_REGEX = "(^0*[1-9])|(^0*1\\d$)";
    static final private String RENTAL_TYPE_REGEX = "(RentByDay)|(RentByMonth)|(RentByYear)";
    static final private String NUMBER_OF_FLOORS ="(0*[1-9])|(\\d*[1-9]\\d*)";
    static final private String STANDARD_ROOM_REGEX = NAME_SERVICE_REGEX;
    static final private String DATE_OF_BIRTH_REGEX = "(0[1-9]|[1-2]\\d|3[0-1])/(0\\d|1[0-2])/(\\d{4})" ;
    static final private String NUMBER_OF_USES_REGEX = "[0-5]";

    private Pattern pattern;
    private Matcher matcher;

    public  boolean checkVillaId(String regex) {
        pattern = Pattern.compile(VILLA_ID_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean checkRoomId(String regex) {
        pattern = Pattern.compile(ROOM_ID_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean checkNameService(String regex) {
        pattern = Pattern.compile(NAME_SERVICE_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean checkArea(String regex) {
        pattern = Pattern.compile(AREA_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean checkPrice(String regex) {
        pattern = Pattern.compile(PRICE_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean checkRentalType(String regex) {
        pattern = Pattern.compile(RENTAL_TYPE_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean checkStandardRoom(String regex) {
        pattern = Pattern.compile(STANDARD_ROOM_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean checkNumberOfFloors(String regex) {
        pattern = Pattern.compile(NUMBER_OF_FLOORS);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean checkDateOfBirth(String regex) {
        pattern = Pattern.compile(DATE_OF_BIRTH_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean checkMaximumPerson(String regex) {
        pattern = Pattern.compile(MAXIMUM_PERSON_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean checkNumberOfUses(String regex) {
        pattern = Pattern.compile(NUMBER_OF_USES_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(new CheckAddNewFacility().checkPrice("10000"));
        Double d = 10000d;
        Scanner scanner = new Scanner(System.in);
        Double c = Double.parseDouble(scanner.nextLine());
        System.out.println(c);
    }

}
