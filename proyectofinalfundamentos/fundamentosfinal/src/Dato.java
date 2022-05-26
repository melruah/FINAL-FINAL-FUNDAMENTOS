public class Dato {
  private String station;
  private String name;
  private String date;
  private Double prcp;
  private Double tavg;
  private Double tmax;
  private Double tmin;

  public Dato(String station, String name, String date, Double prcp, Double tavg, Double tmax, Double tmin) {
      this.station = station;
      this.name = name;
      this.date = date;
      this.prcp = prcp;
      this.tavg = tavg;
      this.tmax = tmax;
      this.tmin = tmin;
  }

  public String getStation() {
      return this.station;
  }

  public String getName() {
      return this.name;
  }

  public String getDate() {
      return this.date;
  }

  public Double getPrcp() {
      return this.prcp;
  }

  public Double getTavg() {
      return this.tavg;
  }

  public Double getTmax() {
      return this.tmax;
  }

  public Double getTmin() {
      return this.tmin;
  }
}
