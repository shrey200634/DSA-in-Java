package HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class HM {
    public static void main(String[] args) {
        HashMap <String , Integer >map= new HashMap<>();
        map.put("kunal", 99);
        map.put("shrey", 87);
        map.put("rohit", 23);

        System.out.println(map.get("shrey"));
        System.out.println(map.getOrDefault("christ ", 10));
        System.out.println(map.isEmpty());
        System.out.println(map.replace("shrey", 87, 92));
        System.out.println(map);




        
        HashSet<Integer> set = new HashSet<>();
        set.add(56);
        set.add(73);
        set.add(91);
        set.add(43);
        set.add(43);
        
        System.out.println(set);





    }
    
    
}
