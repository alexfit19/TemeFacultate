package isp.lab5.exercise5;

public class Jungle {
   Herbivorous herbivorous = new Herbivorous() {
       @Override
       public void runSuccesfully() {
           throw new UnsupportedOperationException("Not supported yet."); 
       }

       @Override
       public void runFailed() {
           throw new UnsupportedOperationException("Not supported yet."); 
       }

       @Override
       public int getChancesToRunSuccesfully() {
           throw new UnsupportedOperationException("Not supported yet."); 
       }
   }; 
   Carnivorous carnivorous = new Carnivorous() {
       @Override
       public void huntSuccesfully() {
           throw new UnsupportedOperationException("Not supported yet."); 
       }

       @Override
       public void huntFailed() {
           throw new UnsupportedOperationException("Not supported yet."); 
       }

       @Override
       public int getChancesToHuntSuccesfully() {
           throw new UnsupportedOperationException("Not supported yet."); 
       }
   };
   
   public void Jungle(Herbivorous herbivorous , Carnivorous carnivorous) {}
   
   public void removeAnimalFromHerbivores() {}
   
   public void removeAnimalFromCarnivores() {}
}
