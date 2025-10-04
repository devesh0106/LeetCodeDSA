package DataStructure.GreedyAlgo;

import java.util.*;

/**
 * Basic Greedy Algorithms Implementation
 */
public class BasicGreedyAlgorithms {
    
    /**
     * Activity Selection Problem
     * Select maximum number of activities that can be performed by a single person
     */
    public static class ActivitySelection {
        private static class Activity {
            int start, finish;
            
            Activity(int start, int finish) {
                this.start = start;
                this.finish = finish;
            }
        }
        
        public static List<Activity> selectActivities(Activity[] activities) {
            List<Activity> selected = new ArrayList<>();
            
            if (activities.length == 0) return selected;
            
            // Sort activities by finish time
            Arrays.sort(activities, (a, b) -> Integer.compare(a.finish, b.finish));
            
            // Select first activity
            selected.add(activities[0]);
            int lastFinish = activities[0].finish;
            
            // Check remaining activities
            for (int i = 1; i < activities.length; i++) {
                if (activities[i].start >= lastFinish) {
                    selected.add(activities[i]);
                    lastFinish = activities[i].finish;
                }
            }
            
            return selected;
        }
        
        public static void testActivitySelection() {
            Activity[] activities = {
                new Activity(1, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(3, 8),
                new Activity(5, 9),
                new Activity(6, 10),
                new Activity(8, 11),
                new Activity(8, 12),
                new Activity(2, 13),
                new Activity(12, 14)
            };
            
            List<Activity> selected = selectActivities(activities);
            System.out.println("Selected Activities:");
            for (Activity activity : selected) {
                System.out.println("[" + activity.start + ", " + activity.finish + "]");
            }
            System.out.println("Total activities selected: " + selected.size());
        }
    }
    
    /**
     * Fractional Knapsack Problem
     * Fill knapsack with items to maximize value (can take fractions of items)
     */
    public static class FractionalKnapsack {
        private static class Item {
            int weight, value;
            double valuePerWeight;
            
            Item(int weight, int value) {
                this.weight = weight;
                this.value = value;
                this.valuePerWeight = (double) value / weight;
            }
        }
        
        public static double getMaxValue(int[] weights, int[] values, int capacity) {
            int n = weights.length;
            Item[] items = new Item[n];
            
            for (int i = 0; i < n; i++) {
                items[i] = new Item(weights[i], values[i]);
            }
            
            // Sort items by value per weight (descending)
            Arrays.sort(items, (a, b) -> Double.compare(b.valuePerWeight, a.valuePerWeight));
            
            double totalValue = 0.0;
            int remainingCapacity = capacity;
            
            for (Item item : items) {
                if (remainingCapacity >= item.weight) {
                    // Take the whole item
                    totalValue += item.value;
                    remainingCapacity -= item.weight;
                    System.out.println("Added item with weight " + item.weight + 
                                     ", value " + item.value + " (full)");
                } else {
                    // Take fraction of the item
                    double fraction = (double) remainingCapacity / item.weight;
                    totalValue += item.value * fraction;
                    System.out.println("Added item with weight " + item.weight + 
                                     ", value " + item.value + " (fraction: " + 
                                     String.format("%.2f", fraction) + ")");
                    break;
                }
            }
            
            return totalValue;
        }
        
        public static void testFractionalKnapsack() {
            int[] weights = {10, 20, 30};
            int[] values = {60, 100, 120};
            int capacity = 50;
            
            double maxValue = getMaxValue(weights, values, capacity);
            System.out.println("Maximum value: " + String.format("%.2f", maxValue));
        }
    }
    
    /**
     * Huffman Coding
     * Variable-length encoding for data compression
     */
    public static class HuffmanCoding {
        private static class HuffmanNode implements Comparable<HuffmanNode> {
            char data;
            int frequency;
            HuffmanNode left, right;
            
            HuffmanNode(char data, int frequency) {
                this.data = data;
                this.frequency = frequency;
                this.left = this.right = null;
            }
            
            @Override
            public int compareTo(HuffmanNode other) {
                return this.frequency - other.frequency;
            }
        }
        
        private static class HuffmanCode {
            char character;
            String code;
            
            HuffmanCode(char character, String code) {
                this.character = character;
                this.code = code;
            }
        }
        
        public static List<HuffmanCode> buildHuffmanCodes(char[] characters, int[] frequencies) {
            PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
            
            // Create leaf nodes
            for (int i = 0; i < characters.length; i++) {
                pq.add(new HuffmanNode(characters[i], frequencies[i]));
            }
            
            // Build Huffman tree
            while (pq.size() > 1) {
                HuffmanNode left = pq.poll();
                HuffmanNode right = pq.poll();
                
                HuffmanNode internal = new HuffmanNode('\0', left.frequency + right.frequency);
                internal.left = left;
                internal.right = right;
                
                pq.add(internal);
            }
            
            // Generate codes
            List<HuffmanCode> codes = new ArrayList<>();
            generateCodes(pq.peek(), "", codes);
            
            return codes;
        }
        
