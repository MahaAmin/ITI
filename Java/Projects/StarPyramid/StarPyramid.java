package starpyramid;

class StarPyramid{
  private int height;

  public StarPyramid(){
    height = 0;
  }

  public StarPyramid(int height){
    this.height = height;
  }

  public void rightPyramid(int height){
    for(int i=0; i<height; i++)
    {
      for(int j=0; j<=i; j++)
        System.out.print("*");
      System.out.println();
  }
}

  public void centerPyramid(int height){
    for(int i=0; i<height; i++)
    {
        for(int j=height-i; j>1; j--)
          System.out.print(" ");

        for(int j=0; j<=i; j++)
          System.out.print("* ");

        System.out.println();
    }
  }


  public void hexagonPyramid(int height){
    for(int i=0; i<height; i++)
    {
        for(int j=height-i; j>1; j--)
          System.out.print(" ");

        for(int j=0; j<=i; j++)
          System.out.print("* ");

        System.out.println();
    }

    for(int i=0; i<height; i++){
      for(int j=0; j<=i; j++)
        System.out.print(" ");
      for(int j=height-i; j>1; j--)
        System.out.print("* ");
      System.out.println();
    }
  }


  public static void main(String[] args){
    StarPyramid myStarPyramid = new StarPyramid();

    System.out.println("Right Pyramid n = 6: ");
    myStarPyramid.rightPyramid(6);
    System.out.println("-----------------------------------");


    System.out.println("Center Pyramid n = 6: ");
    myStarPyramid.centerPyramid(6);
    System.out.println("-----------------------------------");

    System.out.println("Hexagon Pyramid n = 6: ");
    myStarPyramid.hexagonPyramid(6);
    System.out.println("-----------------------------------");
  }
}
