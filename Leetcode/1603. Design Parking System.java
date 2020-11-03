//https://leetcode.com/problems/design-parking-system/

class ParkingSystem {
    int[] parkingSpace;
    public ParkingSystem(int big, int medium, int small) {
        parkingSpace = new int[3];
        parkingSpace[0] = big;
        parkingSpace[1] = medium;
        parkingSpace[2] = small;
    }
    
    public boolean addCar(int carType) {
        if(parkingSpace[carType - 1] > 0) {
            parkingSpace[carType - 1]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

/*
    Time Complexity: O(1)
    Space Complexity: O(1)
*/