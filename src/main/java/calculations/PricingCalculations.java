package calculations;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import models.input.Trip;

import models.RoadType;
import models.VehicleInvoice;

public class PricingCalculations {

    private static BigDecimal GlobalCostModifier = new BigDecimal("0.0001");

    // Properties for road type
    private static BigDecimal RoadtypeACost = new BigDecimal("0.005");
    private static BigDecimal RoadtypeBCost = new BigDecimal("0.003");
    private static BigDecimal RoadtypeCCost = new BigDecimal("0.002");
    private static BigDecimal RoadtypeDCost = new BigDecimal("0.001");
    private static BigDecimal RoadtypeECost = new BigDecimal("0.000");
    private static BigDecimal DefaultRoadtypeCost = new BigDecimal("0");

    // Properties for rush hour
    private static LocalTime RUSH_MORNING_START = LocalTime.of(7, 30, 00);
    private static LocalTime RUSH_MORNING_END = LocalTime.of(9, 00, 00);
    private static LocalTime RUSH_AFTERNOON_START = LocalTime.of(16, 30, 00);
    private static LocalTime RUSH_AFTERNOON_END = LocalTime.of(19, 00, 00);
    private static BigDecimal RUSH_COSTMULTIPLIER = new BigDecimal("1.25");

    // Properties for energy label

    public static <Trip> BigDecimal getCostForTrip(Trip trip) {
        BigDecimal total = new BigDecimal("0");

        List<TripPoint> trippoints = trip.getTripPoints();
        for (TripPoint tp : trippoints) {
            BigDecimal rushourMultiplier = PricingCalculations.getCostMultiplierForRushHour(tp.getLocalTime());
            BigDecimal enegylabelMultiplier = PricingCalculations.getCostMultiplierForEnergyLabel(trip.getVehicle());
        }

        return null;
    }

    public static BigDecimal getCostForVehicleInvoice(VehicleInvoice vehicleInvoice) {
        return null;
    }

    public static BigDecimal calculateKilometerCost(VehicleInvoice vehicleInvoice) {
        return null;
    }

    public static BigDecimal getCostForRoadType(RoadType RoadType) {
        switch (RoadType) {
        case A:
            return RoadtypeACost;
        case B:
            return RoadtypeBCost;
        case C:
            return RoadtypeCCost;
        case D:
            return RoadtypeDCost;
        case E:
            return RoadtypeECost;
        default:
            return DefaultRoadtypeCost;
        }
    }

    public static BigDecimal getCostMultiplierForRushHour(LocalTime DrivenTime) {
        if (DrivenTime.isAfter(RUSH_MORNING_START) && DrivenTime.isBefore(RUSH_MORNING_END)
                || DrivenTime.isAfter(RUSH_AFTERNOON_START) && DrivenTime.isBefore(RUSH_AFTERNOON_END)) {
            return RUSH_COSTMULTIPLIER;
        }

        return new BigDecimal("1");
    }

    public static BigDecimal getCostMultiplierForEnergyLabel() {
        return new BigDecimal("1");
    }
}