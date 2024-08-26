package test;

public class SomeClass {
    public void someMethod(int value) throws CustomException{
        if (value < 0) {
             throw new CustomException("Value không được âm");
        }

         // phần xử lý còn lại.
    }

    public static void main(String[] args){
          SomeClass obj = new SomeClass();
          try{
               obj.someMethod(-1);
          }catch (CustomException e){
             e.printStackTrace();
          }
     }
}
