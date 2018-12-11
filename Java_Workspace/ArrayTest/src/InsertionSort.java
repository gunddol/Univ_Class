public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {5,7,2,3,9,0,4,6,10};
        arr = insertSort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    private static int[] insertSort(int[] _arr){
        int i, j;
        int key;

        for(i=1;i<_arr.length;i++){
            key = _arr[i];
            for(j=i-1;j>=0;j--){
                if(_arr[j] > key){
                    _arr[j+1] = _arr[j];
                }else{
                    break;
                }
            }
            _arr[j+1] = key;
        }
        return _arr;
    }
}
