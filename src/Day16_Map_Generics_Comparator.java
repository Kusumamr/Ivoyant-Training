import java.util.*;


public class Day16_Map_Generics_Comparator {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        System.out.println("Enter the sentence : ");
        String sentence=in.nextLine();
        String[] words=sentence.split(" ");

        HashMap<String , Integer> map=new HashMap<>();
        for (String word : words){
            if (map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }else{
                map.put(word,1);
            }
        }
        for(String key : map.keySet()){
            System.out.println(key + " : " + map.get(key));
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1,
                               Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue()); // Descending
            }
        });

        System.out.println("Sorted by Frequency:");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
