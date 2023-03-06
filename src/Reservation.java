public class Reservation {
    private int customerId;
    private int roomId;
    private Date arrivalDate;
    private Date departureDate;

    public Reservation(int customerId, int roomId, Date arrivalDate, Date departureDate) {
        this.customerId = customerId;
        this.roomId = roomId;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}
