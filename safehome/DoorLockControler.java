package isp.lab7.safehome;

import java.util.*;

public class DoorLockControler implements ControllerInterface{
    private Map<Tenant, AccessKey> validAcces = new HashMap<Tenant, AccessKey>();
    private List<AccessKey> accessKeyList = new ArrayList<AccessKey>();
    private List<Tenant> tenants = new ArrayList<Tenant>();
    private List<AccessLog> accessLogs = new ArrayList<AccessLog>();
    private Door door = new Door();
    private int tries = 0;
    private boolean worked = false;

    public DoorLockControler() {
    }

    @Override
    public DoorStatus enterPin(String pin) throws InvalidPinException,TooManyAttemptsException {
        if(pin.equals("MasterKeyValue"))
        {
            System.out.println("The door was opened by master key. The door is unlocked.");
            tries = 0;
            door.unlockDoor();
            return this.door.getStatus();
        }
        else
        {
            if(tries >= 2)
                throw new TooManyAttemptsException("You can't do this anymore. Master key is needed.");
            else
            {

            }
            for(int i = 0; i < accessKeyList.size(); i++){
                if(accessKeyList.get(i).getPin().equals(pin)) {
                    worked = true;
                    if(door.getStatus() == DoorStatus.OPEN) {
                        System.out.println("Door is going to lock.");
                        door.lockDoor();
                    }
                    else {
                        System.out.println("Door is going to unlock.");
                        door.unlockDoor();
                    }
                }
                if(!worked) {
                    tries++;
                    throw new InvalidPinException("Incorrect pin. Try again.");
                }
            }
        }
        worked = false;
        return this.door.getStatus();
    }

    @Override
    public void addTenant(String pin, String tenantName) throws TenantAlreadyExistsException {
        Tenant t = new Tenant(tenantName);
        AccessKey a = new AccessKey(pin);
        tenants.add(t);
        accessKeyList.add(a);

        if(validAcces.isEmpty()) {
            validAcces.put(t, a);
        }
        else {
            for (int i = 0; i < tenants.size() - 1; i++) {
                if (tenants.get(i).getName().equals(t.getName()))
                    throw new TenantAlreadyExistsException(t.getName() + " is already a tenant.");
                else {
                    validAcces.put(t, a);
                }

            }
        }
        System.out.println("Added tenant " + t.getName());
    }

    @Override
    public void removeTenant(String name) throws TenantNotFoundException {
        boolean removed = false;
        for(Map.Entry<Tenant,AccessKey> entry : validAcces.entrySet()){
            if(entry.getKey().getName().equals(name))
            {
                validAcces.remove(entry.getKey());
                removed = true;
                System.out.println(name + " isn't a tenant anymore.");
                break;
            }
        }
        if(removed == false)
            throw new TenantNotFoundException(name + " isn't a tenant.");
    }


    public List<AccessLog> getAccessLogs(){
        return null;
    }
}