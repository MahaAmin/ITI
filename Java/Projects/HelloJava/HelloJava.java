package hellojava;

class HelloJava{
  public static void main(String[] args){
    int n = args.length;
    System.out.print("Hello ");
    for(int i=0; i<n; i++)
      System.out.print(args[i]+" ");
    System.out.println();
  }
}
