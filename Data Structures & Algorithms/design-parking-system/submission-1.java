class ParkingSystem {

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    public boolean addCar(int carType) {

        // Time: O(1)
        // Space: O(1)
        if(carType == 1 && big > 0) {
            this.big--;
            return true;
        } else if (carType == 2 && medium > 0) {
            this.medium--;
            return true;
        } else if (carType == 3 && small > 0) {
            this.small--;
            return true;
        }

        return false;
    }
}
