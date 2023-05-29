class ParkingSystem {
    int bigg;
    int mediumm;
    int smalll;
    public ParkingSystem(int big, int medium, int small) {
        bigg = big;
        mediumm = medium;
        smalll = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1){
            bigg--;
            if(bigg < 0) return false;
        }else if( carType == 2) {mediumm--;
                                if(mediumm < 0) return false;
                                }
        else{ smalll--; if(smalll < 0) return false;}
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */