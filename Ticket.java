
public class Ticket {
    String ticketNumber;
    long startTime;
    long endTime;
    Vehicle vehicle;
    ParkingSlot parkingSlot;
    public Object getParkingSlot;

    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot){
        return Ticket.builder()
                .parkingSlot(parkingSlot)
                .parkingSlot(parkingSlot)
                .startTime(System.currentTimeMillis())
                .vehicle(vehicle)
                .ticketNumber(vehicle.getVehicleNumber()+ System.currentTimeMillis())
                .build(); 
    }

    public String getTicketNumber() {
        return ticketNumber;
    }
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }   
    public long getStartTime() {
        return startTime;
    }
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    public long getEndTime() {
        return endTime;
    }
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }
    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
    public static TicketBuilder builder() {
        return new TicketBuilder();
    }
    public static class TicketBuilder {
        private String ticketNumber;
        private long startTime;
        private long endTime;
        private Vehicle vehicle;
        private ParkingSlot parkingSlot;

        public TicketBuilder ticketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public TicketBuilder startTime(long startTime) {
            this.startTime = startTime;
            return this;
        }

        public TicketBuilder endTime(long endTime) {
            this.endTime = endTime;
            return this;
        }

        public TicketBuilder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public TicketBuilder parkingSlot(ParkingSlot parkingSlot) {
            this.parkingSlot = parkingSlot;
            return this;
        }

        public Ticket build() {
            Ticket ticket = new Ticket();
            ticket.ticketNumber = this.ticketNumber;
            ticket.startTime = this.startTime;
            ticket.endTime = this.endTime;
            ticket.vehicle = this.vehicle;
            ticket.parkingSlot = this.parkingSlot;
            return ticket;
        }
    }
    public double calculateTotalCost() {
        long duration = endTime - startTime;
        double cost = 0.0;
        if (duration <= 3600000) { // 1 hour
            cost = 10.0; // flat rate for first hour
        } else {
            cost = 10.0 + ((duration - 3600000) / 3600000) * 5.0; // $5 per additional hour
        }
        return cost;
    }
    public void pay() {
        double totalCost = calculateTotalCost();
        System.out.println("Total cost for vehicle " + vehicle.getVehicleNumber() + " is: $" + totalCost);
        // Here you can implement payment logic
    }
    public void printTicket() {
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
        System.out.println("Parking Slot: " + parkingSlot.getName());
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
    }
    public void setEndTimeAndPrintTicket() {
        this.endTime = System.currentTimeMillis();
        printTicket();
    }
    public void setEndTimeAndPay() {
        this.endTime = System.currentTimeMillis();
        pay();
    }
    public void setEndTimeAndPrintTicketAndPay() {
        this.endTime = System.currentTimeMillis();
        printTicket();
        pay();
    }

    public void setAmount(double amount) {
           // TODO
           int duration = (int) ((endTime - startTime) / 1000);
           double totalCost = amount * duration;
           System.out.println("Total cost for vehicle " + vehicle.getVehicleNumber() + " is: $" + totalCost);
               
    }
}
