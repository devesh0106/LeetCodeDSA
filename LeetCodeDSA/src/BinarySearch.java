public class BinarySearch {

    public void binarySearch(int key, int size, int[] sortedArray ){
        int low=0;
        int high= size-1;
        int mid= (low+high)/2;
        System.out.println("mid is " +mid);
        if(key==sortedArray[mid]){
            System.out.println("Index of the Key is "+mid+ " located at the center");
        }
        else if(key<sortedArray[mid]){
             for(int i=low;i<mid;i++){
                 if(key==sortedArray[i]){
                     System.out.println("Index of the Key is "+i + " located at left side");
                 }
             }
            }
        else{
            for(int i=mid+1;i<size;i++) {
                if(key==sortedArray[i]) {
                    System.out.println("Index of the Key  is " + i + " located at right side");
                }
            }
        }
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.binarySearch(10,6,new int[]{2,3,5,6,8,10});
    }
}
