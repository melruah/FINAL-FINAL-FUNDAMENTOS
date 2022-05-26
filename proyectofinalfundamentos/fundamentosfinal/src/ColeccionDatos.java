
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ColeccionDatos {
    private String fileName;
    private ArrayList<Dato> coleccionDatos;

    public ColeccionDatos(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Dato> getCsv(String fileName) {
        ArrayList<Dato> csv = new ArrayList();
        int contadorDatos = 1;

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();

            while(myReader.hasNextLine()) {
                String info = myReader.nextLine().replaceAll("\"", "").replaceAll(",,", ",-1,");
                if (info.endsWith(",")) {
                    info = info + "-1";
                }

                String[] data = info.split(",");
                String station = data[0];
                String name = data[1] + "," + data[2];
                String date = data[3];
                Double prcp = Double.parseDouble(data[4]);
                Double tavg = Double.parseDouble(data[5]);
                Double tmax = Double.parseDouble(data[6]);
                Double tmin = Double.parseDouble(data[7]);
                csv.add(new Dato(station, name, date, prcp, tavg, tmax, tmin));
            }

            for(int i = 0; i < csv.size(); ++i) {
                ++contadorDatos;
            }

            System.out.println("Hay " + contadorDatos + " datos.");
            myReader.close();
        } catch (FileNotFoundException var15) {
            System.out.println("An error occurred.");
            var15.printStackTrace();
        }

        return csv;
    }

    public void setColeccionDatos() {
        this.coleccionDatos = this.getCsv("Medellin.csv");
        System.out.println("El archivo ha sido leido con exito!");
    }

    public Double avgTmax() {
        Double avgTmax = 0.0D;
        int count = 0;

        for(int i = 0; i < this.coleccionDatos.size(); ++i) {
            Double tMax = ((Dato)this.coleccionDatos.get(i)).getTmax();
            if (tMax != -1.0D) {
                avgTmax = avgTmax + tMax;
                ++count;
            }
        }

        return avgTmax / (double)count;
    }

    public Double sumTmin() {
        Double tmin = 0.0D;

        for(int i = 0; i < this.coleccionDatos.size(); ++i) {
            Double tminDato = ((Dato)this.coleccionDatos.get(i)).getTmin();
            if (tmin != -1.0D) {
                tmin = tmin + tminDato;
            }
        }

        return tmin;
    }

    public Double maxTavg() {
        Double tmax = 0.0D;

        for(int i = 0; i < this.coleccionDatos.size(); ++i) {
            Double tavg = ((Dato)this.coleccionDatos.get(i)).getTavg();
            if (tavg > tmax) {
                tmax = tavg;
            }
        }

        return tmax;
    }

    public Double minTavg() {
        Double tmin = 0.0D;

        for(int i = 0; i < this.coleccionDatos.size(); ++i) {
            Double tavg = ((Dato)this.coleccionDatos.get(i)).getTavg();
            if (tavg < tmin) {
                tmin = tavg;
            }
        }

        return tmin;
    }

    public <CSVWriter> void crearCSVNuevo() throws IOException {
        FileWriter nuevoCSV = new FileWriter("NuevoCSV.csv");
        nuevoCSV.append("ID");
        nuevoCSV.append(',');
        nuevoCSV.append("Nombre");
        nuevoCSV.append(',');
        nuevoCSV.append("Carrera");
        nuevoCSV.append(',');
        nuevoCSV.append("Edad");
        nuevoCSV.append('\n');
        nuevoCSV.append("12345");
        nuevoCSV.append(',');
        nuevoCSV.append("Melisa");
        nuevoCSV.append(',');
        nuevoCSV.append("Ing de sistemas");
        nuevoCSV.append(',');
        nuevoCSV.append("17");
        nuevoCSV.append('\n');
        nuevoCSV.append("0918237");
        nuevoCSV.append(',');
        nuevoCSV.append("Sebastian Garzon");
        nuevoCSV.append(',');
        nuevoCSV.append("Ing de sistemas");
        nuevoCSV.append(',');
        nuevoCSV.append("18");
        nuevoCSV.append('\n');
        nuevoCSV.append("93498435");
        nuevoCSV.append(',');
        nuevoCSV.append("Paula Arroyave");
        nuevoCSV.append(',');
        nuevoCSV.append("Ing de sistemas");
        nuevoCSV.append(',');
        nuevoCSV.append("18");
        nuevoCSV.append('\n');
        nuevoCSV.flush();
        nuevoCSV.close();
        System.out.println("CSV creado con exito con nuestros datos!");
    }
}
