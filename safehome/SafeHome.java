package isp.lab7.safehome;

public class SafeHome {

    public static void main(String[] args) throws TenantNotFoundException {
        DoorLockControler dlc = new DoorLockControler();

        try {
            dlc.removeTenant("Alin");
        }
        catch (TenantNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dlc.addTenant("1111","Alin");
        } catch (TenantAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            dlc.addTenant("1001","Dani");
        } catch (TenantAlreadyExistsException e){
            e.printStackTrace();
        }
        try {
            dlc.addTenant("1101","Cercel");
        } catch (TenantAlreadyExistsException e){
            e.printStackTrace();
        }
        try {
            dlc.addTenant("1101","Alin");
        } catch (TenantAlreadyExistsException e){
            e.printStackTrace();
        }
        try {
            dlc.addTenant("1101","Bogdan");
        } catch (TenantAlreadyExistsException e){
            e.printStackTrace();
        }
        try {
            dlc.addTenant("1101","Dan");
        } catch (TenantAlreadyExistsException e){
            e.printStackTrace();
        }

        try {
            dlc.removeTenant("Dan");
        } catch (TenantNotFoundException e){
            e.printStackTrace();
        }
        try {
            dlc.removeTenant("Dan");
        } catch (TenantNotFoundException e){
            e.printStackTrace();
        }

        try {
            dlc.enterPin("1111");
        } catch (InvalidPinException e) {
            e.printStackTrace();
        } catch (TooManyAttemptsException e) {
            e.printStackTrace();
        }
        try {
            dlc.enterPin("5555");
        } catch (InvalidPinException e) {
            e.printStackTrace();
        } catch (TooManyAttemptsException e) {
            e.printStackTrace();
        }

        try {
            dlc.enterPin("5555");
        } catch (InvalidPinException e) {
            e.printStackTrace();
        } catch (TooManyAttemptsException e) {
            e.printStackTrace();
        }
        try {
            dlc.enterPin("5555");
        } catch (InvalidPinException e) {
            e.printStackTrace();
        } catch (TooManyAttemptsException e) {
            e.printStackTrace();
        }

        try {
            dlc.enterPin("5555");
        } catch (InvalidPinException e) {
            e.printStackTrace();
        } catch (TooManyAttemptsException e) {
            e.printStackTrace();
        }
        try {
            dlc.enterPin("MasterKeyValue");
        } catch (InvalidPinException e) {
            e.printStackTrace();
        } catch (TooManyAttemptsException e) {
            e.printStackTrace();
        }
        try {
            dlc.enterPin("1111");
        } catch (InvalidPinException e) {
            e.printStackTrace();
        } catch (TooManyAttemptsException e) {
            e.printStackTrace();
        }
    }
}
