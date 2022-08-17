package work;

import constants.NameConstants;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class NameTest {
    @Test
    public void testName() {
//        this.getComparatorName(NameConstants.name);
//        this.getComparatorName(NameConstants.name古代);
//        this.getComparatorName(NameConstants.name8090);
//        this.getComparatorName(NameConstants.name0010);

        this.comparatorName(
                this.getSequence(NameConstants.name0010,
                        this.getSequence(NameConstants.name8090,
                                this.getSequence(NameConstants.name古代,
                                        this.getSequence(NameConstants.name)
                                )
                        )
                )
        );


    }


    private void getComparatorName(String names) {
        this.comparatorName(this.getSequence(names));
    }

    private HashMap<String, Integer> getSequence(String names, HashMap<String, Integer> map) {
        for (String na : names.split("\n")) {
            String na0 = na.substring(0, 1);
            if (map.containsKey(na0)) {
                map.put(na0, map.get(na0) + 1);
            } else {
                map.put(na0, 1);
            }
            String na1 = na.substring(1, 2);
            if (map.containsKey(na1)) {
                map.put(na1, map.get(na1) + 1);
            } else {
                map.put(na1, 1);
            }
        }
        return map;
    }

    private HashMap<String, Integer> getSequence(String names) {
        HashMap<String, Integer> map = new HashMap<>();
        return getSequence(names, map);
    }

    private void comparatorName(HashMap<String, Integer> sequence) {
        //统计名字中出现的频率
        Comparator<Map.Entry<String, Integer>> descValue = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int i1 = o1.getValue();
                int i2 = o2.getValue();
                if (i1 != i2) {
                    return (i1 > i2) ? -1 : 1;
                }
                return 0;
            }
        };
        Set<Map.Entry<String, Integer>> entries = sequence.entrySet();
        ArrayList<Map.Entry<String, Integer>> entryArrayList = new ArrayList<>(entries);
        Collections.sort(entryArrayList, descValue);
        int a = 0;
        System.out.println("出现很多的 ");
        for (Map.Entry<String, Integer> integerEntry : entryArrayList) {
            if (integerEntry.getValue() < 10) {
                break;
            }
            System.out.print(integerEntry.getKey() + " " + integerEntry.getValue() + "   ");
            a++;
        }
//        Map<Integer, List<String>> collect = entryArrayList.stream().collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
//        System.out.println();
//        System.out.println("较少频率的   六次");
//        System.out.println(String.join("", collect.get(6)));System.out.println("较少频率的   五次");
//        System.out.println(String.join("", collect.get(5)));
//        System.out.println("较少频率的   四次");
//        System.out.println(String.join("", collect.get(4)));
//        System.out.println("较少频率的   三次");
//        System.out.println(String.join("", collect.get(3)));
//        System.out.println("较少频率的   两次");
//        System.out.println(String.join("", collect.get(2)));
//        System.out.println("较少频率的   一次");
//        System.out.println(String.join("", collect.get(1)));

        System.out.println();


    }
}
