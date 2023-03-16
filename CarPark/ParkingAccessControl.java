/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp.lab8.carparkaccess;


import isp.lab8.carparkaccess.file.FilesAndFoldersUtil;
import isp.lab8.carparkaccess.file.SerializableUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParkingAccessControl {

    public static final int MAX_CAPACITY = 5;
    private static int CURRENT_CAPACITY = 0;
    private int UNIT_PRICE = 1;
    Map<String, List<Integer>> carRegistry = new HashMap<String, List<Integer>>();
    Map<String, List<Long>> carEntryTime = new HashMap<String, List<Long>>();
    private String working_folder="C:\\Users\\Alex\\Desktop\\parkedCars";
    private String history_folder = "C:\\Users\\Alex\\Desktop\\parkHistory";
    
    
    private ArrayList<Car>  parkedCars = new ArrayList<>();
    private ArrayList<Car>  previousCars = new ArrayList<>(); 

    public void carEntry(Car car){
        //1. sa verific capacitatea 
        //2. daca capacitatea este depasita -> return 
        //3. verific daca nu cumva masina este deja in parcare, si daca este -> return 
        //4. daca masina nu este in parcare salvez obiectul de tip car in parkedCars 
        try {
            List<String> files = FilesAndFoldersUtil.getFilesInFolder(working_folder);
            if(files.size() >= MAX_CAPACITY){
                System.out.println("\n\n\t\t\t\t\t\t\t\t\t!!! No parking spots available !!!\n\n");
            }
            else
            {
                boolean parked = false;

                for(String f: files){
                    Car v = (Car)SerializableUtil.readVehicle(working_folder+"\\"+f);
                    if(v.getPlateNumber().equals(car.getPlateNumber())){
                        System.out.println("\n\t\t\t\t\t\t\t!!! There is a car with serial number: " + car.getPlateNumber() + " already parked !!!\n");
                        parked = true;
                        break;
                    }
                }

                if(parked == false){
                    car.addEntry();
                    SerializableUtil.writeVehicle(car, working_folder+"\\"+"car_"+car.getPlateNumber()+".dat");
                    SerializableUtil.writeVehicle(car, history_folder+"\\"+"car_"+car.getPlateNumber()+".dat");
                    if(!carEntryTime.containsKey(car.getPlateNumber())){
                        carEntryTime.put(car.getPlateNumber(),new ArrayList<Long>());
                    }
                    carEntryTime.get(car.getPlateNumber()).add(car.getEntryTime());
                    System.out.println("Car  with  << " + car.getPlateNumber() + " >>  plate number just got in.");
                    CURRENT_CAPACITY++;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ParkingAccessControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int carExit(String plateNumber) throws IOException, ClassNotFoundException {
        //1. cautam dupa plate number un Car in parkedCars
        //2. daca nu am gasit plateNumber -> return 
        //3. daca am gasit masina, 
            //calculez timpul de asteptare in parcare, -> System.currentTimeMiliseconds()
            //calculez pretul, 
            //sterg masina din parkedCars si o adaug in previousCars
            //returnez pretul
        List<String> files = FilesAndFoldersUtil.getFilesInFolder(working_folder);

        for(String f : files){
            Car v = (Car) isp.lab8.carparkaccess.file.SerializableUtil.readVehicle(working_folder+"\\"+f);
            if(v.getPlateNumber().equals(plateNumber)){
                System.out.println("\n\t\t\t\t\t\t\tCar with  << " + v.getPlateNumber() + " >>  plate number is exiting the parking lot...\n");
                CURRENT_CAPACITY--;
                long stay = (System.currentTimeMillis() - v.getEntryTime())/1000;
                if(!carRegistry.containsKey(plateNumber)){
                    carRegistry.put(plateNumber,new ArrayList<>());
                }
                carRegistry.get(plateNumber).add((int)(stay * UNIT_PRICE));

                FilesAndFoldersUtil.deleteFile(working_folder+"\\car_"+plateNumber+".dat");
                return (int)(stay * UNIT_PRICE);
            }
        }
        System.out.println("\n\t\t\t\t\t\t\tCar with  << " + plateNumber + " >>  plate number doesn't exists in the parking lot...\n");
        return -1;
    }
    

    
    public void viewCurrentCars()throws IOException, ClassNotFoundException {
        System.out.println("\n\n\t\t\t\t\t-.-.- Current vehicles -.-.-");
        List<String> files = FilesAndFoldersUtil.getFilesInFolder(working_folder);
        for(String f : files){
            Car v = (Car) isp.lab8.carparkaccess.file.SerializableUtil.readVehicle(history_folder+"\\"+f);
            System.out.println("   --> Parked vehicle with plate  << " + v.getPlateNumber() + " >>\n\t\t\t\t  * entry time: " 
                    + v.getEntryTime() + "\n\t\t\t\t  * needs to pay: " + (int)((System.currentTimeMillis() - v.getEntryTime())/1000 * UNIT_PRICE) + " RON");
        }
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\tAvailable spaces: " + (MAX_CAPACITY - files.size()) + "\n");
    }
    
    
    public void viewPastEntriesForCar(String plateNumber)throws IOException, ClassNotFoundException {
        List<String> files = FilesAndFoldersUtil.getFilesInFolder(history_folder);
        int totalCost = 0;
        for(String f : files){
            Car v = (Car) isp.lab8.carparkaccess.file.SerializableUtil.readVehicle(history_folder+"\\"+f);
            if(v.getPlateNumber().equals(plateNumber)){
                List<Integer> times = carRegistry.get(plateNumber);
                List<Long> entryTimes = carEntryTime.get(plateNumber);
                for(int i = 0; i < times.size(); i++) {
                    System.out.println("Car with plate number:  << " + plateNumber + " >>\n\t\t\t  * entered at: " + entryTimes.get(i) 
                            + "\n\t\t\t  * stayed for: " + times.get(i) + "\n\t\t\t  * paid " + times.get(i) + " RON");
                    totalCost = times.get(i) + totalCost;
                }
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tTOTAL COST: " + totalCost);
    }
    
    public void viewPastUniqueEntries() throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("Verify in database....");
        System.out.println("Load history of parked cars...");
        System.out.print("Display in 3 ");
        TimeUnit.MILLISECONDS.sleep(800);
        System.out.print("2 ");
        TimeUnit.MILLISECONDS.sleep(800);
        System.out.print("1...\n\n");
        TimeUnit.MILLISECONDS.sleep(800);
        List<String> files = FilesAndFoldersUtil.getFilesInFolder(history_folder);
        for(String f : files){
            Car v = (Car) isp.lab8.carparkaccess.file.SerializableUtil.readVehicle(history_folder+"\\"+f);
            System.out.println("\t\t\t*_*_* Car with  << " + v.getPlateNumber() + " >>  plate number, entered for: " + v.getNumberOfEntries());
        }
    }

    
}
