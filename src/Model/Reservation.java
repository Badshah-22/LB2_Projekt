package Model;

public class Reservation {

    private int ReservationId;
    private int SoccerGameId;
    private int VIPGuestId;
    private int SeatNumber;


    public Reservation(int reservationId, int soccerGameId, int VIPGuestId, int seatNumber) {
        ReservationId = reservationId;
        SoccerGameId = soccerGameId;
        this.VIPGuestId = VIPGuestId;
        SeatNumber = seatNumber;
    }

    public int getReservationId() {

        return ReservationId;
    }

    public void setReservationId(int reservationId) {

        ReservationId = reservationId;
    }

    public int getSoccerGameId() {

        return SoccerGameId;
    }

    public void setSoccerGameId(int soccerGameId) {

        SoccerGameId = soccerGameId;
    }

    public int getVIPGuestId() {

        return VIPGuestId;
    }

    public void setVIPGuestId(int VIPGuestId) {

        this.VIPGuestId = VIPGuestId;
    }

    public int getSeatNumber() {

        return SeatNumber;
    }

    public void setSeatNumber(int seatNumber) {

        SeatNumber = seatNumber;
    }
}
