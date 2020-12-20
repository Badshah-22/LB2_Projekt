package Model;

public class Seat {

    private int SeatNumber;
    private int SeatRow;
    private int CategoryId;


    public Seat(int seatNumber, int seatRow, int categoryId) {
        SeatNumber = seatNumber;
        SeatRow = seatRow;
        CategoryId = categoryId;
    }



    public int getSeatNumber() {

        return SeatNumber;
    }

    public void setSeatNumber(int seatNumber) {

        SeatNumber = seatNumber;
    }

    public int getSeatRow() {

        return SeatRow;
    }

    public void setSeatRow(int seatRow) {

        SeatRow = seatRow;
    }

    public int getCategoryId() {

        return CategoryId;
    }

    public void setCategoryId(int categoryId) {

        CategoryId = categoryId;
    }

}
