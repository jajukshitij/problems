public class Vehicle{

    private final int size;
    private final String licenceNumber;
    private ParkingLot parkingLot;

    public Vehicle(String licenceNumber, int size){
    
        this.licenceNumber = licenceNumber;
        this.size = size;
        this.parkingLot = ParkingLot.getInstance();
    }

    public Slot findSlot(){
        Slot slot;

        switch (this.size){
            case 1:
                slot = parkingLot.getSmallSlots().remove(0);

            case 2:
                slot = parkingLot.getCompactSlots().remove(0);

            case 3:
                slot = parkingLot.getLargeSlots().remove(0);

            default:
                slot = null;
        }

        return slot;
    }

    public void park(){
        Slot slot = findSlot();

        if(slot!= null){
            slot.occupy(this);
            parkingLot.occupiedSlots.put(this.licenceNumber, slot);
        }
    }

    public void leave(){
        Slot slot = parkingLot.occupiedSlots.remove(this.licenceNumber);
        slot.release();

        switch(this.size){
            case 1:
                parkingLot.getSmallSlots().add(slot);

            case 2:
                parkingLot.getCompactSlots().add(slot);

            case 3:
                parkingLot.getLargeSlots().add(slot);
        }

    }

}