        private static void generateCodes(HuffmanNode root, String code, List<HuffmanCode> codes) {
            if (root == null) return;
            
            if (root.left == null && root.right == null) {
                codes.add(new HuffmanCode(root.data, code));
                return;
            }
            
            generateCodes(root.left, code + "0", codes);
            generateCodes(root.right, code + "1", codes);
        }
        
        public static void testHuffmanCoding() {
            char[] characters = {'a', 'b', 'c', 'd', 'e', 'f'};
            int[] frequencies = {5, 9, 12, 13, 16, 45};
            
            List<HuffmanCode> codes = buildHuffmanCodes(characters, frequencies);
            
            System.out.println("Huffman Codes:");
            for (HuffmanCode code : codes) {
                System.out.println(code.character + ": " + code.code);
            }
        }
    }
    
    /**
     * Minimum Spanning Tree - Kruskal's Algorithm
     */
    public static class KruskalMST {
        private static class Edge implements Comparable<Edge> {
            int src, dest, weight;
            
            Edge(int src, int dest, int weight) {
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }
            
            @Override
            public int compareTo(Edge other) {
                return this.weight - other.weight;
            }
        }
        
        private static class DisjointSet {
            private int[] parent, rank;
            
            DisjointSet(int n) {
                parent = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }
            
            int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }
            
            void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                
                if (rootX == rootY) return;
                
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
        
        public static List<Edge> kruskalMST(Edge[] edges, int vertices) {
            List<Edge> mst = new ArrayList<>();
            Arrays.sort(edges);
            
            DisjointSet ds = new DisjointSet(vertices);
            
            for (Edge edge : edges) {
                int srcRoot = ds.find(edge.src);
                int destRoot = ds.find(edge.dest);
                
                if (srcRoot != destRoot) {
                    mst.add(edge);
                    ds.union(srcRoot, destRoot);
                }
            }
            
            return mst;
        }
        
        public static void testKruskalMST() {
            int vertices = 4;
            Edge[] edges = {
                new Edge(0, 1, 10),
                new Edge(0, 2, 6),
                new Edge(0, 3, 5),
                new Edge(1, 3, 15),
                new Edge(2, 3, 4)
            };
            
            List<Edge> mst = kruskalMST(edges, vertices);
            
            System.out.println("Minimum Spanning Tree (Kruskal):");
            int totalWeight = 0;
            for (Edge edge : mst) {
                System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
                totalWeight += edge.weight;
            }
            System.out.println("Total weight: " + totalWeight);
        }
    }
    
    /**
     * Job Sequencing Problem
     * Schedule jobs to maximize profit with deadlines
     */
    public static class JobSequencing {
        private static class Job {
            char id;
            int deadline, profit;
            
            Job(char id, int deadline, int profit) {
                this.id = id;
                this.deadline = deadline;
                this.profit = profit;
            }
        }
        
        public static List<Job> scheduleJobs(Job[] jobs) {
            // Sort jobs by profit (descending)
            Arrays.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));
            
            int maxDeadline = 0;
            for (Job job : jobs) {
                maxDeadline = Math.max(maxDeadline, job.deadline);
            }
            
            boolean[] slots = new boolean[maxDeadline];
            List<Job> scheduledJobs = new ArrayList<>();
            
            for (Job job : jobs) {
                // Find latest available slot before deadline
                for (int i = Math.min(job.deadline - 1, maxDeadline - 1); i >= 0; i--) {
                    if (!slots[i]) {
                        slots[i] = true;
                        scheduledJobs.add(job);
                        break;
                    }
                }
            }
            
            return scheduledJobs;
        }
        
        public static void testJobSequencing() {
            Job[] jobs = {
                new Job('a', 2, 100),
                new Job('b', 1, 19),
                new Job('c', 2, 27),
                new Job('d', 1, 25),
                new Job('e', 3, 15)
            };
            
            List<Job> scheduled = scheduleJobs(jobs);
            
            System.out.println("Scheduled Jobs:");
            int totalProfit = 0;
            for (Job job : scheduled) {
                System.out.println("Job " + job.id + " (profit: " + job.profit + 
                                 ", deadline: " + job.deadline + ")");
                totalProfit += job.profit;
            }
            System.out.println("Total profit: " + totalProfit);
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Basic Greedy Algorithms ===\n");
        
        // Test Activity Selection
        System.out.println("1. Activity Selection Problem:");
        ActivitySelection.testActivitySelection();
        System.out.println();
        
        // Test Fractional Knapsack
        System.out.println("2. Fractional Knapsack Problem:");
        FractionalKnapsack.testFractionalKnapsack();
        System.out.println();
        
        // Test Huffman Coding
        System.out.println("3. Huffman Coding:");
        HuffmanCoding.testHuffmanCoding();
        System.out.println();
        
        // Test Kruskal's MST
        System.out.println("4. Kruskal's Minimum Spanning Tree:");
        KruskalMST.testKruskalMST();
        System.out.println();
        
        // Test Job Sequencing
        System.out.println("5. Job Sequencing Problem:");
        JobSequencing.testJobSequencing();
    }
}
