package payloads;

public class ObjectPayload {


    private String name;
    private Data data;

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for data
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    // Inner class for data object
    public static class Data {

        private int year;
        private double price;
        private String CPUModel;
        private String hardDiskSize;

        // Getter and Setter for year
        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        // Getter and Setter for price
        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        // Getter and Setter for CPUModel
        public String getCPUModel() {
            return CPUModel;
        }

        public void setCPUModel(String CPUModel) {
            this.CPUModel = CPUModel;
        }

        // Getter and Setter for hardDiskSize
        public String getHardDiskSize() {
            return hardDiskSize;
        }

        public void setHardDiskSize(String hardDiskSize) {
            this.hardDiskSize = hardDiskSize;
        }
    }
}
