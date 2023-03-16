package isp.lab7.safehome;

public interface ControllerInterface {
  ASTER_KEY = "MasterKeyValue";
    String MASTER_TENANT_NAME = "MasterTenant";

    DoorStatus enterPin(String pin) throws Exception;


    void addTenant(String pin, String name) throws Exception;
    void removeTenant(String name) throws Exception;
}
