import java.util.*;

public class que2b {
    private int k;                      
    private Set<Integer> blacklist;     
    private Random random;              

   
    public que2b(int k, int[] blacklisted_ports) {
        this.k = k;
        this.blacklist = new HashSet<>();
        for (int port : blacklisted_ports) {
            blacklist.add(port);
        }
        this.random = new Random();
    }

    
    public int get() {
        int randomPort;

        
        do {
            randomPort = random.nextInt(k);
        } while (blacklist.contains(randomPort));

        return randomPort;
    }

    public static void main(String[] args) {
        int[] blacklisted_ports = {2, 3, 5};
        que2b wrp = new que2b(7, blacklisted_ports);

        
        System.out.println("Random Port 1: " + wrp.get());
        System.out.println("Random Port 2: " + wrp.get());
        System.out.println("Random Port 3: " + wrp.get());
        System.out.println("Random Port 4: " + wrp.get());
        System.out.println("Random Port 5: " + wrp.get());
    }
}
    

