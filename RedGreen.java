import java.util.*;

public class RedGreen {
    
    public static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public static ArrayList<String> numList = new ArrayList<String>();
    public static StringBuilder str = new StringBuilder();
    
    public static void main(String [] args){
        
        Scanner scan = new Scanner(System.in);
        String line;
        
        while(scan.hasNextLine()){
            line = scan.nextLine();
            if(!line.contains("#") && line.length() != 0){
                numList.add(line);
            }
        }
        for(String num : numList){
            String [] nums = num.split(" ");
            
            if (nums.length == 2 && nums[0].matches("\\d+") && nums[1].matches("\\d+")) {
                int start = Integer.parseInt(nums[0]);
                int end = Integer.parseInt(nums[1]);
                nearFactor(start,end);
                System.out.println(nums[0] + " " + nums[1]);
                System.out.println("# " + str);
            } else {
                System.out.println("Invalid Input");
            }
            str.delete(0,str.length());
        }
    }
    
    public static void nearFactor(int start,int end){
        
        map.put(1,1);

        //str.append("G");
        
        
        for(int i = start; i < end+start;i++){
            //System.out.print(i);
            
            int numReds = 0;
            int numGreens = 0;
            
            if(map.get(i) == null){
                //System.out.print(i);
                Set<Integer> factors = new HashSet<Integer>();
                
                for(int j = 1; j < i;j++){
                    factors.add(i/j);
                    //System.out.print(i/j);
                }
                if(i == 2) factors.add(1);
                if(i == 3) factors.add(1);
                for(Integer fac : factors){
                    if (map.get(fac) != null) {
                        if(map.get(fac) == 1){
                            numGreens++;
                        } else {
                            numReds++;
                        }
                    }
                }
            }
            
            
            if(numGreens > numReds){
                map.put(i, -1);
                str.append("R");
            } else {
                map.put(i,1);
                str.append("G");
            }
        }
        
    }
}




