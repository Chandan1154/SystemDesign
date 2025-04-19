import java.util.Map;


public class ParkingFloor {
    String name;
    Map<ParkingSlotType,Map<String,ParkingSlot>> parkingSlots;
    
    public ParkingFloor(String name, Map<ParkingSlotType,Map<String,ParkingSlot>> parkingSlots) {
        this.name = name;
        this.parkingSlots = parkingSlots;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Map<ParkingSlotType, Map<String, ParkingSlot>> getParkingSlots() {
        return parkingSlots;
    }
    public void setParkingSlots(Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
   
    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle) {
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = pickCorrectSlot(vehicleCategory);
        Map<String,ParkingSlot> relevntParkingSlot  = parkingSlots.get(parkingSlotType);
        ParkingSlot slot = null;
        for(Map.Entry<String,ParkingSlot> m: relevntParkingSlot.entrySet()){
            if(m.getValue().isAvailable){
                slot = m.getValue();
                slot.addVehicle(vehicle);
                break;
            }
        }
        return slot;
    }

    private ParkingSlotType pickCorrectSlot(VehicleCategory vehicleCategory){
        if(vehicleCategory.equals(VehicleCategory.TwoWheeler)) {
            return ParkingSlotType.TwoWheeler;
        } else if(vehicleCategory.equals(VehicleCategory.Hatchback) || vehicleCategory.equals(VehicleCategory.Sedan)) {
            return ParkingSlotType.Compact;
        } else if(vehicleCategory.equals(VehicleCategory.Bus)) {
            return ParkingSlotType.Medium;
        } else if(vehicleCategory.equals(VehicleCategory.SUV)) {
            return ParkingSlotType.Large;
        }
        return null;
    }
}
