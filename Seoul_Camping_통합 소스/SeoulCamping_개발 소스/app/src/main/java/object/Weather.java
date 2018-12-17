package object;

public class Weather {
    String id;
    String temperature;
    String status;
    String RSstatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRSstatus() {
        return RSstatus;
    }

    public void setRSstatus(String RSstatus) {
        this.RSstatus = RSstatus;
    }
}
