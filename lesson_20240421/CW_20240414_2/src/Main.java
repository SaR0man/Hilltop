import java.util.StringJoiner;

class House {
    private int doorCount;
    private int windowCount;
    private int roomCount;
    private boolean hasSwimPool;
    private boolean hasGarage;
    private boolean hasPet;
    private String furniture;

    public House() {
    }

    public House(int doorCount, int windowCount, int roomCount, boolean hasSwimPool, boolean hasGarage, boolean hasPet, String furniture) {
        this.doorCount = doorCount;
        this.windowCount = windowCount;
        this.roomCount = roomCount;
        this.hasSwimPool = hasSwimPool;
        this.hasGarage = hasGarage;
        this.hasPet = hasPet;
        this.furniture = furniture;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public House setDoorCount(int doorCount) {
        this.doorCount = doorCount;
        return this;
    }

    public int getWindowCount() {
        return windowCount;
    }

    public House setWindowCount(int windowCount) {
        this.windowCount = windowCount;
        return this;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public House setRoomCount(int roomCount) {
        this.roomCount = roomCount;
        return this;
    }

    public boolean isHasSwimPool() {
        return hasSwimPool;
    }

    public House setHasSwimPool(boolean hasSwimPool) {
        this.hasSwimPool = hasSwimPool;
        return this;
    }

    public boolean isHasGarage() {
        return hasGarage;
    }

    public House setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
        return this;
    }

    public boolean isHasPet() {
        return hasPet;
    }

    public House setHasPet(boolean hasPet) {
        this.hasPet = hasPet;
        return this;
    }

    public String getFurniture() {
        return furniture;
    }

    public House setFurniture(String furniture) {
        this.furniture = furniture;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(House.class.getSimpleName()).append(" (")
                .append(doorCount != 0 ? "doorCount: " + doorCount + "; " : "")
                .append(windowCount != 0 ? "windowCount: " + windowCount + "; " : "")
                .append(roomCount != 0 ? "roomCount: " + roomCount + "; " : "")
                .append(hasSwimPool ? "hasSwimPool: " + hasSwimPool + "; " : "")
                .append(hasGarage ? "hasGarage: " + hasGarage + "; " : "")
                .append(hasPet ? "hasPet: " + hasPet + "; " : "")
                .append(furniture != null && !furniture.isEmpty() ? "furniture: '" + furniture + "'; " : "")
                .append(")")
                .toString();
    }
}

public class Main {
    public static void main(String[] args) {
        House house = new House()
                .setDoorCount(2)
                .setWindowCount(4)
                .setHasGarage(true);

        System.out.println(house);
    }
}