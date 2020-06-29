Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.

The comparison of strings is case-insensitive.
Multiple occurances of a keyword in a review should be considred as a single mention.
If keywords are mentioned an equal number of times in reviews, sort alphabetically.

Example 1:

Input:
k = 2
keywords = ["anacell", "cetracular", "betacellular"]
reviews = [
  "Anacell provides the best services in the city",
  "betacellular has awesome services",
  "Best services provided by anacell, everyone should use anacell",
]

Output:
["anacell", "betacellular"]

Explanation:
"anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
Example 2:

Input:
k = 2
keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
reviews = [
  "I love anacell Best services; Best services provided by anacell",
  "betacellular has great services",
  "deltacellular provides much better services than betacellular",
  "cetracular is worse than anacell",
  "Betacellular is better than deltacellular.",
]

Output:
["betacellular", "anacell"]

Explanation:
"betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.




import java.util.*;

public class Main {
    public static class Pair implements Comparable < Pair > {
        String key;
        int val;
        Pair(String key, int val) {
            this.key = key;
            this.val = val;
        }
        public int compareTo(Pair other) {
            if (this.val < other.val) {
                return 1;
            } else if (this.val > other.val) {
                return -1;
            } else {
                return this.key.compareTo(other.key);
            }
        }
    }
    public static void main(String[] args) {

        // write your code here.
        int k = 2;
        String keywords[] = {
            "anacell",
            "betacellular",
            "cetracular",
            "deltacellular",
            "eurocell"
        };
        String reviews[] = {
            "I love anacell Best services; Best services provided by anacell",
            "betacellular has great services",
            "deltacellular provides much better services than betacellular",
            "cetracular is worse than anacell",
            "Betacellular is better than deltacellular."
        };
        HashSet < String > hs = new HashSet < > ();
        HashMap < String, Integer > hm = new HashMap < > ();
        PriorityQueue < Pair > pq = new PriorityQueue < > ();
        for (String key: keywords) {
            hs.add(key.toLowerCase());
        }
        for (String stns: reviews) {
            String stat[] = stns.split(" ");
            HashSet < String > added = new HashSet < > ();
            for (String v: stat) {
                v = v.toLowerCase();
                if (hs.contains(v) && !added.contains(v)) {
                    if (hm.containsKey(v)) {
                        int ov = hm.get(v);
                        int nv = ov + 1;
                        hm.put(v, nv);
                    } else {
                        hm.put(v, 1);
                    }
                    added.add(v);
                }

            }
        }
        for (String key: hm.keySet()) {
            int val = hm.get(key);
            pq.add(new Pair(key, val));
        }
        for (int i = 0; i < k; i++) {
            System.out.println(pq.remove().key);
        }

    }
}