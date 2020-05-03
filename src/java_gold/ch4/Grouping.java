package java_gold.ch4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grouping {
    public static void main(String[] args) {
        Sample sample1 = new Sample("key1", "value1-1");
        Sample sample2 = new Sample("key2", "value2-1");
        Sample sample3 = new Sample("key3", "value3-1");

        Sample sample4 = new Sample("key1", "value1-2");
        Sample sample5 = new Sample("key1", "value1-3");

        Sample sample6 = new Sample("key2", "value2-2");
        Sample sample7 = new Sample("key2", "value2-3");
        Sample sample8 = new Sample("key2", "value2-4");

        Stream<Sample> sampleStream = Stream.of(sample1,sample2,sample3,sample4,sample5,sample6,sample7,sample8);
        Map<String, List<Sample>> groupedMap = sampleStream.collect(Collectors.groupingBy(Sample::getKey));
        groupedMap.forEach((k,l) -> {
            System.out.println("Group : " + k);
            l.forEach(v -> System.out.println(v.getValue()));
            System.out.println("----------");
        });
    }
}

class Sample {
    String key,value;

    public Sample(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
