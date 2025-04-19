
public class Vehicle {
    String vehicleNumber;
    VehicleCategory vehicleCategory;

    public Vehicle(String vehicleNumber, VehicleCategory vehicleCategory) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleCategory = vehicleCategory;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }       
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }
    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }
}
