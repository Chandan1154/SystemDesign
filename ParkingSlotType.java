
public enum ParkingSlotType {

    TwoWheeler {
        @Override
        public double getPriceForParking(long duration) {
            return duration * 0.05;
        }
    },
  Compact{
        @Override
        public double getPriceForParking(long duration) {
            return duration * 0.1;
        }
    },
    Large{
        @Override
        public double getPriceForParking(long duration) {
            return duration * 0.2;
        }
    },
    Medium{
        @Override
        public double getPriceForParking(long duration) {
            return duration * 0.15;
        }
    };

    public abstract double getPriceForParking(long duration);

}
