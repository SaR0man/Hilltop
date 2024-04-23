import java.util.Random;

enum HotelType {
    ONE_STAR, THREE_STARS, FOUR_STARS, FIVE_STARS
}

class HotelBooking {
    public int bookHotel(HotelType hotelType, int days) {
        return switch (hotelType) {
            case ONE_STAR -> 100 * days;
            case THREE_STARS -> 130 * days;
            case FOUR_STARS -> 150 * days;
            case FIVE_STARS -> 220 * days;
            default -> 0;
        };
    }
}

enum TripType {
    BUS, TRAIN, AIRPLANE
}

class TripBooking {
    Random random = new Random();
    public double bookTrip(TripType tripType, String from, String to) {
        int distance = random.nextInt(4900) + 100;  // генерирует от 100 до 5000

        return switch (tripType) {
            case BUS -> distance * 0.5;
            case TRAIN -> distance * 1.5;
            case AIRPLANE -> distance * 3.5;
            default -> 0;
        };
    }
}

enum GuideType {
    NONE, AUDIO, PERSON
}

class GuideBooking {
    public int bookGuide(GuideType guideType, int days) {
        return switch (guideType) {
            case NONE -> 0;
            case AUDIO -> days * 100;
            case PERSON -> days * 500;
            default -> 0;
        };
    }
}

//Facade
class TravelAgency {

//    public double buildTrip(String fromCity, String toCity, int days, HotelType hotelType, TripType tripType, GuideType guideType) {
//        double price = 0;
//
//        HotelBooking hotelBooking = new HotelBooking();
//        price += hotelBooking.bookHotel(hotelType, days);
//
//        TripBooking tripBooking = new TripBooking();
//        price += tripBooking.bookTrip(tripType, fromCity, toCity);
//
//        GuideBooking guideBooking = new GuideBooking();
//        price += guideBooking.bookGuide(guideType, days);
//
//        return price;
//    }



    public String buildTrip(String fromCity, String toCity, int days, HotelType hotelType, TripType tripType, GuideType guideType) {

        StringBuilder stringBuilder = new StringBuilder(1000);

        double price = 0;
        stringBuilder.append("Welcome Booking!\n----------------\n");
        stringBuilder.append("From      : " + fromCity);
        stringBuilder.append("\nTo        : " + toCity);
        stringBuilder.append("\nDays      : " + days);


        HotelBooking hotelBooking = new HotelBooking();
        double fromHotel = hotelBooking.bookHotel(hotelType, days);
        stringBuilder.append("\nHotel     : " + hotelType + " = " + fromHotel + " $");


        TripBooking tripBooking = new TripBooking();
        double fromTrip = tripBooking.bookTrip(tripType, fromCity, toCity);
        stringBuilder.append("\nTransport : " + tripType + " = " + fromTrip + " $");

        GuideBooking guideBooking = new GuideBooking();
        double fromGuide = guideBooking.bookGuide(guideType, days);
        stringBuilder.append("\nGuide     : " + guideType + " = " + fromGuide + " $");

        price = fromGuide+fromTrip+fromHotel;
        stringBuilder.append("\n...........\nTotal sum : " + price + " $ ");

        return stringBuilder.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        TravelAgency travelAgency = new TravelAgency();

        String information = travelAgency.buildTrip("Baku", "Moscow", 7, HotelType.FIVE_STARS, TripType.AIRPLANE, GuideType.NONE);

        System.out.println(information);

//        double price = travelAgency.buildTrip("Saint Petersburg", "Paris", 7, HotelType.FOUR_STARS, TripType.AIRPLANE, GuideType.AUDIO);
//        System.out.println("Coast: " + price);
//        travelAgency.buildTrip("Baku", "Moscow", 7, HotelType.FIVE_STARS, TripType.AIRPLANE, GuideType.NONE);
    }
}