import java.util.List;
import java.util.Map;

class PrakingLot {
    private String nameOfParkingLot;
    private int address;
    private List<ParkingFloor> parkingFloors;
    private static PrakingLot parkingLot = null;

    private PrakingLot(String nameOfParkingLot, int address, List<ParkingFloor> parkingFloors) {
        this.nameOfParkingLot = nameOfParkingLot;
        this.address = address;
        this.parkingFloors = parkingFloors;
    }

    // This is a singleton class
    // This method returns the single instance of the ParkingLot class
    // It takes the name of the parking lot, address, and a list of parking floors
    // as parameters
    // If the instance is null, it creates a new instance with the provided
    // parameters
    // Otherwise, it returns the existing instance
    // This method is used to get the instance of the ParkingLot class
    // It ensures that only one instance of the ParkingLot class is created
    public static PrakingLot getInstance(String nameOfParkingLot, int address, List<ParkingFloor> parkingFloors) {
        if (parkingLot == null) {
            parkingLot = new PrakingLot(nameOfParkingLot, address, parkingFloors);
        }
        return parkingLot;
    }

    public void addFlors(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
        ParkingFloor parkingFloor = new ParkingFloor(name, parkingSlots);
        parkingFloors.add(parkingFloor);
    }

    public void removeFloor(ParkingFloor parkingFloor) {
        parkingFloors.remove(parkingFloor);
    }

    public Ticket assignTicket(Vehicle vehicle) {
        ParkingSlot parkingSlot = getParkingSlotFrVehicleAndPark(vehicle);
        if (parkingSlot == null) {
            return null;
        }
        Ticket parkingTicket = createticketForSlot(parkingSlot, vehicle);
        return parkingTicket;
    }

    private Ticket createticketForSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        return Ticket.createTicket(vehicle, parkingSlot);
    }

    private ParkingSlot getParkingSlotFrVehicleAndPark(Vehicle vehicle) {
        ParkingSlot parkingSlot = null;
        for (ParkingFloor parkingFloor : parkingFloors) {
            parkingSlot = parkingFloor.getRelevantSlotForVehicleAndPark(vehicle);
            if (parkingSlot != null) {
                break;
            }
        }
        return parkingSlot;
    }

    public double scanAndPay(Ticket ticket) {
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle();
        int duration = (int) ((endTime - ticket.getStartTime()) / 1000);
        double amount = ticket.getParkingSlot().getPricePerHour() * duration;
        ticket.setAmount(amount);
        return amount;
    }

    private void setAmount(double amount) {
        // TODO
    }

    private void getParkingSlot() {
        // TODO
    }
}